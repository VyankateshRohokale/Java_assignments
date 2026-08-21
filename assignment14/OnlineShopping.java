import java.util.*;

class Shopping {

    void order(String product, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero"
            );
        }

        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Order placed successfully");
    }
}

public class OnlineShopping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String product = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        try {
            Shopping s = new Shopping();
            s.order(product, quantity);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
