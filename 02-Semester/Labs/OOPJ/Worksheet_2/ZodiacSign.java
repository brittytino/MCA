package WorkSheet_2;

public class ZodiacSign {
    public static void main(String[] args) {
        if(args.length !=2){
            System.out.print("Enter 2 Args --> Month & Date");
            return;
        }

        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        if ((m == 12 && d >= 22) || (m == 1 && d <= 19)) {
            System.out.println("Capricorn");
        } else if ((m == 1 && d >= 20) || (m == 2 && d <= 17)) {
            System.out.println("Aquarius");
        } else if ((m == 2 && d >= 18) || (m == 3 && d <= 19)) {
            System.out.println("Pisces");
        } else if ((m == 3 && d >= 20) || (m == 4 && d <= 19)) {
            System.out.println("Aries");
        } else if ((m == 4 && d >= 20) || (m == 5 && d <= 20)) {
            System.out.println("Taurus");
        } else if ((m == 5 && d >= 21) || (m == 6 && d <= 20)) {
            System.out.println("Gemini");
        } else if ((m == 6 && d >= 21) || (m == 7 && d <= 22)) {
            System.out.println("Cancer");
        } else if ((m == 7 && d >= 23) || (m == 8 && d <= 22)) {
            System.out.println("Leo");
        } else if ((m == 8 && d >= 23) || (m == 9 && d <= 22)) {
            System.out.println("Virgo");
        } else if ((m == 9 && d >= 23) || (m == 10 && d <= 22)) {
            System.out.println("Libra");
        } else if ((m == 10 && d >= 23) || (m == 11 && d <= 21)) {
            System.out.println("Scorpio");
        } else if ((m == 11 && d >= 22) || (m == 12 && d <= 21)) {
            System.out.println("Sagittarius");
        } else {
            System.out.println("Invalid date");
        }


    }
}
