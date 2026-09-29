package ex_11_apupark;

public class VehicleArrivalSimulation implements Runnable {

    private final String simulationName;
    private final Gate gate;
    private final int numberOfVehicles;
    private final int arrivalDelay;

    public VehicleArrivalSimulation(String simulationName, Gate gate,
                                    int numberOfVehicles, int arrivalDelay) {
        this.simulationName = simulationName;
        this.gate = gate;
        this.numberOfVehicles = numberOfVehicles;
        this.arrivalDelay = arrivalDelay;
    }

    @Override
    public void run() {
        System.out.println(simulationName + " started at gate " + gate.getGateId()
                + " with " + numberOfVehicles + " vehicles.");

        for (int i = 1; i <= numberOfVehicles; i++) {
            String plateNumber = gate.getGateId() + "-CAR-" + i;

            gate.admit(plateNumber);

            try {
                Thread.sleep(arrivalDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(simulationName + " finished. Gate " + gate.getGateId()
                + " admitted " + gate.getAdmitted()
                + ", rejected " + gate.getRejected() + ".");
    }
}
