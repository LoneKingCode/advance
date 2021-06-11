package algorithm.old.leetcode;

public class code1114 {
    public static void main(String[] args)  {

    }
}

//CountDownLatch
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch c1 = new CountDownLatch(1);
//        CountDownLatch c2 = new CountDownLatch(1);
//        Runnable r1 = () -> {
//            System.out.println(1);
//            for (int i = 0; i < 10000000; i++) ;
//            System.out.println("1end");
//            c1.countDown();
//        };
//        Runnable r2 = () -> {
//            try {
//                c1.await();
//                System.out.println(2);
//                for (int i = 0; i < 10000000; i++) ;
//                System.out.println("2end");
//                c2.countDown();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        };
//        Runnable r3 = () -> {
//            try {
//                c2.await();
//                System.out.println(3);
//                for (int i = 0; i < 10000000; i++) ;
//                System.out.println("3end");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
//        new Thread(r3).start();
//    }
//}

//Semaphore 信号量
//    public static void main(String[] args) throws InterruptedException {
//        Semaphore s1=new Semaphore(0);
//        Semaphore s2=new Semaphore(0);
//        Runnable r1 = () -> {
//            for (int i = 0; i < 10000000; i++) ;
//            System.out.println("1end");
//            s1.release();
//        };
//        Runnable r2 = () -> {
//            try {
//                s1.acquire();
//                System.out.println(2);
//                for (int i = 0; i < 10000000; i++) ;
//                System.out.println("2end");
//                s2.release();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        Runnable r3 = () -> {
//            try {
//                s2.acquire();
//                System.out.println(3);
//                for (int i = 0; i < 10000000; i++) ;
//                System.out.println("3end");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
//        new Thread(r3).start();
//    }
//}

//volatile+自旋
//public class Main {
//   volatile  static int count = 1;
//    public static void main(String[] args) throws InterruptedException {
//        Runnable r1 = () -> {
//            System.out.println(1);
//            for (int i=0;i<10000000;i++);
//            System.out.println("1end");
//            count++;
//        };
//        Runnable r2 = () -> {
//            while(count!=2);
//            System.out.println(2);
//            for (int i=0;i<10000000;i++);
//            System.out.println("2end");
//            count++;
//        };
//        Runnable r3 = () -> {
//            while(count!=3);
//            System.out.println(3);
//            for (int i=0;i<10000000;i++);
//            System.out.println("3end");
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
//        new Thread(r3).start();
//    }
//
//}

