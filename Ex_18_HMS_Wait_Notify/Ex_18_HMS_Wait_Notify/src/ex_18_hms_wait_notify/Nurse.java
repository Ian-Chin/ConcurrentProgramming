package ex_18_hms_wait_notify;

import static ex_18_hms_wait_notify.Ex_18_HMS_Wait_Notify.*;

public class Nurse extends Thread
{   
    @Override
    public void run()
    {
        try {
            System.out.println(this.getName() + " is Ready.");
            
            // Will keep looping till no more patients in the Queue
            while(!Patients.isEmpty() && (!DT1.Busy || !DT2.Busy))
            {
                System.out.println(this.getName() + ": Doctor-1-Busy: " + DT1.Busy + "  Doctor-2-Busy: " + DT2.Busy);
                
                // Check Patients Emergency Level and send the highest to a Doctor.
                Patient Patient = this.NextPatient();
                
                // If Doctor-1 is Not Busy and there is a Patient picked for a treatment, then send the Patient (P) to the Free Doctor (DT1)
                if(!DT1.Busy && Patient!=null)
                {
                    this.SendPatientToDoctor(Patient, DT1);
                    // Need to tell that the Patient has Already been sent to Doctor-1 and there is no Patient is awaiting to be assigned to a doctor, at this moment.
                    Patient=null;
                }
                else if(!DT2.Busy && Patient!=null)        // If Doctor-2 is Not Busy and there is a Patient picked for a treatment, then send the Patient (P) to the Free Doctor (DT2)
                {
                    this.SendPatientToDoctor(Patient, DT2);
                    // Need to tell that the Patient has Already been sent to Doctor-2 and there is no Patient is awaiting to be assigned to a doctor, at this moment.
                    Patient=null;
                }
                
                // In case both Doctors are BUSY (NOT Free), then Wait for any of them to call (notify)
                if (DT1.Busy && DT2.Busy)
                {
                    synchronized(dnc)
                    {
                        try {
                            dnc.wait();
                            System.out.println(this.getName() + ": A Doctor is Free.");
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
            
            // After assigning all the queuing patients to doctors.
            System.out.println(this.getName() + ": No more patients in the Queue.");
            // Simulating some waiting time for the doctors to finish treating patients, then we can print the final Report.
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}
    }
    
    // Picking the Next Patient to be sent in for treatment.
    public Patient NextPatient()
    {
        int MaxLevel = 0;
        int MaxLevelIndex =0;
        
        // Finding the patient with the highest Emergency Level, in the current queue.
        for (int i=0; i<Patients.size();i++) 
        {
            if (Patients.get(i).EmergencyLevel > MaxLevel)
            {
                MaxLevel = Patients.get(i).EmergencyLevel;
                MaxLevelIndex = i;
            }
        }
        Patient P = Patients.get(MaxLevelIndex);
        
        // Remove the chosen patient from the queue, as he/she is being sent to a doctor.
        Patients.remove(MaxLevelIndex);
        
        return P;
    }
    
    // Sending a Patient (P) to a free Doctor (D)
    public synchronized void SendPatientToDoctor(Patient P, Doctor D)
    {   
        System.out.println(this.getName() +": A Patient with Emergency Level " + P.EmergencyLevel + " has been assigned to " + D.getName());
        
        // IF the free Doctor was Doctor-1, then assign the patient to Doctor-1, and notify the Doctor that a new patient is coming in. 
        if(D.getName().equalsIgnoreCase("Doctor-1"))
        {
            synchronized(nd1c)
            {
                nd1c.notify();
                // Raise the BUSY Flag (Doctor-1 is Busy with a Patient)
                D.Busy = true;
            }   
        }
        else if(D.getName().equalsIgnoreCase("Doctor-2"))           // IF the free Doctor was Doctor-2, then assign the patient to Doctor-2, and notify the Doctor that a new patient is coming in. 
        {
            synchronized(nd2c)
            {
                nd2c.notify();
                // Raise the BUSY Flag (Doctor-2 is Busy with a Patient)
                D.Busy = true;
            }   
        }
    }
}
