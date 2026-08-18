import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {

        // Writing to file
        FileWriter writer = new FileWriter("employee.txt");

        writer.write("Employee ID: 101\n");
        writer.write("Name: Vyankatesh\n");
        writer.write("Department: Computer Engineering\n");
        writer.write("Salary: 50000\n");

        writer.close();

        // Reading from file
        FileReader reader = new FileReader("employee.txt");

        int ch;

        System.out.println("Employee Details:");

        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        reader.close();
    }
}