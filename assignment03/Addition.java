class Addition {

    // static var
    static String operation = "Addition";

    // Overloading
    void add() {
        System.out.println("No Parameters");
    }

    void add(int a, int b) {
        System.out.println("Addition of Two Numbers = " + (a + b));
    }

    void add(int a, int b, int c) {
        System.out.println("Addition of Three Numbers = " + (a + b + c));
    }

    // this is static function
    static void displayOperation() {
        System.out.println("Operation : " + operation);
    }

    public static void main(String[] args) {

        Addition.displayOperation();

        Addition obj = new Addition();

        obj.add();
        obj.add(10, 20);
        obj.add(10, 20, 30);
    }
}