package ex_11_apupark;

public class APUPark {

    private final int maxLots;
    private int occupiedLots = 0;
    private int totalAdmitted = 0;
    private int totalRejected = 0;

    public APUPark(int maxLots) {
        this.maxLots = maxLots;
    }

    public synchronized boolean parkVehicle(String gateId, String plateNumber) {
        if (occupiedLots >= maxLots) {
            totalRejected++;
            System.out.println(gateId + " | FULL - " + plateNumber
                    + " turned away (lots used: " + occupiedLots + "/" + maxLots + ")");
            return false;
        }

        occupiedLots++;
        totalAdmitted++;
        System.out.println(gateId + " | IN   - " + plateNumber
                + " parked (lots used: " + occupiedLots + "/" + maxLots + ")");
        return true;
    }

    // Also synchronized: a leaving vehicle changes the same shared counter.
    public synchronized void releaseVehicle(String gateId, String plateNumber) {
        if (occupiedLots > 0) {
            occupiedLots--;
            System.out.println(gateId + " | OUT  - " + plateNumber
                    + " left (lots used: " + occupiedLots + "/" + maxLots + ")");
        }
    }

    public synchronized int getOccupiedLots() {
        return occupiedLots;
    }

    public synchronized int getAvailableLots() {
        return maxLots - occupiedLots;
    }

    public synchronized int getTotalAdmitted() {
        return totalAdmitted;
    }

    public synchronized int getTotalRejected() {
        return totalRejected;
    }

    public int getMaxLots() {
        return maxLots;
    }
}
