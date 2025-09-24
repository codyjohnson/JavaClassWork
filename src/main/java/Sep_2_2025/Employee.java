package Sep_2_2025;

public class Employee implements Comparable<Employee> {

    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int age, double salary) {
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int compareTo(Employee emp) {
        return Double.compare(this.salary, emp.salary);
    }
}
