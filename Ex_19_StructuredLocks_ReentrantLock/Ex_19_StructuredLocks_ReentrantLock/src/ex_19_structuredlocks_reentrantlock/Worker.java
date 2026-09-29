package ex_19_structuredlocks_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static ex_19_structuredlocks_reentrantlock.Ex_19_StructuredLocks_ReentrantLock.counter;
import static ex_19_structuredlocks_reentrantlock.Ex_19_StructuredLocks_ReentrantLock.lock;

public class Worker implements Runnable{
    
    // DO NOT define a Lock object for each thread, as it will be useless.   
//        private Lock lock = new ReentrantLock();
    
    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName() + 
                " Created. \"Outside of the Locked Critical Section\"");        
        // Requesting: Acquire the lock
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " Locked.");        
        try {
            // Critical section
            for (int i = 0; i < 5; i++) {
                incrementCounter();
                System.out.println(Thread.currentThread().getName() + 
                        " Counter: " + counter);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
        } finally {
            // Release the lock in a finally block to ensure it's released even if an exception occurs
            System.out.println(Thread.currentThread().getName() + 
                    " Releasing the Lock.");
            lock.unlock();
        }
    }

    private void incrementCounter() 
    {
      counter++;
    }
}
