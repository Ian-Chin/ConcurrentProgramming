package daemonthreads;

public class DaemonThreads {

    public static void main(String[] args) 
    {
        Thread_Type_A T1 = new Thread_Type_A();
        Thread_Type_B T2 = new Thread_Type_B();
        Thread_Type_C T3 = new Thread_Type_C();
        Thread_Type_D T4 = new Thread_Type_D();
        
        T1.setName("T1");
        T2.setName("T2");
        T3.setName("T3");
        T4.setName("T4");

        // Setting a thread as a daemon means it will be instantly killed the moment 
        // the main thread (and any other standard user threads) finishes execution.
        
        // Comment/Uncomment this line and check the output difference.
        T1.setDaemon(true);
        

        
        T1.start();
        T2.start();
        T3.start();
        T4.start();
    }
    
}
