import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculatorService", calculator);

        System.out.println("Calculator Server is running");
    }
}