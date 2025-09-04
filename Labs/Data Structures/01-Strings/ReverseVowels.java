import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) left++;
            while (left < right && !vowels.contains(chars[right])) right--;
            if (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowels solution = new ReverseVowels();
        System.out.println(solution.reverseVowels("IceCreAm")); // Output: "AceCreIm"
        System.out.println(solution.reverseVowels("leetcode")); // Output: "leotcede"
    }
}
