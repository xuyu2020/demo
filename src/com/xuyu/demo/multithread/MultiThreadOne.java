package com.xuyu.demo.multithread;

/**
 * Created by xuyu on 2020/2/6.
 */
class PrimeRunnable implements Runnable {
    private Thread threadSelf;
    private String threadName;

    PrimeRunnable(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Runnale接口实现线程开始运行：" + threadName);

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(threadName + "运行第" + i + "秒");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (threadSelf == null) {
            threadSelf = new Thread(this, threadName);
            threadSelf.start();
        }
    }
}

class PrimeThread extends Thread {
    private String threadName;

    PrimeThread(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Tread继承线程开始运行：" + threadName);

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(threadName + "运行第" + i + "秒");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadOne {
    public static void main(String args[]) {
        PrimeRunnable R1 = new PrimeRunnable("线程1");
        R1.start();

        PrimeThread R2 = new PrimeThread("线程2");
        R2.start();
    }
}