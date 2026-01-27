public class StronglyTyped {

    public static void main(String[] args) {

        int intVar = 8;
        double doubleVar = 24.56;
        String stringVar = "Java";

        System.out.println("Initial Values:");
        System.out.println("Integer Variable = " + intVar);
        System.out.println("Double Variable = " + doubleVar);
        System.out.println("String Variable = " + stringVar);

        /*
         * 2. Invalid assignments (UNCOMMENT to see compilation errors)
         *
         * intVar = doubleVar;        // Error: cannot convert double to int
         * doubleVar = stringVar;     // Error: incompatible types
         */

        // 4. Correcting errors using type casting
        intVar = (int) doubleVar; // Explicit type casting (double → int)

        // Another example of type casting in expressions
        double result = intVar + doubleVar; // int automatically promoted to double

        // String concatenation with other data types
        String combined = stringVar + " - Version " + intVar;

        // 5. Printing final values
        System.out.println("\nFinal Values After Type Casting:");
        System.out.println("intVar (after casting) = " + intVar);
        System.out.println("doubleVar = " + doubleVar);
        System.out.println("Result (int + double) = " + result);
        System.out.println("Combined String = " + combined);
    }
}
