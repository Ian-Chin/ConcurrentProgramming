package ex_06_threadjoin_3;

public class GreetingTeacher implements Runnable{
    
    // Attributes
    int StudentNumber;
    
    GreetingTeacher(int StdNum)
    {
        this.StudentNumber = StdNum;
    }
    
    @Override
    public void run()
    {
        System.out.println("\tStudent " + this.StudentNumber+ ": Greeting Teacher.");
    }
}
