package ex_06_threadjoin_3;
public class Ex_06_ThreadJoin_3 {
    public static void main(String[] args) 
    {
        System.out.println("Teacher standing at the class's door. Students are arriving:");
      
        Thread[] students = new Thread[10];
        
        for (int i = 0; i < students.length; i++)
        {
            students[i] = new Thread(new StudentBehaviour(i+1));
        }
        
        // Students are arriving
        for (Thread Std : students)
        {
            Std.start();
            try {
                Std.join();
            } catch (InterruptedException ex) 
            {}
        }
        System.out.println("All the 10 students are in the class Already!");
    }    
}
