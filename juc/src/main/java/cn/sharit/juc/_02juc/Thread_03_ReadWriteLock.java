package cn.sharit.juc._02juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Thread_03_ReadWriteLock {
    static Lock lock = new ReentrantLock();
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    static class Demo {

        public int value;

        public int doRead(Lock lock) {
            try {
                lock.lock();
                Thread.sleep(1000);
                return value;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return -1;
            } finally {
                lock.unlock();
            }
        }

        public void doWrite(Lock lock, int value) {
            try {
                lock.lock();
                Thread.sleep(1000);
                this.value += value;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        final Demo demo = new Demo();

        Runnable readThread = new Runnable() {
            @Override
            public void run() {
                demo.doRead(readLock);
//                demo.doRead(lock);
                System.out.println(System.currentTimeMillis());
            }
        };

        Runnable writeThread = new Runnable() {
            @Override
            public void run() {
                demo.doWrite(writeLock, 1);
//                demo.doWrite(lock, 1);
                System.out.println(System.currentTimeMillis());
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(readThread).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(writeThread).start();
        }

    }

}
