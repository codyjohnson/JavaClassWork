package Sep_11_2025;

public class PartTime extends Employee {

    private double hours;
    private double hourlyRate;

    public PartTime() {

    }

    public PartTime(String name, String address, Long id, double hours, double hourlyRate, int age) {
        super(name, address, id, age);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PT " + hours + " " + hourlyRate + " " + super.toString();
    }
}
