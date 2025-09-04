public class LastWordLength {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - lastSpace - 1;
    }

    public static void main(String[] args) {
        LastWordLength solution = new LastWordLength();
        System.out.println(solution.lengthOfLastWord("Hello World")); // Output: 5
        System.out.println(solution.lengthOfLastWord(" fly me to the moon ")); // Output: 4
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy")); // Output: 6
    }
}
