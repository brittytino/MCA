import java.util.Scanner;

public class same_same_different {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = ip.nextInt();
        System.out.print("Enter num2: ");
        int num2 = ip.nextInt();
        System.out.print("Enter num3: ");
        int num3 = ip.nextInt();

        if(num1 == num2 && num2 == num3){
            System.out.println("All numbers are equal");
        } else if (num1 != num2 && num1 != num3 && num2 != num3) {
            System.out.println("All numbers are different");
        }
        else{
            System.out.println("Neither all are equal or different");
        }

    }
}
