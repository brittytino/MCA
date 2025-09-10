import java.util.*;

public class WordWrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int w = sc.nextInt();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if ((i + 1) % w == 0) System.out.println();
        }
    }
}
