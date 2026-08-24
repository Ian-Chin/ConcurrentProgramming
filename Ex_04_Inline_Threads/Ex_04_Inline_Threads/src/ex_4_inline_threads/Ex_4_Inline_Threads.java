package ex_4_inline_threads;

public class Ex_4_Inline_Threads {
    
    public static void main(String[] args) throws InterruptedException {

        // --- Approach 1: Anonymous Thread subclass ---
        Thread workerA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++)
                {
                    System.out.println("\u001B[31m[A] Step " + i + "\u001B[0m");
                
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        };

        // --- Approach 2: Anonymous Runnable passed to Thread ---
        Thread workerB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++)
                {
                    System.out.println("\u001B[33m[B] Step " + i + "\u001B[0m");
                
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });

        // --- Approach 3: Lambda (Java 8+) ---
        Thread workerC = new Thread(() -> {
            for (int i = 1; i <= 3; i++)
            {
                System.out.println("\u001B[34m[C] Step " + i + "\u001B[0m");
            
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        });

        // Launch all three threads concurrently
        workerA.start();
        workerB.start();
        workerC.start();
        
    }
}