package Sep_11_2025;

public class FullTime extends Employee {

    private double benefit_amount;

    public FullTime() {
    }

    public FullTime(String name, String address, Long id, double benefit_amount, int age) {
        super(name, address, id, age);
        this.benefit_amount = benefit_amount;
    }

    public double getBenefit_amount() {
        return benefit_amount;
    }

    public void setBenefit_amount(double benefit_amount) {
        this.benefit_amount = benefit_amount;
        }

    @Override
    public String toString() {
        return "FT " + benefit_amount + " " + super.toString();
    }
}
