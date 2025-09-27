class Pallindrom {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";

        System.out.println(isPalindrome(test1)); // true
        System.out.println(isPalindrome(test2)); // false
    }
}
