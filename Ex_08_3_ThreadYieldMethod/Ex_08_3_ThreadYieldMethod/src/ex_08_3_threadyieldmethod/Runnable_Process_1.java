package ex_08_3_threadyieldmethod;

public class Runnable_Process_1 implements Runnable{
    
    public void run()
    {
        int counter_A = 0;
        while(counter_A<10000)
        {
            System.out.println("T1 is Executing Statement #" + counter_A++);

        }
    }
}
