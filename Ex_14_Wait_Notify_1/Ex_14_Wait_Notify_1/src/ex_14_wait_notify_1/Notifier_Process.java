package ex_14_wait_notify_1;

import static ex_14_wait_notify_1.Ex_14_Wait_Notify_1.X;
import static java.lang.Thread.sleep;


public class Notifier_Process implements Runnable
{ 
    @Override
    public synchronized void run()
    {
        // Simulate a delay to make sure that the Waiting function will be called first.
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
        }
        
        System.out.println(Thread.currentThread().getName() +
                ": Notifier been Initiated.");
        
        synchronized(X)
        {
            System.out.println(Thread.currentThread().getName() +": In Progress...");
            X.notify(); // Notify the ONE waiting Thread that this Thread is done with the Locked Object.
            System.out.println(Thread.currentThread().getName() +
                    ": Notification been fired.");
        }
    }
}
