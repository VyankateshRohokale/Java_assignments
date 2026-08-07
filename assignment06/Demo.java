class College 
{
   class Student 
    {

        void display() 
        {
            System.out.println("Student belongs to the College");
        }
    }

void show() 
    {
        System.out.println("Welcome to College");
    }
}
public class Demo 
{

    public static void main(String[] args) 
 {
        College c = new College();
        College.Student s = c.new Student();
        s.display();
        College obj = new College() 
        {

            @Override
            void show() {
              System.out.println("Welcome to Symbiosis");
            }

        };
        obj.show();
    }
}