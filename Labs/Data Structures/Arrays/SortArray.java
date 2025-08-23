import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Ascending
        Arrays.sort(arr);
        System.out.println("Ascending: " + Arrays.toString(arr));
        // Descending
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(arr));
    }
}
