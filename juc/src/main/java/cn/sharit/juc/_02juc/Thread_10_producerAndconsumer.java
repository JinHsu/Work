package cn.sharit.juc._02juc;

public class Thread_10_producerAndconsumer {

    public static void main(String[] args) {
        Drawer drawer = new Drawer(10);
        Thread producer1 = new Thread(new Producer(drawer), "生产者1");
        Thread producer2 = new Thread(new Producer(drawer), "生产者2");
//        Thread producer3 = new Thread(new Producer(drawer), "生产者3");
        Thread consumer1 = new Thread(new Consumer(drawer), "消费者1");
        Thread consumer2 = new Thread(new Consumer(drawer), "消费者2");
        Thread consumer3 = new Thread(new Consumer(drawer), "消费者3");

        consumer2.start();
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer3.start();
//        producer3.start();
    }

    /**
     * 蒸屉
     */
    static class Drawer {

        private final int capacity; // 蒸屉容量
        private volatile int num = 0; // 当前蒸屉包子数量

        public Drawer(int capacity) {
            this.capacity = capacity;
        }

        /**
         * 生产包子
         */
        public void produce() throws InterruptedException {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (num < capacity) {
                    this.num++;
                    System.out.println(Thread.currentThread().getName() + ",生产包子：" + this.num);
                } else {
                    System.out.println(Thread.currentThread().getName() + ",蒸屉包子已满！");
                    this.wait(); // 暂停生产
                    System.out.println("==========");
                }
                this.notifyAll();//通知去消费或者生产
            }
        }

        /**
         * 消费包子
         */
        public void consume() throws InterruptedException {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (num == 0) {
                    System.out.println(Thread.currentThread().getName() + ",蒸屉没有包子！");
                    this.wait(); // 暂停消费
                    System.out.println("==========");
                } else {
                    this.num--;
                    System.out.println(Thread.currentThread().getName() + ",消费包子：" + this.num);
                }
                this.notifyAll();// 通知去生产或消费
            }
        }

    }

    /**
     * 生产者
     */
    static class Producer implements Runnable {

        private final Drawer drawer;

        Producer(Drawer drawer) {
            this.drawer = drawer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    drawer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 消费者
     */
    static class Consumer implements Runnable {

        private final Drawer drawer;

        Consumer(Drawer drawer) {
            this.drawer = drawer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    drawer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


