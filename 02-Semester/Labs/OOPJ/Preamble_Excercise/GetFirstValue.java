import java.util.Scanner;

public class GetFirstValue {
    public int getFirstValue(int[] numbers){
        return numbers[0];
    }

    public static void main(String[] args) {
        GetFirstValue myobj = new GetFirstValue();
        Scanner ip = new Scanner(System.in);
        int[] numbers = new int[5];
        for(int i =0;i<5;i++){
            System.out.print("Enter Element " + (i + 1) + ": ");
            numbers[i] = ip.nextInt();
        }

        int result = myobj.getFirstValue(numbers);
        System.out.print("The first Element: " + result);

        ip.close();
    }
}
