package ex_14_wait_notify_1;

import static ex_14_wait_notify_1.Ex_14_Wait_Notify_1.X;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runnable_Process implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() +": Waiting !");
      
        synchronized(X)
        {
            try 
            {
//                X.wait(4000);   // Will wait for a notification for 4 seconds
                X.wait();     // Will wait for a notification forever!
                System.out.println(Thread.currentThread().getName() +
                        ": Executed.");
            } catch (InterruptedException ex) {
            }
        }
    }
}
