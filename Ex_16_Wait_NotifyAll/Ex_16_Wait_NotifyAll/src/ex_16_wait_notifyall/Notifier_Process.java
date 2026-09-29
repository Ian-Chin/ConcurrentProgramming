package ex_16_wait_notifyall;

import static ex_16_wait_notifyall.Ex_16_Wait_NotifyAll.X;
import static java.lang.Thread.sleep;

public class Notifier_Process implements Runnable
{ 
    @Override
    public synchronized void run()
    {
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
        }
        System.out.println(Thread.currentThread().getName() +": Notifier been Executed.");
        
        synchronized(X)
        {
//            X.notify();
            X.notifyAll();
            System.out.println(Thread.currentThread().getName() +": ALL Been Notified.");
        }
        
    }
}
