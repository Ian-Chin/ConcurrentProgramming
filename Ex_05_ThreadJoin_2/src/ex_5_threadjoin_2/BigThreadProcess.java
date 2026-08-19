package ex_5_threadjoin_2;

public class BigThreadProcess implements Runnable{
    
    public void run()
    {
        System.out.println(Thread.currentThread().getName()  + " : Started...");
        
        // Creaating the Sub-Thread Objects
        SmallNestedThreadProcess P2_1 = new SmallNestedThreadProcess();
        SmallNestedThreadProcess P2_2 = new SmallNestedThreadProcess();
    
        Thread T4 = new Thread(P2_1);
        Thread T5 = new Thread(P2_2);
    
        T4.start();
        T5.start();
        // Join point for T1
        try 
        {
            T4.join();
            T5.join();
        }
        catch (InterruptedException e) 
        {
        }
        System.out.println(Thread.currentThread().getName()  + " : " +"Completed!");
    }
}