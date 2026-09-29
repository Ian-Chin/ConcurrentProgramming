package ex_18_hms_wait_notify;

import static ex_18_hms_wait_notify.Ex_18_HMS_Wait_Notify.*;

public class Doctor extends Thread{
    
    public boolean Busy = false;
    public int patientCount = 0;
    
    @Override
    public void run()
    {
        // A one-time message, at the begining of the simulation.
        System.out.println(this.getName() + " is Ready.");
        
        // Will keep waiting for the Nurse to send Patients in, as long as There still patients in the Queue.
        while(!Patients.isEmpty())
        {
            // Doctor-1 Operation - Start
            if(this.getName().equalsIgnoreCase("Doctor-1") && !this.Busy)
            {
                synchronized(nd1c)
                {
                    try {
                        // Doctor-1 will wait for the nurse to assign and send a patient in.
                        nd1c.wait();
                        System.out.println(this.getName() + " received a new Patient.");
                        TreatPatient();
                        
                        // A message will be printed AFTER finishing the patient treatment.
                        System.out.println(this.getName() + " Done Treating the Patient.");
                        
                        // Lowering down the BUSY Flag (Telling that Doctor-1 is Free.)
                        this.Busy = false;
                        
                        synchronized(dnc)
                        {     
                            // Doctor-1 Notifies the Nurse that he/she is free.
                            dnc.notify();
                        }
                    } catch (InterruptedException ex) {}
                }
                // Doctor-1 Operation - Finish   
            }
            else if(this.getName().equalsIgnoreCase("Doctor-2") && !this.Busy)            // Doctor-2 Operation - Start
            {
                synchronized(nd2c)
                {
                    try {
                        // Doctor-2 will wait for the nurse to assign and send a patient in.
                        nd2c.wait();
                        System.out.println(this.getName() + " received a new Patient.");
                        TreatPatient();

                        // A message will be printed AFTER finishing the patient treatment.
                        System.out.println(this.getName() + " Done Treating the Patient.");

                        // Lowering down the BUSY Flag (Telling that Doctor-1 is Free.)
                        this.Busy = false;
                        
                        synchronized(dnc)
                        {       
                            // Doctor-2 Notifies the Nurse that he/she is free.
                            dnc.notify();
                        }
                    } catch (InterruptedException ex) {}
                }
                // Doctor-2 Operation - Finish
            }
        }  
    }

    public synchronized void TreatPatient()
    {
        // Raise the BUSY Flag
        this.Busy = true;
        
        // Start treating a patient 
        System.out.println(this.getName() +": Patient being treated.");
        try {
            Thread.sleep((long) (Math.random() * 3000));
            
            // Incremeant the counter for the number of patients been treted by the doctor.
            this.patientCount++;
        } catch (InterruptedException ex) {}
    }
}