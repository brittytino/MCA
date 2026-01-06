import java.util.Scanner;

public class Celsius_degree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Celsius: ");
        int Celsius = scanner.nextInt();
        double fahrenheit = (9.0 / 5.0) * Celsius + 32;
        System.out.println("The Fahrenheit of the Celsius: " + fahrenheit);
        scanner.close();
    }
}
