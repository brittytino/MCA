import java.util.Scanner;

public class HowManySeconds {
    public int howManySeconds(int hours) {
        return hours * 3600;
    }

    public static void main(String[] args) {
        HowManySeconds myobject = new HowManySeconds();

        Scanner ip = new Scanner(System.in);
        System.out.print("Enter the Hours: ");
        int hours = ip.nextInt();

        int result = myobject.howManySeconds(hours);
        System.out.print("Seconds: " + result);
        ip.close();
    }
}
