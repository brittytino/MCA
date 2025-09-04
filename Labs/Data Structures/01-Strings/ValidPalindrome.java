public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        String cleanedStr = cleaned.toString();
        return cleanedStr.equals(cleaned.reverse().toString());
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // Output: true
        System.out.println(solution.isPalindrome("race a car")); // Output: false
        System.out.println(solution.isPalindrome(" ")); // Output: true
    }
}
