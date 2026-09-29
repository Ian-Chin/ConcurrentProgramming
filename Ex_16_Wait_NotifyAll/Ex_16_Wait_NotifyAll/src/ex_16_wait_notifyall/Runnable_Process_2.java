package ex_16_wait_notifyall;

import static ex_16_wait_notifyall.Ex_16_Wait_NotifyAll.X;
import static java.lang.Thread.sleep;

public class Runnable_Process_2 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() +": Waiting !");
        try {
            synchronized(X)
            {
                X.wait();
//                Thread.yield();
                Thread.sleep((int) (Math.random()*3000)); // Simulate some Random time

//                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() +": Executed.");
            }
        } catch (InterruptedException ex) {
        }
    }
}
