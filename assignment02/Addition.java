class Addition 
{
    int a, b;
    // Default 
    Addition() 
    {
        a = 1;
        b = 2;
        System.out.println("Inside Default Constructor");
    }

    // Parameterized 
    Addition(int a, int b) 
    {
        this.a = a;
        this.b = b;
        System.out.println("Inside Parameterized Constructor");
    }
    // Copy 
    Addition(Addition obj) 
    {
        a = obj.a;
        b = obj.b;
        System.out.println("Inside Copy Constructor");
    }
    public static void main(String[] args) 
    {

        Addition A1 = new Addition();

        Addition A2 = new Addition(10, 20);


        Addition A3 = new Addition(A2);
    }
}