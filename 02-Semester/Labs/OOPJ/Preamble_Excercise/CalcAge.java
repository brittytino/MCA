import java.util.Scanner;

public class CalcAge {
    private float calcAge(int age){
        return age * 365.24f;
    }

    public static void main(String[] args) {
        CalcAge myobj = new CalcAge();
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter the Age: ");
        int age = ip.nextInt();

        float result = myobj.calcAge(age);
        System.out.print("Days: " + result);
    }
}
