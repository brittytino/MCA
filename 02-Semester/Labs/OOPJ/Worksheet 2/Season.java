package WorkSheet_2;

public class Season {
    public static void main(String[] args) {
        if(args.length !=2){
            System.out.println("Enter 2 Args --> Month & Day");
            return;
        }

        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        if ((m == 3 && d >= 21) || (m == 4) || (m == 5) || (m == 6 && d <= 20)) {
            System.out.println("Spring");
        } else if ((m == 6 && d >= 21) || (m == 7) || (m == 8) || (m == 9 && d <= 22)) {
            System.out.println("Summer");
        } else if ((m == 9 && d >= 23) || (m == 10) || (m == 11) || (m == 12 && d <= 20)) {
            System.out.println("Fall");
        } else if ((m == 12 && d >= 21) || (m == 1) || (m == 2) || (m == 3 && d <= 20)) {
            System.out.println("Winter");
        } else {
            System.out.println("Invalid date");
        }
    }
}
