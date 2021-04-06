package cn.sharit.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NServer {


    static List<SocketChannel> scs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.socket().bind(new InetSocketAddress(8888));

        ssc.configureBlocking(false); // OS Non-Blocking

        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                sc.configureBlocking(false);
                scs.add(sc);
            }

            if (!scs.isEmpty()) {
                Iterator<SocketChannel> iterator = scs.iterator();
                while (iterator.hasNext()) {
                    SocketChannel next = iterator.next();
                    ByteBuffer bb = ByteBuffer.allocate(256); // 分配直接内存（堆外内存）
                    int len = next.read(bb);
                    if (len > 0) {
                        System.out.println("接受到消息：" + new String(bb.array()));
                    } else if (len == -1) {
                        iterator.remove();
                    }
                }
            }
        }


    }
}
