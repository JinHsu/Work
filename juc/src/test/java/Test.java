import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Test test = new Test();
        System.out.println(test.incrementAndGet(5));
        System.out.println(test.get());

    }


    private static Unsafe unsafe;
    private static long valueOffset;

    private volatile int value = 0;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(Unsafe.class);

            Field field = Test.class.getDeclaredField("value");
            valueOffset = unsafe.objectFieldOffset(field);
            System.out.println(valueOffset);
        } catch (Exception e) {
        }


    }

    public int incrementAndGet(int increment) {
        return unsafe.getAndAddInt(this, valueOffset, increment) + increment;
    }

    public int get() {
        return value;
    }

}
