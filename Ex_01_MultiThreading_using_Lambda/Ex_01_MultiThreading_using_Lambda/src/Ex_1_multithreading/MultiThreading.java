package Ex_1_multithreading;

public class MultiThreading {
    public static void main(String[] args) 
    {   
        // Inline Lembda Expression-1
        Thread thread_1 = new Thread(() -> {
            // Sub-Process-1
            for (int i = 0; i < 5; i++) 
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);

                try {
                        Thread.sleep(1000);
                    } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();    
                }
            }
        });
        
        // Inline Lembda Expression-2
        Thread thread_2 = new Thread(() -> {
            // Sub-Process-2
            for (int i = 0; i < 5; i++) 
            {
                System.out.println(Thread.currentThread().getName() + ": " + i);

                try {
                        Thread.sleep(1000);
                    } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();    
                }
            }
        });
        
        thread_1.setName("T1");
        thread_2.setName("T2");

        // Concurrent Execution
        thread_1.start();
        thread_2.start();
    }
}
