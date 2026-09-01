package daemonthreads;

public class Thread_Type_B extends Thread{
    
    @Override
    public void run()
    {
       for(int i=0 ; i<=5 ; i++)
        {
            System.out.println(this.getName() + " Progress: " + i + "%");
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
