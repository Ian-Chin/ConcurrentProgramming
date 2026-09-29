package ex_15_wait_notify_2;

import static ex_15_wait_notify_2.Ex_15_Wait_Notify_2.sharedList;

public class Printing_Process implements Runnable
{
    @Override
    public void run() 
    {
        synchronized(sharedList)
        {
            try {
                    System.out.println(Thread.currentThread().getName() +
                            " Printing thread is waiting...");
                    sharedList.wait();
                    // The rest of the function will not be executed till a NOTIFICATION rise up.
                    System.out.println(Thread.currentThread().getName() + 
                            " Executed: " + sharedList.get(0));
            } 
            catch (InterruptedException ex){
            }
        }
    }
}
