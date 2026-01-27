import java.util.Scanner;

public class FindPerimeter {
    public double findPerimeter(double length, double width){
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        FindPerimeter myobject = new FindPerimeter();

        Scanner ip = new Scanner(System.in);
        System.out.print("Enter the Length: ");
        double length = ip.nextDouble();
        System.out.print("Enter the Width: ");
        double width = ip.nextDouble();

        double result = myobject.findPerimeter(length,width);
        System.out.print("Perimeter: "+ result);
        ip.close();
    }
}
