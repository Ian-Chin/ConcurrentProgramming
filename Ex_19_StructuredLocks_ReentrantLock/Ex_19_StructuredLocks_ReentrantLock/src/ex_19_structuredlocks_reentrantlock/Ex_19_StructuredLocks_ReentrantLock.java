/*
    In this code example, the ReentrantLock named lock is being used to 
    lock access to the critical section of the code, which is responsible for 
    incrementing the shared counter variable counter. The lock is acquired before
    entering the critical section using lock.lock() and released after completing 
    the critical section using lock.unlock(). This ensures that only ONE thread can 
    execute the critical section at a time, preventing concurrent access and ensuring 
    thread safety when modifying the shared counter variable.

    NOTE: Putting private static ReentrantLock lock = new ReentrantLock(); in the main 
          class allows both threads to access the same lock object. This ensures that 
          both threads synchronize on the same lock, providing mutual exclusion and 
          preventing interference between the threads when executing the critical 
          section. If each thread had its own lock object, synchronization would not 
          be effective as each thread would be acquiring and releasing its own lock 
          independently of the other thread. SO, define one Lock object in the main 
          class, NOT in the Runnable class.
*/

package ex_19_structuredlocks_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex_19_StructuredLocks_ReentrantLock {
    // Create a Common ReentrantLock instance for all the threads, READ THE NOTE ABOVE.
    public static Lock lock = new ReentrantLock();
    public static int counter = 0;
    
    public static void main(String[] args) {
        // Create and start multiple threads
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Worker());
            thread.start();
        }    
    }
}
