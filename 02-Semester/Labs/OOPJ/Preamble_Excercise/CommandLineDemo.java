public class CommandLineDemo {

    public static void main(String[] args) {

        // 2. Count number of inputs
        int count = args.length;
        System.out.println("Number of command line arguments: " + count);

        // Check if at least two arguments are provided
        if (count < 2) {
            System.out.println("Please provide at least two numbers as command line arguments.");
            return;
        }

        // 1. Display the values of command line arguments
        System.out.println("Command Line Arguments:");
        System.out.println("Argument 1: " + args[0]);
        System.out.println("Argument 2: " + args[1]);

        // 3. Convert arguments into integers
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        // 4. Calculate sum and product
        int sum = num1 + num2;
        int product = num1 * num2;

        // Display results
        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
    }
}
