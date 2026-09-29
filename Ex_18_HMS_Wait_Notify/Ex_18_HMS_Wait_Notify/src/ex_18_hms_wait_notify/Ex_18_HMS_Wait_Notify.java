package ex_18_hms_wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Ex_18_HMS_Wait_Notify {

    // Creating Threads for TWO Doctors and a Nurse
    public static Doctor DT1 = new Doctor();
    public static Doctor DT2 = new Doctor();
    public static Nurse NT1 = new Nurse();
    
    public static List<Patient> Patients = new ArrayList<>();   // A list of Patients queuing
    
    // Create three Objects to represent the ears of the two doctors and a nurse.
    public static Object nd1c = new Object();    // ND1C (Nurse-to-Doctor-1 Channel)
    public static Object nd2c = new Object();    // ND2C (Nurse-to-Doctor-2 Channel)
    public static Object dnc = new Object();    // DNC (Any-Doctor-to-Nurse Channel)

    public static void main(String[] args) 
    {
        // Create 10 objects of Patients and add them to the list (Queuing), Assuming that ALL of them are already in the queue waiting to meet a doctor.
        for (int i=0 ; i<10; i++)
        {
            if (i==5)
                Patients.add(new Patient(8));   // High Emergency Patient
            else
                Patients.add(new Patient((int)(Math.random()*4)+1));  // Normal Emergency Level Patient
        }
                
        System.out.println("Number of Patients in the Queue: " + Patients.size());
        
        // Setting Threads Names
        NT1.setName("Nurse");
        DT1.setName("Doctor-1");
        DT2.setName("Doctor-2");
 
        // Starting the Threads.
        DT1.start();
        DT2.start();
        NT1.start();

        // Wait for the Nurse to finish its work (assigning all patients to doctors and make sure the doctors have done treating the patients.)
        try {
            NT1.join();
        } catch (InterruptedException ex) {
        }
        
        // Printing the Final Report
        System.out.println("\n\n*****FINAL REPORT *****");
        System.out.println("-------------------------" );
        System.out.println(DT1.getName()+ " Served " + DT1.patientCount + " Patients.");
        System.out.println(DT2.getName()+ " Served " + DT2.patientCount + " Patients.");
        System.out.println("STATUS: \n   Doctor-1 Thread: " + DT1.getState() + "\n   Doctor-2 Thread: " + DT2.getState() + "\n   Nurse Thread: " + NT1.getState());
        System.out.println("HMS Terminated Smoothly.");
    }
    
}
