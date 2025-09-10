import java.util.*;

public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean space = false;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (!space) sb.append(' ');
                space = true;
            } else {
                sb.append(c);
                space = false;
            }
        }
        System.out.println(sb);
    }
}
