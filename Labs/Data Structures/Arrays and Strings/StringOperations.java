import java.util.*;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = 0;
        for (char c : str.toCharArray()) len++;
        System.out.println(len);

        String rev = "";
        for (int i = len - 1; i >= 0; i--) rev += str.charAt(i);
        System.out.println(rev);

        String copy = str;
        System.out.println(copy);
    }
}
