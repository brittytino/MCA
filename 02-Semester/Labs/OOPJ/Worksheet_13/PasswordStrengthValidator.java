import java.util.Scanner;

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

class PasswordValidator {
    public void validate(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("Password too short");
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (!hasUpper) {
            throw new WeakPasswordException("Password must contain at least one uppercase letter");
        }
        if (!hasLower) {
            throw new WeakPasswordException("Password must contain at least one lowercase letter");
        }
        if (!hasDigit) {
            throw new WeakPasswordException("Password must contain at least one digit");
        }
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator();

        while (scanner.hasNext()) {
            String password = scanner.next();
            try {
                validator.validate(password);
                System.out.println("Valid Password");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
