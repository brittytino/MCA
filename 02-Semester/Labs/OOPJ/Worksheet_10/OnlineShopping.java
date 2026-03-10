package Worksheet_10;

abstract class Product {
    String productName;
    float price;

    public abstract void calculateDiscount();

    public void prt(){
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
    }
}

interface Shippable {
    void calculateShippingCost();
}

class Electronics extends Product implements Shippable{

    static int productCount = 0;
    final float TAX_RATE = 0.18f;

    Electronics(String name, float price){
        this.productName = name;
        this.price = price;
        productCount++;
    }

    @Override
    public void calculateDiscount(){
        float discount = price * 0.10f;   // 10% discount
        float finalPrice = price - discount;
        float tax = finalPrice * TAX_RATE;

        System.out.println("\nElectronics Product: " + productName);
        System.out.println("Original Price: " + price);
        System.out.println("Discount (10%): " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + (finalPrice + tax));
    }

    @Override
    public void calculateShippingCost(){
        float shipping = 100; // fixed shipping
        System.out.println("Shipping Cost: " + shipping);
    }
}

class Clothing extends Product implements Shippable{

    static int productCount = 0;
    final float TAX_RATE = 0.12f;

    Clothing(String name, float price){
        this.productName = name;
        this.price = price;
        productCount++;
    }

    @Override
    public void calculateDiscount(){
        float discount = price * 0.20f; // 20% discount
        float finalPrice = price - discount;
        float tax = finalPrice * TAX_RATE;

        System.out.println("\nClothing Product: " + productName);
        System.out.println("Original Price: " + price);
        System.out.println("Discount (20%): " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + (finalPrice + tax));
    }

    @Override
    public void calculateShippingCost(){
        float shipping = 50; // cheaper shipping
        System.out.println("Shipping Cost: " + shipping);
    }
}

public class OnlineShopping {
    public static void main(String[] args) {

        Electronics e = new Electronics("Laptop", 50000);
        Clothing c = new Clothing("Jacket", 3000);

        e.prt();
        e.calculateDiscount();
        e.calculateShippingCost();

        c.prt();
        c.calculateDiscount();
        c.calculateShippingCost();

        System.out.println("\nElectronics Count: " + Electronics.productCount);
        System.out.println("Clothing Count: " + Clothing.productCount);
    }
}