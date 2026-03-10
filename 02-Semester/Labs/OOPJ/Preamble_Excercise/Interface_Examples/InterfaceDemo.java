package Preamble_Excercise.Interface_Examples;

interface Payment{
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPIPayment implements Payment {
    public void pay(double amount){
        System.out.println("Paid " + amount + " using UPI");
    }
}
class CashPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Payment p;
        p = new CreditCardPayment();
        p.pay(4500);
        
        p = new CashPayment();
        p.pay(5000);

        p = new UPIPayment();
        p.pay(7500);
    }
}
