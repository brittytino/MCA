import java.util.Scanner;

public class Addition_plus_one {
    public int plus_one(int a){
        return a+1;
    }

    public static void main(String[] args) {
        Addition_plus_one myobject = new Addition_plus_one();
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int a = ip.nextInt();

        int result = myobject.plus_one(a);
        System.out.println("Output: " + result);
        ip.close();
    }
}
