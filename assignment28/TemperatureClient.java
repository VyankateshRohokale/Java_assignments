import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        Temperature temperature = (Temperature) registry.lookup("TemperatureService");

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter temperature: ");
        double value = sc.nextDouble();

        if (choice == 1) {
            System.out.println("Fahrenheit: " + temperature.celsiusToFahrenheit(value));
        } else if (choice == 2) {
            System.out.println("Celsius: " + temperature.fahrenheitToCelsius(value));
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
