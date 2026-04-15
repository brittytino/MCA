abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public abstract double calculateInterest();

    public final void displayAccount() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

interface Transaction {
    void deposit(double amount);

    void withdraw(double amount);
}

class SavingsAccount extends BankAccount implements Transaction {
    public static String bankName = "PSG Bank";
    private final double interestRate;

    public SavingsAccount(String accountNumber, double openingBalance, double interestRate) {
        super(accountNumber, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount("SB1001", 10000, 0.04);
        System.out.println("Bank Name: " + SavingsAccount.bankName);

        acc.displayAccount();
        acc.deposit(2000);
        acc.withdraw(1500);
        acc.displayAccount();
        System.out.println("Interest: " + acc.calculateInterest());
    }
}
