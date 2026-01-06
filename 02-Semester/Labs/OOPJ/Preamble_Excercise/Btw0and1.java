import java.util.Scanner;

public class Btw0and1 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter the Num1: ");
        double num1= ip.nextDouble();
        System.out.print("Enter the Num2: ");
        double num2= ip.nextDouble();

        if((num1 >0 && num1 <1) && (num2 >0 && num2 <1)){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

    }
}
