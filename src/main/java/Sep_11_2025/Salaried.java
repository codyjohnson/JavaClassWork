package Sep_11_2025;

public class Salaried extends FullTime {

    private double salary;

    public Salaried() {

    }

    public Salaried(String name, String address, Long id, double benefit_amount, double salary, int age) {
        super(name, address, id, benefit_amount, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SAL " + salary + " " + super.toString();
    }
}
