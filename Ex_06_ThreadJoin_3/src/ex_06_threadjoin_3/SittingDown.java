package ex_06_threadjoin_3;

public class SittingDown implements Runnable{
    // Attributes
    int StudentNumber;
    
    SittingDown(int StdNum)
    {
        this.StudentNumber = StdNum;
    }
        @Override
    public void run()
    {
        System.out.println("\tStudent " + this.StudentNumber+ ": Sitting Down.");
    }
}
