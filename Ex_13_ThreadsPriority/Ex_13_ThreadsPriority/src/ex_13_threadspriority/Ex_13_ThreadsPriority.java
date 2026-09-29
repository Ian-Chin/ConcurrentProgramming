package ex_13_threadspriority;

public class Ex_13_ThreadsPriority {
    public static void main(String[] args) {

        Runnable_Process_1 P1 = new Runnable_Process_1();
        Runnable_Process_2 P2 = new Runnable_Process_2();
        Runnable_Process_3 P3 = new Runnable_Process_3();
        Runnable_Process_4 P4 = new Runnable_Process_4();
        
        Thread T0 = new Thread(P1);
        Thread T1 = new Thread(P2);
        Thread T2 = new Thread(P3);
        Thread T3 = new Thread(P4);
        
        // Setting Thread Priorities DOES NOT MEAN they will run in the specific order of the priority values.
        // In other words, the highest Priority thread, does not necessarily means it would run first.
        // The thread execution order depends on the Operating System scheduling mechanism.
        // The Priority just to INFLUENCE the Operating system Scheduler deciding the order in which threads are executed.
        T0.setPriority(6);
        T1.setPriority(Thread.MAX_PRIORITY);
        T2.setPriority(Thread.MIN_PRIORITY);
        T3.setPriority(Thread.NORM_PRIORITY);
        
        T0.setName("T0");
        T1.setName("T1");
        T2.setName("T2");
        T3.setName("T3");
        
        // Start the Threads
        T0.start();
        T1.start();
        T2.start();
        T3.start();
    }    
}
