import java.util.Scanner;

public class Return_Sum {
    public int add_numbers(int a, int b){
         return a + b ;
    }

    public static void main(String[] args) {
        Return_Sum myobject = new Return_Sum();

        Scanner ip = new Scanner(System.in);
        System.out.print("Enter Number 1: ");
        int a = ip.nextInt();
        System.out.print("Enter the Number 2: ");
        int b = ip.nextInt();

        ip.close();

        int result= myobject.add_numbers(a,b);
        System.out.print("Sum: "+ result);

    }
}
