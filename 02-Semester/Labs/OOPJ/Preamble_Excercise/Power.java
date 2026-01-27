import java.util.Scanner;

public class Power {
    public int power(int voltage, int current){
        return voltage * current;
    }

    public static void main(String[] args) {
        Power myobject = new Power();
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter the Voltage: ");
        int voltage = ip.nextInt();
        System.out.print("Enter the Current: ");
        int current = ip.nextInt();

        int result = myobject.power(voltage,current);
        System.out.println("Power: " + result);
    }
}
