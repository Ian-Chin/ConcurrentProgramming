package ex_16_wait_notifyall;

public class Ex_16_Wait_NotifyAll {
    
   static Integer X = new Integer(0);
   

    public static void main(String[] args) 
    {
        Notifier_Process R1= new Notifier_Process();
        Runnable_Process_1 R2= new Runnable_Process_1();
        Runnable_Process_2 R3= new Runnable_Process_2();
        Runnable_Process_3 R4= new Runnable_Process_3();
 
        Thread T1 = new Thread(R1);
        Thread T2 = new Thread(R2);
        Thread T3 = new Thread(R3);
        Thread T4 = new Thread(R4);
 
        T1.start();
        
        T2.start();
        T3.start();
        T4.start();
        
       try {
           T1.join();
           T2.join();
           T3.join();
           T4.join();
       } catch (InterruptedException ex) {
       }
        System.out.println(Thread.currentThread().getName() +": Program Terminates !");
    }    
}
