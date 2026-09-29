package ex_13_threadspriority;

public class Runnable_Process_2 implements Runnable
{
    @Override
    public void run()
    {
    System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority() + " Executed.");
            
        for(int i=0; i<100000;i++)
        {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        System.out.println(Thread.currentThread().getName() + " Priority: " + 
                Thread.currentThread().getPriority() + " DONE.");
    }
}
