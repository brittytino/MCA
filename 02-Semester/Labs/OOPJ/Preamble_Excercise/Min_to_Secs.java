import java.util.Scanner;

public class Min_to_Secs {
    public int mintosecs(int min){
        return min * 60;
    }

    public static void main(String[] args) {
        Min_to_Secs myobject = new Min_to_Secs();
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter the Minutes: ");
        int min = ip.nextInt();
        ip.close();
        int result = myobject.mintosecs(min);
        System.out.print("Seconds: "+result);
    }
}
