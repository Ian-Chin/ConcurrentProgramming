package ex_17_carparkingsystem_waitandnotify;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex_17_CarParkingSystem_WaitAndNotify {
 public static AutoGate G1 = new AutoGate();
    public static AutoGate G2 = new AutoGate();
    public static AutoGate G3 = new AutoGate();
    public static VehicleArrivals VA1 = new VehicleArrivals(G1);
    public static VehicleArrivals VA2 = new VehicleArrivals(G2);
    public static VehicleArrivals VA3 = new VehicleArrivals(G3);
        
    public static Thread GT1 = new Thread(G1);
    public static Thread GT2 = new Thread(G2);
    public static Thread GT3 = new Thread(G3);
    public static Thread RVA1 = new Thread(VA1);
    public static Thread RVA2 = new Thread(VA2);
    public static Thread RVA3 = new Thread(VA3);

    public static int MAX_AVAILABLE_LOTS = 2000;
    public static Integer AvailableLots = MAX_AVAILABLE_LOTS;
    public static Integer counter = 200;
    public static AtomicInteger VehiclesCount = new AtomicInteger(0);
    public static boolean ParkIsFull = false;
    
    
    public static void main(String[] args) 
    {
        GT1.setName("Gate-1");
        GT2.setName("Gate-2");
        GT3.setName("Gate-3");
        RVA1.setName("VehicleArrival-1");
        RVA2.setName("VehicleArrival-2");
        RVA3.setName("VehicleArrival-3");
    
        // Start the vehicles arrival threads to start buildingthe queues
        RVA1.start();
        RVA2.start();
        RVA3.start();
        
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//        }

        // Turning ON the parking gates to received vehicles.
        GT1.start();
        GT2.start();
        GT3.start();
        
        try {
            GT1.join();
            GT2.join();
            GT3.join();
            
            RVA1.join();
            RVA2.join();
            RVA3.join();
        } catch (InterruptedException ex) {
        }
 
        System.out.println("FINAL Available Park Lots: " + AvailableLots);
        System.out.println("Total Vehicles Entered the Park: " + VehiclesCount.get());
        System.out.println("Gate-1 Vehicles Entered: " + G1.VehiclesEnterred);
        System.out.println("Gate-2 Vehicles Entered: " + G2.VehiclesEnterred);
        System.out.println("Gate-3 Vehicles Entered: " + G3.VehiclesEnterred);
        System.out.println("Q1: " + G1.getQ());
        System.out.println("Q2: " + G2.getQ());
        System.out.println("Q3: " + G3.getQ());
    }
}
