package WorkSheet_7;


class Mobile {
    String brand;
    String model;
    double price;

    Mobile(String b, String m, double p){
        this.brand = b;
        this.model = m;
        this.price = p;
    }

    double getDiscountPrice(double p) {
        return p * 0.90;
    }

    void display(){
        System.out.println(brand + " " + model + " " + "Price: " + price);
        System.out.println("After 10% discount: " + getDiscountPrice(price));
    }
}
public class MobileInventory {
    public static void main(String[] args) {
        Mobile m1 = new Mobile("Samsung","M14",15000);
        m1.display();
    }

}
