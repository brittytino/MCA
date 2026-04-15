import java.util.Scanner;

class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }

        long result = 1;
        for (int i = 0; i < p; i++) {
            result *= n;
        }
        return result;
    }
}

public class MyCalculatorPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalculator calculator = new MyCalculator();

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                break;
            }
            int p = scanner.nextInt();

            try {
                System.out.println(calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
