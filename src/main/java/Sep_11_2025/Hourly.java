package Sep_11_2025;

public class Hourly extends FullTime {

    private double hours;
    private double hourlyRate;

    public Hourly() {

    }

    public Hourly(String name, String address, Long id, double benefit_amount, double hours, double hourlyRate, int age) {
        super(name, address, id, benefit_amount, age);
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
        return "HRLY " + hours + " " + hourlyRate + " " + super.toString();
    }
}
