package cn.sharit.selector;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SelectorTest {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                new Server().start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(() -> {
            try {
                new Client().send();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}

class Client {

    public void send() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        socketChannel.configureBlocking(false);

        while (!socketChannel.finishConnect()) {
        }

        System.out.println("Connected");

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("您好".getBytes());

        byteBuffer.flip();// 翻转为读模式
//        int len = 0;
//        while ((len = socketChannel.write(byteBuffer)) != 0) {
//        }
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();
        socketChannel.close();

    }
}

class Server {

    public void start() throws Exception {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(8888));

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server Started...");
//        selector.select(); // 阻塞调用
//        selector.select(3000); // 带超时的阻塞调用
//        selector.selectNow(); // 非阻塞调用
        while (selector.select() > 0) { // 轮询OP_ACCEPT事件
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectedKey = iterator.next();
                if (selectedKey.isAcceptable()) {
                    // 新连接就绪 准备读取，此时需要注册读取事件
                    SocketChannel socketChannel = serverSocketChannel.accept(); //
                    socketChannel.configureBlocking(false); // 非阻塞

                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectedKey.isReadable()) {
                    // 读取数据
                    SocketChannel channel = (SocketChannel) selectedKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // 默认写

                    int len = -1;
                    while ((len = channel.read(byteBuffer)) > 0) {
                        byteBuffer.flip(); // 翻转为读
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }

                    channel.close();
                } else if (selectedKey.isWritable()) {
                    System.out.println("isWritable");
                }

                iterator.remove(); // 从集合中移出，避免下次重复处理
            }
        }

        serverSocketChannel.close();
    }
}