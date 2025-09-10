import java.util.*;

public class SplitAndRearrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int pos = sc.nextInt();

        for (int i = pos; i < n; i++) System.out.print(arr[i] + " ");
        for (int i = 0; i < pos; i++) System.out.print(arr[i] + " ");
    }
}
