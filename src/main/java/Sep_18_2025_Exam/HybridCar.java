package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class HybridCar extends Vehicle {

    private double mpg;

    public HybridCar(String make, String vin, double price, double mpg) {
        super(make, vin, price);
        this.mpg = mpg;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "HB " + super.toString() + " " + mpg;
    }
}