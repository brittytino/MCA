import java.util.Scanner;

class BankAccount {
    public double withdraw(double balance, double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }
        return balance - amount;
    }
}

public class BankWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();

        while (scanner.hasNextDouble()) {
            double balance = scanner.nextDouble();
            if (!scanner.hasNextDouble()) {
                break;
            }
            double amount = scanner.nextDouble();

            try {
                System.out.println(account.withdraw(balance, amount));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
