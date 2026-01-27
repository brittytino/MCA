import java.util.Scanner;

public class NextEdge {
    public int nextEdge(int side1, int side2){
        return (side1 + side2 ) -1;
    }

    public static void main(String[] args) {
        NextEdge myobj = new NextEdge();
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter Side1: ");
        int side1 = ip.nextInt();
        System.out.print("Enter Side2: ");
        int side2 = ip.nextInt();

        int result = myobj.nextEdge(side1,side2);
        System.out.print("Next Edge: " + result);
        ip.close();

    }
}
