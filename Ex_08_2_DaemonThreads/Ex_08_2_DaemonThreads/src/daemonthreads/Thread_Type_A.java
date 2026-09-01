package daemonthreads;

import java.awt.Toolkit;

public class Thread_Type_A extends Thread{
    
    @Override
    public void run()
    {
        for(int i=0 ; i<=100 ; i++)
        {
            System.out.println(this.getName() + " Progress: " + i + "%");
            Toolkit.getDefaultToolkit().beep();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
