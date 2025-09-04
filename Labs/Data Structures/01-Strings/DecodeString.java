import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentNum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                currentString = "";
                currentNum = 0;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    temp.append(currentString);
                }
                currentString = stringStack.pop() + temp;
            } else {
                currentString += c;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(solution.decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
}
