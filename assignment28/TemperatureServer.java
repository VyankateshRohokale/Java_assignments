import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    public static void main(String[] args) throws Exception {
        TemperatureImpl temperature = new TemperatureImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("TemperatureService", temperature);

        System.out.println("Temperature Server is running");
    }
}