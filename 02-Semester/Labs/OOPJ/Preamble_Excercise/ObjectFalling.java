import java.util.Scanner;

public class ObjectFalling {

    public static double position(double a, double v, double x, double t) {
        return 0.5 * a * t * t + v * t + x;
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Acceleration: ");
        double a = ip.nextDouble();

        System.out.print("Initial Velocity: ");
        double v = ip.nextDouble();

        System.out.print("Initial Position: ");
        double x = ip.nextDouble();

        System.out.print("Time: ");
        double t = ip.nextDouble();

        double result = position(a, v, x, t);
        System.out.println("Position of the object at time T: " + result);

        ip.close();
    }
}
