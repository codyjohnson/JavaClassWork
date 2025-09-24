package Sep_11_2025;

public abstract class Employee {

    private String name;
    private int age;
    private String address;
    private Long id;

    public Employee() {

    };

    public Employee(String name, String address, Long id, int age) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp " + name + " " + age + " " + address + " " + id + "\n";
    }
}
