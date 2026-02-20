package WorkSheet_7;

class Shirt {
    int collarSize;
    int sleeveLength;
    String material = "cotton";

    Shirt(int c , int s){
        this.collarSize = c;
        this.sleeveLength = s;
    }

    void displayDetails(){
        System.out.println("Collar: "+ this.collarSize + " Sleeve: " + this.sleeveLength + " Material: "+ this.material);
    }
}
public class ShirtWS7 {
    public static void main(String[] args) {
        Shirt s1 = new Shirt(38,30);
        Shirt s2 = new Shirt(32,34);
        Shirt s3 = new Shirt(34,32);

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
    }
}
