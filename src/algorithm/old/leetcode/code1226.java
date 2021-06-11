package algorithm.old.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class code1226 {
    public static void main(String[] args) throws InterruptedException {

    }
}

class DiningPhilosophers {
    ReentrantLock[] fork = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };
    Semaphore p = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        p.acquire();
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;
        fork[leftFork].lock();
        fork[rightFork].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        fork[leftFork].unlock();
        fork[rightFork].unlock();
        p.release();
    }
}