package jjjava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 题目：
 * 描述:
 * <p>
 * 思路：
 */
public class ThreadPool {
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAXIMUM_POOL_SIZE = 3;
    private static final int QUEUE_CAPACITY = 5;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //该方法返回一个可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，但若有空闲线程可以复用，
        //则会优先使用可复用的线程。若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。
        //所有线程在当前任务执行完毕后，将返回线程池进行复用。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，
        //线程池中若有空闲线程，则立即执行。若没有，则新的任务会被暂存在一个任务队列中，
        //待有线程空闲时，便处理在任务队列中的任务。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        //创建一个固定数量的线程池 支持定时及周期性任务执行，scheduledThreadPool.scheduleWithFixedDelay设置周期
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        //方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，
        //任务会被保存在一个任务队列中，待线程空闲，按先入先出的顺序执行队列中的任务。
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable(i);
            try {
                //execute用于执行Runnable
                executor.execute(worker);
            } catch (Exception e) {
                //加入任务到池中后，因饱和策略而定可能抛出异常
                e.printStackTrace();
            }
        }
        //关闭线程池，会等待线程执行完成
        executor.shutdown();
        //等待线程池结束
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

class MyRunnable implements Runnable {
    public int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        System.out.printf(Thread.currentThread().getName() + " Runnable[%d] start time:%s \n",
                id, df.format(new Date()));
        process();
        System.out.printf(Thread.currentThread().getName() + " Runnable[%d] end time:%s \n",
                id, df.format(new Date()));
    }

    private void process() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}