package cn.sharit.juc._03lock;

import org.openjdk.jol.info.ClassLayout;

public class Lock_01_jol {

    public static void main(String[] args) {
        Object[] o = new Object[7];
//        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
