package ex_5_threadjoin_2;

public class Ex_5_ThreadJoin_2 {
 // Attributes
    public static int sharedCounter =0;
    
    public static void main(String[] args) 
    {
        System.out.println("The Main Thread Name: " + 
                Thread.currentThread().getName() + " : " + 
                Thread.currentThread().getId());
        // Creaating the Thread Objects
        BigThreadProcess P1 = new BigThreadProcess();
      
        Thread T1 = new Thread(P1);
        Thread T2 = new Thread(P1);
        Thread T3 = new Thread(P1);
        
        // Start both threads
        T1.start();
        
        // Join point for T1
        try 
        {
            T1.join();
        }
        catch (InterruptedException e) 
        {
        }
        
        T2.start();

        // Join point for T2
        try 
        {
            T2.join();
        }
        catch (InterruptedException e) 
        {
        }

        T3.start();

        try 
        {
            T3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main Thread is Terminated!");
    }    
}
