class Mobile {

    String brand;
    String model;
    double price;

    // Default Constructor
    Mobile() {
        brand = "Samsung";
        model = "Galaxy A15";
        price = 18000;
    }

    // Parameterized Constructor
    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Copy Constructor
    Mobile(Mobile m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
    }

    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
        System.out.println();
    }

    public static void main(String[] args) {

        // Default constructor
        Mobile m1 = new Mobile();

        // Parameterized constructor
        Mobile m2 = new Mobile("Apple", "iPhone 15", 60000);

        // Copy constructor
        Mobile m3 = new Mobile(m2);

        System.out.println("Mobile 1:");
        m1.display();

        System.out.println("Mobile 2:");
        m2.display();

        System.out.println("Duplicate Mobile Record:");
        m3.display();
    }
}