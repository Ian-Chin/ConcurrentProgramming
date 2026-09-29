package ex_12_carparkingsystem;

import static ex_12_carparkingsystem.Ex_12_CarParkingSystem.AvailableLots;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoGate implements Runnable
{
    // Attributes
    public int Q;    // Queue Length
    public int VC;   // Vehicles Count those passing the gate
    
    // Constructor
    public AutoGate()
    {
        this.Q = 0;
        this.VC = 0;
    }
    
    // Setters
    public void setQ(int q)
    {
        this.Q = q;
    }

    // Getters
    public int getQ()
    {
        return this.Q;
    }
    
    // Functional
    @Override
    public void run()
    {
        while(AvailableLots >1800)
        {
            synchronized(this)
            {
                if(this.getQ() > 0)
                {
                    // Check TP Card Validity
                    if (this.TPCheck())
                    {
                        OpenGate();
                        try {
                            Thread.sleep(500);   // Simulating the time to open the gate
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AutoGate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (this.CarPassedTheGate())
                    {
                        CloseGate();
                        try {
                            Thread.sleep(500);   // Simulating the time to the gate needs to close.
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AutoGate.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // Deduct the car that entered the parking from the queue.
                        if(this.Q >0)
                        {
                            this.setQ(this.getQ()-1);
                        }   

                        // Update the number of available Lots.
                        synchronized(AvailableLots)
                        {
                            // Accessing a shared resource makes it a critical section.
                            AvailableLots = AvailableLots - 1;
                        }
                    }
                }
            }
//            try {
//                this.finalize();
//            } catch (Throwable ex) {
//                Logger.getLogger(AutoGate.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println(Thread.currentThread().getName() + ": Finalized.");
//            }           
        } 
        
    }
    
    boolean TPCheck()
    {
        System.out.println(Thread.currentThread().getName() + ": TP had Been Checked and GRANTED ACCESS.");
        return true;
    }
    
    void OpenGate()
    {
        System.out.println(Thread.currentThread().getName() + ": Gate Opened.");       
    }
    
    boolean CarPassedTheGate()
    {
        System.out.println(Thread.currentThread().getName() + ": TP had PASSED the gate.");
        this.VC++;
        return true;
    }
    
    void CloseGate()
    {
        System.out.println(Thread.currentThread().getName() + ": Gate Closed.");       
    }
}