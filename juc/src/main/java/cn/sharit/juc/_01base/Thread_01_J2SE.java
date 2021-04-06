package cn.sharit.juc._01base;

public class Thread_01_J2SE {

    public static void main(String[] args) {

    }

    // 自动装箱，拆箱

    /**
     * 0 bipush 99
     * 2 invokestatic #2 <java/lang/Integer.valueOf>
     * 5 astore_0
     * 6 aload_0
     * 7 invokevirtual #3 <java/lang/Integer.intValue>
     * 10 istore_1
     * 11 return
     */
    static void m1() {
        Integer i = 99;
        int j = i;
    }
}
