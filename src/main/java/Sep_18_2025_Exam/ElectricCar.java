package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class ElectricCar extends Vehicle {

    private double batteryRange;

    public ElectricCar(String make, String vin, double price, double batteryRange) {
        super(make, vin, price);
        this.batteryRange = batteryRange;
    }

    public double getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(double batteryRange) {
        this.batteryRange = batteryRange;
    }

    @Override
    public String toString() {
        return "EC " + super.toString() + " " + batteryRange;
    }
}