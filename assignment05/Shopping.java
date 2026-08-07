import java.util.ArrayList;
import java.util.Vector;

class Shopping
{

    public static void main(String[] args) 
    {

        ArrayList<String> items = new ArrayList<>();

        items.add("Laptop");

        items.add("Mouse");
    items.add("Keyboard");

    System.out.println("Items : " + items);

        Vector<Integer> price = new Vector<>();

        price.add(50000);

    price.add(700);
    price.add(1500);

        System.out.println("Prices : " + price);

        StringBuffer bill = new StringBuffer("Total Items : ");

    bill.append(items.size());

        System.out.println(bill);
    }
}



