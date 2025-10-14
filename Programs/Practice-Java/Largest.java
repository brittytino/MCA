import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number a : ");

        int a = sc.nextInt();
        System.out.print("Enter the number b : ");
        int b = sc.nextInt();
        System.out.print("Enter the number c : ");
        int c = sc.nextInt();

   
        int Max = Math.max(c,(Math.min(a, b)));
        System.out.println("Max Number is: "+Max);

    }
}
