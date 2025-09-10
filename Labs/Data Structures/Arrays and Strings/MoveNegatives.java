import java.util.*;

public class MoveNegatives {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int num : arr) {
            if (num < 0) neg.add(num); else pos.add(num);
        }
        pos.addAll(neg);
        System.out.println(pos);
    }
}
