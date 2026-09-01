package ex_08_3_threadyieldmethod;

public class Runnable_Process_2 implements Runnable{
    
     public void run()
    {
        int counter_B = 0;
        while(counter_B<10000)
        {
            System.out.println("T2 is Executing Statement #" + counter_B++);
            System.out.println("T2 Yielded");
            Thread.yield();
        }
    }
}
