import java.util.Scanner;

public class Ticket {

    public static double calculateTicketFare(int age) {
        final double basic_fare = 500.0;
        double discount_rate = 0.0; // Represents the percentage discount (e.g., 50.0 for 50%)

        if (age < 5) {
            System.out.println("Free (Age < 5)");
            return 0.0; // Return 0 fare immediately for free entry
        } else if (age >= 5 && age <= 12) {
            discount_rate = 50.0;
        } else if (age >= 13 && age <= 59) {
            // No discount needed, rate remains 0.0
            System.out.println("No Discount (Age 13-59)");
        } else if (age >= 60) {
            discount_rate = 40.0;
        }

        // Calculate the final fare after the if/else blocks
        double final_fare = basic_fare * (1 - (discount_rate / 100.0));
        return final_fare;
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = ip.next();
        System.out.print("Enter Your Age: ");
        int age = ip.nextInt(); // Read the age input

        double fare = calculateTicketFare(age); // Call the method to get the fare

        System.out.println("Your Ticket Fare: " + fare);
        ip.close(); // Close the scanner
    }
}
