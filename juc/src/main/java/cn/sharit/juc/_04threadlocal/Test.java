package cn.sharit.juc._04threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(tableSizeFor(32));
//
//        System.out.println(Integer.highestOneBit(128 - 1) << 1);
//
//
//        HashMap<String, Object> map = new HashMap<>();
//        for (int i = 0; ; i++) {
//            map.put("" + i, i);
//        }

        Random random = new Random();

        for (; ; ) {
            int i = random.nextInt();

            System.out.println(i & (1 << 4));

            TimeUnit.MILLISECONDS.sleep(10);
        }
//
//        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

//        for (int count = 0; ; ++count) {
//            System.out.println(count);
//            TimeUnit.SECONDS.sleep(1);
//        }

    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

}
