import java.util.Arrays;
import java.util.Scanner;

public class GymnasticsScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[8];
        System.out.println("Enter 8 scores out of ten points:");
        for (int i = 0; i < 8; i++) {
            scores[i] = scanner.nextDouble();
        }
        Arrays.sort(scores);
        double min = scores;
        double max = scores;
        double total = 0;
        for (int i = 1; i < 7; i++) {
            total += scores[i];
        }
        double average = total / 6;
        System.out.printf("Your lowest score is %.2f%n", min);
        System.out.printf("Your maximum score is %.2f%n", max);
        System.out.printf("Your total point is %.2f%n", total);
        System.out.printf("Your average point is %.2f%n", average);
    }
}
