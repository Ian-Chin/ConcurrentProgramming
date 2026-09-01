/* Program Description
    The yield() method in Java is used to pause the execution of the current thread temporarily, 
    allowing other threads of the same priority to execute. It's essentially a hint to the 
    scheduler that the current thread is willing to yield its current use of the processor.

    We use yield() method in threads to indicate that the current thread is not doing anything 
    critical and it's a good time to let other threads have a chance to execute. This can help
    in scenarios where threads with similar priority levels need to share the CPU resources 
    fairly, preventing one thread from dominating the CPU time. However, it's important to note 
    that using yield() doesn't guarantee which thread will execute next, as it depends on the 
    thread scheduler.

    In this Example, We create two threads that increment a counter inside a massive loop.
    - Thread A does pure computation.
    - Thread B does computation but calls Thread.yield() on every single iteration.

    If yield() is working, Thread A should finish significantly ahead of Thread B because 
    Thread B keeps handing its CPU time slice back to the scheduler.
*/

package ex_08_3_threadyieldmethod;

public class Ex_08_3_ThreadYieldMethod {
    public static void main(String[] args) {
   // Creaating the Thread Objects
        Runnable_Process_1 P1 = new Runnable_Process_1();
        Runnable_Process_2 P2 = new Runnable_Process_2();
        
        Thread T1 = new Thread(P1);
        Thread T2 = new Thread(P2);
        
        // Start both threads
        T1.start();
        T2.start();
    }
    
}