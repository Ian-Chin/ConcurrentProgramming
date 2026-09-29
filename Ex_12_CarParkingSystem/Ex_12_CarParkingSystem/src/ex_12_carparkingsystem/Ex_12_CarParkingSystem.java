package ex_12_carparkingsystem;

public class Ex_12_CarParkingSystem {

  // Define the Runnable Processes
    public static AutoGate G1 = new AutoGate();
    public static AutoGate G2 = new AutoGate();
    public static AutoGate G3 = new AutoGate();
    public static VehicleArrivals VA1 = new VehicleArrivals(G1);
    public static VehicleArrivals VA2 = new VehicleArrivals(G2);
    public static VehicleArrivals VA3 = new VehicleArrivals(G3);
        
    // Define the Threads handling the Runnable Processes
    public static Thread GT1 = new Thread(G1);
    public static Thread GT2 = new Thread(G2);
    public static Thread GT3 = new Thread(G3);
    public static Thread RVA1 = new Thread(VA1);
    public static Thread RVA2 = new Thread(VA2);
    public static Thread RVA3 = new Thread(VA3);

    public static Integer AvailableLots = new Integer(2000);
    public static Integer counter = new Integer(200);
    
    public static void main(String[] args) 
    {

        RVA1.start();
        RVA2.start();
        RVA3.start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        GT1.start();
        GT2.start();
        GT3.start();
        
        try {
            System.out.println("****HERE-1****");
            GT1.join();
            GT2.join();
            GT3.join();
            System.out.println("****HERE-2****");
            RVA1.join();
            RVA2.join();
            RVA3.join();
            System.out.println("****HERE-3****");
        } catch (InterruptedException ex) {
        }
 
        // Printing the Final Report of the Simulation
        System.out.println("FINAL Available Park Lots: " + AvailableLots);
        System.out.println("Q1: " + G1.getQ() + " : " + G1.VC);
        System.out.println("Q2: " + G2.getQ() + " : " + G2.VC);
        System.out.println("Q3: " + G3.getQ() + " : " + G3.VC);
    }
}
