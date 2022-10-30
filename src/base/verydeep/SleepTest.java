package base.verydeep;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 7991uxug@gmail.com
 * @date 1/31/23 11:13 PM
 */
public class SleepTest {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()-> {
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
                if (i % 1000 == 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+"finished!");
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("num = " +  num);
    }
}
