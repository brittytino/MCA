import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Radius: ");
        int radius = scanner.nextInt();
        System.out.print("Enter the Length: ");
        int length = scanner.nextInt();
        double area = Math.PI * radius * radius;
        double volume = area * length;
        System.out.println("The Volume of the Cylinder is: "+ volume);
    }
}
