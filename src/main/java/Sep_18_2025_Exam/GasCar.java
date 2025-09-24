package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class GasCar extends Vehicle {

    private double horsePower;

    public GasCar(String make, String vin, double price, double horsePower) {
        super(make, vin, price);
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "GC " + super.toString() + " " + horsePower;
    }
}