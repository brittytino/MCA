import java.util.*;

public class RemovePrimes {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 31, 13, 97, 10, 20, 11};
        System.out.println("Array after removing primes:");
        for (int num : arr) {
            if (!isPrime(num)) System.out.print(num + " ");
        }
    }
}
