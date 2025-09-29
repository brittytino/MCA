import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Roll No: ");
        int roll = input.nextInt();

        System.out.print("Enter your Name: ");
        String name = input.next();

        System.out.print("Enter your Class: ");
        String section = input.next();

        System.out.print("Enter your Marks: ");
        float marks = input.nextFloat();


        System.out.print("Enter your PH_N): ");
        int ph = input.nextInt();

        System.out.println("Yur Name is : " + name);
        System.out.println("Your Roll No is : " + roll);
        System.out.println("Your Section  is : " + section);
        System.out.println("Your Mark  is : " + marks);
        System.out.println("Your Ph No  is : " + ph);


    }
}