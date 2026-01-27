import java.util.Scanner;

public class IsSameNum {
    public boolean isSameNum(int a, int b){
        if(a == b){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsSameNum myobject = new IsSameNum();

        Scanner ip = new Scanner(System.in);
        System.out.print("Enter Num1: ");
        int a = ip.nextInt();
        System.out.print("Enter Num2: ");
        int b = ip.nextInt();

        boolean result = myobject.isSameNum(a,b);
        System.out.print(result);
    }
}
