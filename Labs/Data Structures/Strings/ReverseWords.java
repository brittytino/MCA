public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();
        System.out.println(solution.reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(solution.reverseWords(" hello world ")); // Output: "world hello"
        System.out.println(solution.reverseWords("a good example")); // Output: "example good a"
    }
}
