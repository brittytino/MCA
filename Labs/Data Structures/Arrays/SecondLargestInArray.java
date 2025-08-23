import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        // Assuming at least 2 elements, find second largest (handle duplicates by finding unique)
        int largest = arr[n - 1];
        int secondLargest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }
        if (secondLargest == -1) {
            System.out.println("No second largest element.");
        } else {
            System.out.println("Second largest: " + secondLargest);
        }
    }
}
