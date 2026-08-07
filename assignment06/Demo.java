import java.io.FileWriter;

import java.io.FileReader;
import java.io.IOException;

public class Demo
{

    public static void main(String[] args)
    {

        try
        {

            // Writing to the file
            FileWriter writer = new FileWriter("employee.txt");

            writer.write("Employee ID: 518\n");
            writer.write("Employee Name: Piyush\n");
            writer.write("Department: Finance");

            writer.close();

            System.out.println("Data written successfully.");

            // Reading from the file
            FileReader reader = new FileReader("employee.txt");

            int ch;

            System.out.println("\nEmployee Details:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } 
        catch (IOException e)
        {

            System.out.println("Error while handling the file.");

        }
    }
}