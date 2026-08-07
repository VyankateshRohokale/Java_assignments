class WrapperDemo 
{

    public  static void main(String[]  args) 
    {

        // Primitive Data Type
        int num = 100;

        System.out.println("Primitive int : " + num);

        // Primitive to Object
        Integer obj= Integer.valueOf(num);

        System.out.println("Wrapper Object : " + obj);

        // Unboxing (Object to Primitive)

        int value= obj;
        System.out.println("Primitive after Unboxing : " + value);

        // Basic Operation
        int sum = obj + 50;

        System.out.println("Addition : " + sum);

        // Wrapper Class Method
        String str  = "250";

        int number= Integer.parseInt(str);
        System.out.println(" Converted String to int : " + number);
    }
}