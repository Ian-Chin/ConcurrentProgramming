package ex_17_carparkingsystem_waitandnotify;

import static ex_17_carparkingsystem_waitandnotify.Ex_17_CarParkingSystem_WaitAndNotify.*;


public class VehicleArrivals implements Runnable
{
    AutoGate AG;
    
    VehicleArrivals(AutoGate ag)
    {
        this.AG = ag;
    }
    
    @Override
    public synchronized void run()
    {
        while (counter >0)
        {
            int Arrived_Vehicles = (int) (Math.random()*4); 
            AG.setQ(AG.getQ() + Arrived_Vehicles);
            System.out.println(Thread.currentThread().getName() + "'s Q_New: " + AG.getQ());
            
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
            }
        }
        
    }
}
