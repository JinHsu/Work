package cn.sharit.juc._03lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class Lock_11 {

    private volatile int a = 0;
    FIFOMutex lock = new FIFOMutex();

    public void test() {
        for (int i = 0; i < 100000; i++) {
//            synchronized (this) {
//                a++;
//            }
            lock.lock();
            a++;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        final Lock_11 lock_11 = new Lock_11();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> lock_11.test(), i + "");
            thread.start();
            ts.add(thread);
        }

        for (int i = 0; i < ts.size(); i++) {
            ts.get(i).join();
        }

        System.out.println(lock_11.a);
        System.out.println("time: " + (System.currentTimeMillis() - l));


//        FIFO fifo = new FIFO();
//        System.out.println(fifo.push(new Thread()));
//        System.out.println(fifo.push(new Thread()));
//        System.out.println(fifo.push(new Thread()));
//
//        System.out.println(fifo.pop());
//        System.out.println(fifo.pop());
//        System.out.println(fifo.pop());
//        System.out.println(fifo.pop());


    }
}


class MyLock {

    private static Unsafe unsafe;
    private volatile int value = 0;
    private static long valueOffset;

    private volatile FIFO fifo = new FIFO();

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(Unsafe.class);

            Field field = MyLock.class.getDeclaredField("value");
            valueOffset = unsafe.objectFieldOffset(field);
        } catch (Exception e) {
            new Error(e);
        }
    }

    public void lock() {
        while (!unsafe.compareAndSwapInt(this, valueOffset, 0, 1)) {
            if (!fifo.contains(Thread.currentThread())) {
                // park当前线程
                LockSupport.park();
                // 并将当前线程加到如等待队列
                fifo.push(Thread.currentThread());
            }

        }
    }

    public void unlock() {
        //
        value = 0;
        Thread t = Thread.currentThread();
        // 获取等待队列的对首线程
        Thread thread = fifo.peek();
        // unpark对首线程
        if (thread == t) {
            fifo.pop();
            LockSupport.unpark(t);
        }

    }


}

/**
 * 用2个栈实现FIFO队列
 */
class FIFO {
    Stack<Thread> left;
    Stack<Thread> right;

    public FIFO() {
        this.left = new Stack<>();
        this.right = new Stack<>();
    }

    // 入队
    public synchronized Thread push(Thread t) {
        return left.push(t);
    }

    // 出队
    public synchronized Thread pop() {
        Thread temp = null;
        while (!left.isEmpty() && (temp = left.pop()) != null) {
            right.push(temp);
        }

        if (!right.isEmpty()) {
            Thread t = right.pop();
            while (!right.isEmpty() && (temp = right.pop()) != null) {
                left.push(temp);
            }
            return t;
        }

        return null;
    }

    public synchronized Thread peek() {
        Thread temp = null;
        while (!left.isEmpty() && (temp = left.pop()) != null) {
            right.push(temp);
        }

        Thread t = right.isEmpty() ? null : right.peek(); //

        if (!right.isEmpty()) {
            while (!right.isEmpty() && (temp = right.pop()) != null) {
                left.push(temp);
            }
        }

        return t;
    }

    public boolean contains(Thread t) {
        return left.contains(t);
    }


}

class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // ignore interrupts while waiting
                wasInterrupted = true;
        }

        waiters.remove();
        if (wasInterrupted)          // reassert interrupt status on exit
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}