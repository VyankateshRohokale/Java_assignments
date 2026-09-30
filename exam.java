final class classExaminationConfig
{

    final int exam_fees = 105;

    final int calculate()
    {
        System.out.println("this is calculation function..");
    }



}

class random extends classExaminationConfig
{


    calculate()
    {
        // nopthing
    }



}



public class exam 
{
    public static void main(String[] args) 
    {
    
        classExaminationConfig obj = new classExaminationConfig();

        obj.exam_fees = 123;

    }    
}
