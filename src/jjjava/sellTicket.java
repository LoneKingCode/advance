package jjjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：三个线程一起卖1000张票，每卖出100张，票价涨100元，原价500，然后最后打印每个线程卖出的票和总钱数
 * 描述:
 * 例如，
 * 思路：
 */
public class sellTicket {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger totalCount = new AtomicInteger(1000);
        AtomicInteger currentPrice = new AtomicInteger(500);
        Object priceLock=new Object();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 3, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        SellThread threadA = new SellThread("线程1", totalCount, currentPrice,priceLock);
        SellThread threadB = new SellThread("线程2", totalCount, currentPrice,priceLock);
        SellThread threadC = new SellThread("线程3", totalCount, currentPrice,priceLock);
        threadPoolExecutor.execute(threadA);
        threadPoolExecutor.execute(threadB);
        threadPoolExecutor.execute(threadC);
        //关闭线程池
        threadPoolExecutor.shutdown();
        //等待结束
        while (!threadPoolExecutor.isTerminated()) {

        }
        System.out.println(threadA);
        System.out.println(threadB);
        System.out.println(threadC);
    }
}

class SellThread implements Runnable {
    private int amount = 0;
    private AtomicInteger totalCount;
    private AtomicInteger currentPrice;
    private  Object priceLock;
    private int sellCount;
    private String name;

    public SellThread(String name, AtomicInteger totalCount, AtomicInteger currentPrice,Object priceLock) {
        this.name = name;
        this.totalCount = totalCount;
        this.currentPrice = currentPrice;
        this.priceLock =priceLock;
    }

    @Override
    public String toString() {
        return name + "---->amount:" + amount + ",sellCount:" + sellCount;
    }

    @Override
    public void run() {
        while (totalCount.get() > 0) {
            int count = totalCount.getAndDecrement();
           synchronized (priceLock)
           {
               amount += currentPrice.get();
               sellCount++;
               if (totalCount.get() % 100 == 0) {
                   System.out.println("涨价,当前价格:" + currentPrice.get());
                   currentPrice.set(currentPrice.get() + 100);
                   System.out.println("涨价完成：" + currentPrice.get());
               }
               priceLock.notifyAll();
           }
        }
    }
}