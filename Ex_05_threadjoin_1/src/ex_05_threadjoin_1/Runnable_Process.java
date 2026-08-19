package ex_05_threadjoin_1;

import static ex_05_threadjoin_1.Ex_05_threadjoin_1.sharedCounter;

public class Runnable_Process implements Runnable{
    
    @Override
    public void run()
    {
        sharedCounter++;
        System.out.println(Thread.currentThread().getName()  + " : " 
          + Thread.currentThread().getId()+ " is Executing Statement #" + 
                sharedCounter);
        try 
        {
            Thread.sleep(1000);
        } catch (InterruptedException ex) 
        {}
    }    
}