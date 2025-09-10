public class LongestSubstringFrequency {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    private int helper(char[] chars, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (count[chars[i] - 'a'] < k) {
                int left = helper(chars, start, i, k);
                int right = helper(chars, i + 1, end, k);
                return Math.max(left, right);
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        LongestSubstringFrequency solution = new LongestSubstringFrequency();
        System.out.println(solution.longestSubstring("aaabb", 3)); // Output: 3
        System.out.println(solution.longestSubstring("ababbc", 2)); // Output: 5
    }
}
