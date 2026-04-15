abstract class Shape {
    public static final double PI = 3.141592653589793;
    protected static int count = 0;

    public Shape() {
        count++;
    }

    public abstract double calculateArea();

    public void displayShape(String shapeName) {
        System.out.println("Shape: " + shapeName + ", Area: " + calculateArea());
    }

    public static int getCount() {
        return count;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Shape s1 = new Circle(7.0);
        Shape s2 = new Rectangle(10.0, 5.0);

        s1.displayShape("Circle");
        s2.displayShape("Rectangle");

        System.out.println("Total shape objects created: " + Shape.getCount());
    }
}
