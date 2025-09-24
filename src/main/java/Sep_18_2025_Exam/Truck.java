package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class Truck extends Vehicle {

    private double towingCapacity;

    public Truck(String make, String vin, double price, double towingCapacity) {
        super(make, vin, price);
        this.towingCapacity = towingCapacity;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String toString() {
        return "TR " + super.toString() + " " + towingCapacity;
    }
}