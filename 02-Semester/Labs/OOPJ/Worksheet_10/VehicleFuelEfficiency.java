abstract class Vehicle {
    protected String model;
    protected static int vehicleCount = 0;

    public Vehicle(String model) {
        this.model = model;
        vehicleCount++;
    }

    public abstract double fuelEfficiency();

    public final void displayVehicle() {
        System.out.println("Model: " + model + ", Fuel Efficiency: " + fuelEfficiency() + " km/l");
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }
}

class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public double fuelEfficiency() {
        return 18.5;
    }
}

class Bike extends Vehicle {
    public Bike(String model) {
        super(model);
    }

    @Override
    public double fuelEfficiency() {
        return 52.0;
    }
}

public class VehicleFuelEfficiency {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Honda City");
        Vehicle v2 = new Bike("Yamaha FZ");

        v1.displayVehicle();
        v2.displayVehicle();

        System.out.println("Total vehicle objects created: " + Vehicle.getVehicleCount());
    }
}
