package cn.sharit.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChatClient {

    private Selector selector;
    private InetSocketAddress address;
    private SocketChannel channel;

    public ChatClient() {
        try {
            selector = Selector.open();
            address = new InetSocketAddress("127.0.0.1", 8888);
            channel = SocketChannel.open(address);
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getServerMsg() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(3);
                int readChannels = selector.select();
                if (readChannels > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.configureBlocking(false);
                            readMsg(channel);
                        }

                        iterator.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readMsg(SocketChannel channel) throws IOException {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            if (read > 0) {
                System.out.println(new String(byteBuffer.array()));
            }
        } catch (IOException e) {
            System.out.println("服务器连接断开");
        }
    }

    public void sendMsg(String msg) {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            channel.write(buffer);
            System.out.println(channel.getLocalAddress() + "：" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        new Thread(chatClient::getServerMsg).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }

    }
}
