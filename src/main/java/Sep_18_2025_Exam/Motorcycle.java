package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class Motorcycle extends Vehicle {

    private double topSpeed;

    public Motorcycle(String make, String vin, double price, double topSpeed) {
        super(make, vin, price);
        this.topSpeed = topSpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return "MC " + super.toString() + " " + topSpeed;
    }
}