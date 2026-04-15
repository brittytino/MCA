import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeparateOddEvenThreads {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        Thread oddThread = new Thread(() -> {
            System.out.print("Odd numbers: ");
            for (int value : numbers) {
                if (value % 2 != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        });

        Thread evenThread = new Thread(() -> {
            System.out.print("Even numbers: ");
            for (int value : numbers) {
                if (value % 2 == 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        });

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }
}
