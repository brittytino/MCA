import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            } else {
                map.put(c, word);
            }
            if (reverseMap.containsKey(word)) {
                if (reverseMap.get(word) != c) return false;
            } else {
                reverseMap.put(word, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // Output: true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // Output: false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // Output: false
    }
}
