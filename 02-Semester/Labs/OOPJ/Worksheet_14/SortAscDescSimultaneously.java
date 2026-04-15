import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortAscDescSimultaneously {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> ascList = new ArrayList<>(numbers);
        List<Integer> descList = new ArrayList<>(numbers);

        Thread ascThread = new Thread(() -> {
            Collections.sort(ascList);
            System.out.println("Ascending Order: " + ascList);
        });

        Thread descThread = new Thread(() -> {
            descList.sort(Collections.reverseOrder());
            System.out.println("Descending Order: " + descList);
        });

        ascThread.start();
        descThread.start();

        ascThread.join();
        descThread.join();
    }
}
