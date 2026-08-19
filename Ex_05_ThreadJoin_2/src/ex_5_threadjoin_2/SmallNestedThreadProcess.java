package ex_5_threadjoin_2;

public class SmallNestedThreadProcess implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("\tSubThread is Executed: " + 
                Thread.currentThread().getName());
    }
}

