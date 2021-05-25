package old.jjjava;


public class abcSynch {

    private Integer count = 27;

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("a", c, a);
        ThreadPrinter pb = new ThreadPrinter("b", a, b);
        ThreadPrinter pc = new ThreadPrinter("c", b, c);
        new Thread(pa).start();
        ;
        Thread.sleep(10);
        new Thread(pb).start();
        ;
        Thread.sleep(10);
        new Thread(pc).start();
        ;
        Thread.sleep(10);
    }
}

class ThreadPrinter implements Runnable {
    private Object prev;
    private Object curr;
    private String name;

    public ThreadPrinter(String name, Object prev, Object curr) {
        this.name = name;
        this.prev = prev;
        this.curr = curr;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            synchronized (prev) {
                synchronized (curr) {
                    System.out.println(name);
                    count++;
                    curr.notifyAll();
                }
                try {
                    if (count == 10) {
                        prev.notifyAll();
                    } else {
                        prev.wait();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}