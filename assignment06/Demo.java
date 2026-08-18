import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {

        // Writing patient details
        FileWriter writer = new FileWriter("patient.txt");

        writer.write("Patient ID: P101\n");
        writer.write("Name: Rahul\n");
        writer.write("Age: 25\n");
        writer.write("Diagnosis: Fever\n");

        writer.close();

        // Reading patient details
        FileReader reader = new FileReader("patient.txt");

        int ch;

        System.out.println("Patient Details:");

        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        reader.close();
    }
}