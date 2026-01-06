import java.util.Scanner;

public class IncDec_Order {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Number 1: ");
        int num1 = ip.nextInt();
        System.out.print("Number 2: ");
        int num2 = ip.nextInt();
        System.out.print("Number 3: ");
        int num3 = ip.nextInt();

        if (num1 < num2 && num2 < num3) {
            System.out.println("Increasing Order");
        } else if (num1 > num2 && num2 > num3) {
            System.out.println("Decreasing Order");
        } else {
            System.out.println("Neither increasing or decreasing order");
        }
        ip.close();

    }
}
