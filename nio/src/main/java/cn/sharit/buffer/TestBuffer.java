package cn.sharit.buffer;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class TestBuffer {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(20);
        System.out.println("++++++++++++++++++++++++");
        print(buffer);

        // write 写入数据
        for (int i = 1; i <= 5; i++) {
            buffer.put(i);
            System.out.println("++++++++++++put++++++++++++");
            print(buffer);
        }

        // read 读取数据
        buffer.flip(); // 翻转模式
        System.out.println();
        System.out.println("+++++++++++++flip+++++++++++");
        print(buffer);

        System.out.println("+++++++++++++read+++++++++++");
        for (int i = 0; i < 2; i++) {
            System.out.println(buffer.get());
            print(buffer);
        }

        System.out.println("+++++++++++++clear+++++++++++");
        buffer.clear();
        System.out.println(buffer.get());

        System.out.println("+++++++++++++rewind+++++++++++");
        buffer.rewind();
        System.out.println(buffer.get());

        System.out.println("+++++++++++++mark+++++++++++");
        buffer.rewind();
        for (int i = 1; i <= 4; i++) {
            System.out.println(buffer.get());
            if (i == 2) {
                buffer.mark(); // 1 2 3
            }
        }

        buffer.reset();
        System.out.println(buffer.get());


    }

    static void print(Buffer buffer) {
//        System.out.println("position=" + buffer.position() + ", limit=" + buffer.limit() + ", capacity=" + buffer.capacity());
        System.out.println(buffer);
    }

}
