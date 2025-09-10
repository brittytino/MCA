import java.util.HashSet;
import java.util.Set;

public class MaxProductWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                masks[i] |= (1 << (c - 'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProductWordLengths solution = new MaxProductWordLengths();
        System.out.println(solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"})); // Output: 16
        System.out.println(solution.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"})); // Output: 4
        System.out.println(solution.maxProduct(new String[]{"a","aa","aaa","aaaa"})); // Output: 0
    }
}
