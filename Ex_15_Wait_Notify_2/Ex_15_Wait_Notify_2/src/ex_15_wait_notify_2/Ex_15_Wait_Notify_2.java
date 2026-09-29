package ex_15_wait_notify_2;

import java.util.ArrayList;
import java.util.List;

public class Ex_15_Wait_Notify_2 {
// Attributes
    // Creating a shared list
    public static List<Integer> sharedList = new ArrayList<>();

    public static void main(String[] args) 
    {
        sharedList.add(0);
        Printing_Process P1 = new Printing_Process();
        Increment_Process P2 = new Increment_Process();
        
        Thread T0 = new Thread(P1);
        Thread T1 = new Thread(P2);
        
        // Printing Thread
        T0.start();
        // Incrimenting Thread
        T1.start();
    }
    
}
