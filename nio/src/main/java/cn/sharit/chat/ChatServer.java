package cn.sharit.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private int port = 8888;

    public ChatServer() {
        try {
            selector = Selector.open();

            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务器启动成功。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if (key.isAcceptable()) {
                        SocketChannel channel = serverSocketChannel.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                        System.out.println(channel.getRemoteAddress() + "：上线");
                    } else if (key.isReadable()) {
                        readMsg(key);
                    }

                    //
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readMsg(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        //
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            String msg = new String(byteBuffer.array());
            System.out.println(channel.getRemoteAddress() + "：" + msg);
            sendMsg(channel, msg);
            key.cancel();
            channel.close();
        } catch (IOException ioException) {
            try {
                System.out.println(channel.getRemoteAddress() + "：离线");
            } catch (IOException e) {

            }
        }
    }

    // 转发消息
    private void sendMsg(SocketChannel curChannel, String msg) throws IOException {
        Set<SelectionKey> selectedKeys = selector.keys();
        Iterator<SelectionKey> iterator = selectedKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            SelectableChannel selectableChannel = key.channel();
            if (selectableChannel instanceof SocketChannel && selectableChannel != curChannel) {
                SocketChannel channel = (SocketChannel) selectableChannel;
                ByteBuffer buffer = ByteBuffer.wrap((channel.getRemoteAddress() + "：" + msg).getBytes());
                channel.write(buffer);
            }
//            if (key.isValid()) {
//                iterator.remove();
//            }
        }
    }


    public static void main(String[] args) {
        new ChatServer().start();
    }

}
