package jjjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 11:52 2020/2/18
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                100, 100, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(150), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int k = 0; k < 100000; k++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    counter.count();
                    counter.safeCount();
                }
            });
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {

        }
        System.out.println("atomicI:" + counter.atomicI.get());
        System.out.println("i:" + counter.i);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            if (atomicI.compareAndSet(i, ++i)) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
