package ex_11_apupark;

public class Gate {

    private final String gateId;
    private final APUPark park;   
    private int admitted = 0;      
    private int rejected = 0;

    public Gate(String gateId, APUPark park) {
        this.gateId = gateId;
        this.park = park;
    }

    public boolean admit(String plateNumber) {
        boolean parked;

        synchronized (this) {
            System.out.println(gateId + " | barrier open for " + plateNumber);

            parked = park.parkVehicle(gateId, plateNumber);

            if (parked) {
                admitted++;
            } else {
                rejected++;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return parked;
    }

    public String getGateId() {
        return gateId;
    }

    public synchronized int getAdmitted() {
        return admitted;
    }

    public synchronized int getRejected() {
        return rejected;
    }
}
