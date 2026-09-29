package ex_15_wait_notify_2;

import static ex_15_wait_notify_2.Ex_15_Wait_Notify_2.sharedList;

public class Increment_Process implements Runnable
{
    @Override
    public void run() 
    {
        for(int i=0; i<5 ; i++)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            System.out.println(Thread.currentThread().getName() +
                    " Thread is Incrementing...");
            sharedList.set(0, sharedList.get(0)+1);
        }
          
        // After finishing the increment, We notify!
        synchronized (sharedList)
        {
            System.out.println(Thread.currentThread().getName() +
                    " Notification Fired back to the wait()...");
            sharedList.notify();
        }
    }
}
