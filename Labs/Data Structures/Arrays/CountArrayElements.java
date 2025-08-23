import java.util.Scanner;

public class CountArrayElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int positive = 0, negative = 0, even = 0, odd = 0;
        for (int num : arr) {
            if (num > 0) positive++;
            if (num < 0) negative++;
            if (num % 2 == 0) even++;
            if (num % 2 != 0) odd++;
        }
        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
