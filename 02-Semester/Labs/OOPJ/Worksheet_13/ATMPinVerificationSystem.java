import java.util.Scanner;

class ATM {
    private static final int CORRECT_PIN = 1234;
    private static int attempts = 0;
    private static boolean blocked = false;

    public void verifyPin(int enteredPin) throws Exception {
        if (blocked) {
            throw new Exception("Card blocked due to multiple invalid attempts");
        }

        if (enteredPin == CORRECT_PIN) {
            System.out.println("Access Granted");
            return;
        }

        attempts++;
        if (attempts >= 3) {
            blocked = true;
            throw new Exception("Card blocked due to multiple invalid attempts");
        }

        throw new Exception("Invalid PIN");
    }
}

public class ATMPinVerificationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        while (scanner.hasNextInt()) {
            int pin = scanner.nextInt();
            try {
                atm.verifyPin(pin);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
