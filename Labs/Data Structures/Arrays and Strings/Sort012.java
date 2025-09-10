import java.util.*;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0, 1};
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        for (int i = 0; i < count0; i++) System.out.print("0 ");
        for (int i = 0; i < count1; i++) System.out.print("1 ");
        for (int i = 0; i < count2; i++) System.out.print("2 ");
    }
}
