abstract class ProductBase {
    protected String productName;
    protected double price;
    protected static int productCount = 0;
    protected static final double TAX_RATE = 0.18;

    public ProductBase(String productName, double price) {
        this.productName = productName;
        this.price = price;
        productCount++;
    }

    public abstract double calculateDiscount();

    public static int getProductCount() {
        return productCount;
    }
}

interface ShippableProduct {
    double calculateShippingCost();
}

class ElectronicsProduct extends ProductBase implements ShippableProduct {
    public ElectronicsProduct(String productName, double price) {
        super(productName, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public double calculateShippingCost() {
        return 150.0;
    }
}

class ClothingProduct extends ProductBase implements ShippableProduct {
    public ClothingProduct(String productName, double price) {
        super(productName, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20;
    }

    @Override
    public double calculateShippingCost() {
        return 70.0;
    }
}

public class OnlineShoppingSystem {
    private static void printBill(ProductBase product, ShippableProduct shippable) {
        double discount = product.calculateDiscount();
        double discountedPrice = product.price - discount;
        double tax = discountedPrice * ProductBase.TAX_RATE;
        double shipping = shippable.calculateShippingCost();
        double finalAmount = discountedPrice + tax + shipping;

        System.out.println("Product: " + product.productName);
        System.out.println("Base Price: " + product.price);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Shipping: " + shipping);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println();
    }

    public static void main(String[] args) {
        ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 60000);
        ClothingProduct jacket = new ClothingProduct("Jacket", 3000);

        printBill(laptop, laptop);
        printBill(jacket, jacket);

        System.out.println("Total products created: " + ProductBase.getProductCount());
    }
}
