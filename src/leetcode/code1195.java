package leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class code1195 {
    public static void main(String[] args) throws InterruptedException {
        Runnable printFizz = () -> {
            System.out.println("fizz");
        };
        Runnable printBuzz = () -> {
            System.out.println("buzz");
        };
        Runnable printFizzBuzz = () -> {
            System.out.println("fizzbuzz");
        };

        FizzBuzz fb = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fb.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.number((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


    }
}

class FizzBuzz {
    private int n;
    public volatile int i = 1;
    private CyclicBarrier barrier = new CyclicBarrier(4);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i <= n && i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException, BrokenBarrierException {
        for (int i = 1; i <= n; i++) {
            if (i <= n && i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException, BrokenBarrierException {
        for (int i = 1; i <= n; i++) {
            if (i <= n && i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException, BrokenBarrierException {
        for (int i = 1; i <= n; i++) {
            if (i <= n && i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
//class FizzBuzz {
//    private int n;
//    public volatile int i = 1;
//    private Object lock = new Object();
//
//    public FizzBuzz(int n) {
//        this.n = n;
//    }
//
//    // printFizz.run() outputs "fizz".
//    public void fizz(Runnable printFizz) throws InterruptedException {
//        while (i <= n) {
//            synchronized (lock) {
//                while (i <= n && i % 3 == 0 && i % 5 != 0) {
//                    printFizz.run();
//                    i++;
//                }
//            }
//        }
//    }
//
//    // printBuzz.run() outputs "buzz".
//    public void buzz(Runnable printBuzz) throws InterruptedException {
//        while (i <= n) {
//            synchronized (lock) {
//                while (i <= n && i % 5 == 0 && i % 3 != 0) {
//                    printBuzz.run();
//                    i++;
//                }
//            }
//        }
//    }
//
//    // printFizzBuzz.run() outputs "fizzbuzz".
//    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        while (i <= n) {
//            synchronized (lock) {
//                while (i <= n && i % 3 == 0 && i % 5 == 0) {
//                    printFizzBuzz.run();
//                    i++;
//                }
//            }
//        }
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void number(IntConsumer printNumber) throws InterruptedException {
//        while (i <= n) {
//            synchronized (lock) {
//                while (i <= n && i % 3 != 0 && i % 5 != 0){
//                    printNumber.accept(i);
//                    i++;
//                }
//            }
//        }
//
//    }
//}