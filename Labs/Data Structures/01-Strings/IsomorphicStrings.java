import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                map.put(c1, c2);
            }
            if (reverseMap.containsKey(c2)) {
                if (reverseMap.get(c2) != c1) return false;
            } else {
                reverseMap.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic("egg", "add")); // Output: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Output: false
        System.out.println(solution.isIsomorphic("paper", "title")); // Output: true
    }
}
