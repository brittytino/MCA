import java.util.Scanner;

public class Obesity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Height (in cm): ");
        float height = scanner.nextFloat();
        height = height / 100;
        System.out.print("Enter your Weight: ");
        float weight = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter your Gender( M or F ): ");
        String gender = scanner.nextLine();

        float bmi = weight / (height * height);

        if (bmi >=27.8 && gender.equalsIgnoreCase("M")){
            System.out.println("You are obese as a M");
        }
        else if (bmi >=25 && gender.equalsIgnoreCase("F")) {
            System.out.println("You are obese as a F");
        }
        else{
            System.out.println("Not classified as obese or invalid input.");
        }
        scanner.close();
    }
}
