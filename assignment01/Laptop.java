class Laptop 
{

    String brand;

    String processor;
    int ram;

    
    Laptop() 
    {
        brand = "Dell";

        processor = "Intel i5";
        ram = 16;
    }

    
    void displayDetails() {
        System.out.println("Brand : " + brand);
        System.out.println("Processor : " + processor);

        System.out.println("RAM : " + ram + " GB");
    }

    public static void main(String[] args) {

        System.out.println("Java Environment Setup");

        Laptop l = new Laptop();

        l.displayDetails();
    }
}