package ex_17_carparkingsystem_waitandnotify;

import static ex_17_carparkingsystem_waitandnotify.Ex_17_CarParkingSystem_WaitAndNotify.*;

public class AutoGate implements Runnable
{
    // Attributes
    public int Q;
    public int VehiclesEnterred =0;
    // Constructor
    public AutoGate()
    {
        this.Q = 0;
    }
    
    // Setters
    public synchronized void setQ(int q)
    {
        this.Q = q;
        if (this.getQ()>0)
            this.notify(); // Notify waiting threads
    }

    // Getters
    public synchronized int getQ()
    {
        return this.Q;
    }
    
    // Functional
    @Override
    public synchronized void run()
    {
//        synchronized(counter)
        {
            while(counter >0 && !ParkIsFull)
            {
                if((this.getQ() > 0)  && !ParkIsFull)
                {
                    // If there a vehicle waiting at the queue, Then start the 'Enterring' Process. 
                    // Check TP Card Validity
                    if (this.TPCheck())
                    {
                        OpenGate();
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException ex) {
                        }
                    }

                    if (this.CarPassedTheGate())
                    {
                        CloseGate();
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException ex) {
                        }
                        if(this.getQ() >0)
                        {
                            this.setQ(this.getQ()-1);
                        }   

                        // Update the number of available Lots.
                        synchronized(AvailableLots)
                        {
                            // Accessing a shared resource makes it a critical section.
                            AvailableLots = AvailableLots - 1;
                        }
                        synchronized(counter)
                        {
                            // Accessing a shared resource makes it a critical section.
                            counter--;
                        }
                    }
                }
                else if((this.getQ() == 0)  && !ParkIsFull)  // This.Q equals 0 (There is no Cars queuing at the gate)
                {
                    // If the is is no vehicle in the queue, then wait for a notification of a vehicle arrival.
                    try {
                        System.out.println(Thread.currentThread().getName() + " is WAITING!!! : " + this.getQ() + " in the Queue.");

                        this.wait(); // Wait if no cars are in the queue

                    } catch (InterruptedException ex) {
                    }
                }
                else if (counter==0)
                {
                    ParkIsFull = true;
                    GT1.interrupt();
                    GT2.interrupt();
                    GT3.interrupt();
                    RVA1.interrupt();
                    RVA2.interrupt();
                    RVA3.interrupt();
                }
                try {
                    this.finalize();
                } catch (Throwable ex) {
                }
            }
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
        this.VehiclesEnterred++;
        return true;
    }
    
    void CloseGate()
    {
        System.out.println(Thread.currentThread().getName() + ": Gate Closed.");
        System.out.println(Thread.currentThread().getName() + "'s Q: " + this.getQ());
        VehiclesCount.incrementAndGet();
    }
}
