package ex_12_carparkingsystem;

import static ex_12_carparkingsystem.Ex_12_CarParkingSystem.counter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleArrivals implements Runnable
{
    AutoGate AG;
    
    VehicleArrivals(AutoGate ag)
    {
        this.AG = ag;
    }
    
    @Override
    public void run()
    {
        while (counter >0)    // Counter of vehicles yet to arrive out of 200 vehicles
        {
            int Arrived_Vehicles = (int) (Math.random()*2); 
           
            synchronized(AG)
            {
                AG.Q = AG.Q + Arrived_Vehicles;
            }
            
            // Update the number of arriving vehicles counter.
            synchronized(counter)
            {
                // Accessing a shared resource makes it a critical section.
                counter = counter - Arrived_Vehicles;
            }
            
            System.out.println(Thread.currentThread().getName() + " Q: " + AG.getQ());

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(VehicleArrivals.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
