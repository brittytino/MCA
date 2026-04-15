interface SmartDevice {
    String BRAND_NAME = "SmartHomeX";

    void turnOn();

    void turnOff();

    static void deviceInfo() {
        System.out.println("Smart devices from brand: " + BRAND_NAME);
    }
}

class SmartLight implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("SmartLight is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartLight is OFF");
    }
}

class SmartFan implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("SmartFan is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartFan is OFF");
    }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        SmartDevice.deviceInfo();

        SmartDevice light = new SmartLight();
        SmartDevice fan = new SmartFan();

        light.turnOn();
        fan.turnOn();
        light.turnOff();
        fan.turnOff();
    }
}
