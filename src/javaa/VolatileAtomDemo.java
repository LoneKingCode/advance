package javaa;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 19:48 2019/11/4
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class VolatileAtomDemo {
    volatile int num;
    AtomicInteger atomicNum = new AtomicInteger();

    // Lock lock = new ReentrantLock();
    //synchronized
    public void addNum() {
        //lock.lock();
        num++;
        // lock.unlock();
    }

    public void addAtomicNum() {
        atomicNum.getAndIncrement();
    }

    public static void main(String[] args) {
        VolatileAtomDemo demo = new VolatileAtomDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.addAtomicNum();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\tfinal number result = " + demo.atomicNum.get());
    }
}
