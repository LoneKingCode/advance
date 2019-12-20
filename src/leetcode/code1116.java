package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class code1116 {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd z = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                z.zero((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                z.even((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                z.odd((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int n;
    CyclicBarrier cb = new CyclicBarrier(3);
    private volatile boolean printZero = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (printZero) ;
            printNumber.accept(0);
            printZero = true;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                while (!printZero) ;
                printNumber.accept(i);
                printZero = false;
            }
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                while (!printZero) ;
                printNumber.accept(i);
                printZero = false;
            }
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}