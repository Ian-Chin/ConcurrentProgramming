// 1 - Blowing one thread, will NOT effect the other threads.
// 2 - Even if the main program blows up with a runtime error, the already running threads will NOT be effected.

package ex_2_multithreading;

public class Threading extends Thread{

    // Attributes
    private int ThreadNumber;
    
    // Constructor
    public Threading(int threadNumber)
    {
        this.ThreadNumber = threadNumber;
    }
    
    // ***************
    // SUB-PROCESS
    // ***************
    @Override
    public void run()
    {
        for(int i=0; i<5;i++)
        {
            System.out.println(i + " from Thread #" + this.ThreadNumber);
            
            // Simulating a FAKE Error occurs during the execution of Thread-2
            if(this.ThreadNumber==2)
                throw new RuntimeException();
  
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                }
        }
    }
}
