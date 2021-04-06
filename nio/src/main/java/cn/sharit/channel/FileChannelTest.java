package cn.sharit.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        writeOnRead();
    }

    // 先读后写
    static void block() throws IOException {
        File file = new File("1.txt").getAbsoluteFile();
        System.out.println(file.getAbsolutePath());

        FileInputStream fis = new FileInputStream(file);
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("3.txt");
        FileChannel fosChannel = fos.getChannel();

        // 将文件读到buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = -1;
        while ((len = fisChannel.read(byteBuffer)) != -1) {

        }
        System.out.println(new String(byteBuffer.array()));

        // 将buffer写入文件
        byteBuffer.flip(); // 读取模式
        int out = 0;
        for (int count = 0; count < 3; count++) {
            while ((out = fosChannel.write(byteBuffer)) != 0) {

            }
            byteBuffer.rewind(); // 读3遍
        }


        // 强制刷新到磁盘
//        fosChannel.force(true);

        // 关闭流
        fosChannel.close();
        fisChannel.close();
    }

    // 边读边写
    static void writeOnRead() throws IOException {
        File file = new File("1.txt").getAbsoluteFile();
        System.out.println(file.getAbsolutePath());

        FileInputStream fis = new FileInputStream(file);
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("3.txt");
        FileChannel fosChannel = fos.getChannel();

        // 将文件通道读到buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = -1;
        int out = 0;
        while ((len = fisChannel.read(byteBuffer)) != -1) {
            // 将buffer写入通道
            byteBuffer.flip(); // 读取模式
            while ((out = fosChannel.write(byteBuffer)) != 0) {

            }
            byteBuffer.clear();// 写入模式
        }
        // 强制刷新到磁盘
//        fosChannel.force(true);

        // 关闭流
        fosChannel.close();
        fisChannel.close();
    }
}
