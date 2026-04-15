import java.util.Scanner;

class FactorialCalculator {
    public long factorial(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Number should not be negative");
        }
        if (n > 20) {
            throw new Exception("Number too large to compute factorial safely");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FactorialCalculator calc = new FactorialCalculator();

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            try {
                System.out.println(calc.factorial(n));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
