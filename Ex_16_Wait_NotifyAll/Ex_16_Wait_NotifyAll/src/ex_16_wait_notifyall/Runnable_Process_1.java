package ex_16_wait_notifyall;

import static ex_16_wait_notifyall.Ex_16_Wait_NotifyAll.X;

public class Runnable_Process_1 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() +": Waiting !");
        synchronized(X)
        {
            try 
            {
                X.wait();
                Thread.sleep((int) (Math.random()*3000)); // Simulate some Random time
                System.out.println(Thread.currentThread().getName() +": Executed.");
            } catch (InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() +": INTERRUPTED.");
            }
        }
    }
}
