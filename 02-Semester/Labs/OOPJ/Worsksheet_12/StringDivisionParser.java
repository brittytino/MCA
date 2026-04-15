import java.util.Scanner;

class StringDivider {
    public int divide(String a, String b) throws Exception {
        int x;
        int y;

        try {
            x = Integer.parseInt(a);
            y = Integer.parseInt(b);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format");
        }

        if (y == 0) {
            throw new Exception("Cannot divide by zero");
        }

        return x / y;
    }
}

public class StringDivisionParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringDivider divider = new StringDivider();

        while (scanner.hasNext()) {
            String a = scanner.next();
            if (!scanner.hasNext()) {
                break;
            }
            String b = scanner.next();

            try {
                System.out.println(divider.divide(a, b));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
