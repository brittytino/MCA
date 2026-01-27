public class PrintlnDemo {

    public static void main(String[] args) {

        // Declare and initialize variables
        int a = 10;
        int b = 20;

        // 1. Sum using string concatenation
        System.out.println("Sum = " + a + b);

        // 2. Sum using arithmetic expression evaluation
        System.out.println("Sum = " + (a + b));

        // 3. Printing result without a string
        System.out.println(a + b);

        // 4. Mixed expressions with strings and variables
        System.out.println("Values are a = " + a + " and b = " + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a * b = " + (a * b));
    }
}
