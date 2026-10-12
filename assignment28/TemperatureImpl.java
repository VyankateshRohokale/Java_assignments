import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureImpl extends UnicastRemoteObject implements Temperature {
    public TemperatureImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}