import java.util.Scanner;

interface Payment {
    double TRANSACTION_FEE = 2.50;

    void processPayment(double amount);

    void printReceipt();
}

class CreditCardPayment implements Payment {
    private double finalAmount;

    @Override
    public void processPayment(double amount) {
        finalAmount = amount + TRANSACTION_FEE;
        System.out.println("Credit Card Payment Processed");
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt (Credit Card): Total Paid = " + finalAmount);
    }
}

class UPIPayment implements Payment {
    private double finalAmount;

    @Override
    public void processPayment(double amount) {
        finalAmount = amount + TRANSACTION_FEE;
        System.out.println("UPI Payment Processed");
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt (UPI): Total Paid = " + finalAmount);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();

        p1.processPayment(amount);
        p1.printReceipt();

        p2.processPayment(amount);
        p2.printReceipt();
    }
}
