import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberClassifier {
    private static final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(201) - 100);
        }

        System.out.println("Generated Numbers: " + numbers);

        Thread negativeThread = new Thread(() -> {
            System.out.println("Negative numbers:");
            for (int n : numbers) {
                if (n < 0) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        });

        Thread positiveEvenThread = new Thread(() -> {
            System.out.println("Positive even numbers:");
            for (int n : numbers) {
                if (n > 0 && n % 2 == 0) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        });

        Thread positiveOddThread = new Thread(() -> {
            System.out.println("Positive odd numbers:");
            for (int n : numbers) {
                if (n > 0 && n % 2 != 0) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        });

        negativeThread.start();
        positiveEvenThread.start();
        positiveOddThread.start();

        negativeThread.join();
        positiveEvenThread.join();
        positiveOddThread.join();
    }
}
