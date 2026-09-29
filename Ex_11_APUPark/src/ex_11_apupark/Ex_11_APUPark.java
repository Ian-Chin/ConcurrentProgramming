package ex_11_apupark;

public class Ex_11_APUPark {

    public static void main(String[] args) {

        final int MAX_LOTS = 2000;
        APUPark park = new APUPark(MAX_LOTS);

        Gate g1 = new Gate("G1", park);
        Gate g2 = new Gate("G2", park);
        Gate g3 = new Gate("G3", park);

        Thread simulation1 = new Thread(
                new VehicleArrivalSimulation("Vehicles Arrival Simulation 1", g1, 800, 1));
        Thread simulation2 = new Thread(
                new VehicleArrivalSimulation("Vehicles Arrival Simulation 2", g2, 700, 1));
        Thread simulation3 = new Thread(
                new VehicleArrivalSimulation("Vehicles Arrival Simulation 3", g3, 900, 1));

        System.out.println("APU's Park is open. Capacity: " + MAX_LOTS + " lots.");

        simulation1.start();
        simulation2.start();
        simulation3.start();

        try {
            simulation1.join();
            simulation2.join();
            simulation3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=========== APU's PARK REPORT ===========");
        System.out.println("Capacity          : " + park.getMaxLots());
        System.out.println("Lots occupied     : " + park.getOccupiedLots());
        System.out.println("Lots available    : " + park.getAvailableLots());
        System.out.println("Total admitted    : " + park.getTotalAdmitted());
        System.out.println("Total rejected    : " + park.getTotalRejected());
        System.out.println("-----------------------------------------");
        System.out.println("G1 admitted: " + g1.getAdmitted() + " | rejected: " + g1.getRejected());
        System.out.println("G2 admitted: " + g2.getAdmitted() + " | rejected: " + g2.getRejected());
        System.out.println("G3 admitted: " + g3.getAdmitted() + " | rejected: " + g3.getRejected());
        System.out.println("=========================================");

        if (park.getOccupiedLots() <= park.getMaxLots()) {
            System.out.println("OK - the 2000 lots limit was never broken.");
        } else {
            System.out.println("RACE CONDITION - more vehicles than lots!");
        }
    }
}
