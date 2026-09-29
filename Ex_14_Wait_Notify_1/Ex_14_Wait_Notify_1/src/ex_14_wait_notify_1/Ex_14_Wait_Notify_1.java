package ex_14_wait_notify_1;

public class Ex_14_Wait_Notify_1 {

    // Define the Lock Object to be used for the Wait() and Notify() functions
    static Integer X = new Integer(0);
   
    public static void main(String[] args) 
    {
        Notifier_Process Notifier= new Notifier_Process();
        Runnable_Process R2= new Runnable_Process();
        
        Thread T1 = new Thread(Notifier);
        Thread T2 = new Thread(R2);
        
        T1.start();
        T2.start();
        
       try {
           T1.join();
           T2.join();
        } catch (InterruptedException ex) {
           }
 
       // This line will be executed on when both of T1 an T2 are FULLY done with their executon.
       System.out.println(Thread.currentThread().getName() +
               ": Program Terminates !");
    }
    
}
