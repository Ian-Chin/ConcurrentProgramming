package ex_05_threadjoin_1;

public class Ex_05_threadjoin_1 {
    // Attributes
    public static int sharedCounter = 0;
    
    public static void main(String[] args) 
    {
        System.out.println("The Main Thread Name: " + 
                Thread.currentThread().getName() + " : " + 
                Thread.currentThread().getId());
        
        // Creaating the Runnable Process Object
        Runnable_Process P1 = new Runnable_Process();
      
        // Creaating the Thread Objects
        Thread T1 = new Thread(P1);
        Thread T2 = new Thread(P1);
        Thread T3 = new Thread(P1);
        Thread T4 = new Thread(P1);
        
        T1.setName("T1");
        T2.setName("T2");
        T3.setName("T3");
        T4.setName("T4");
        
        // Start thread-1
        T1.start();

        // Join point for T1
        try 
        {
            T1.join();
        }
        catch (InterruptedException e) 
        {
        }
        
        // Start thread-2
        T2.start();

        // Join point for T2
        try 
        {
            T2.join();
        }
        catch (InterruptedException e) 
        {
        }

        // Start both Thread-3 and Thread-4
        T3.start();
        T4.start();

        // Wait for both T3 and T4 threads to complete
        try {
            // NOTE: Adding two joining points, might lead to DEADLOCK.
            T3.join();
            T4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main Thread is Terminated!");
    }   
}
