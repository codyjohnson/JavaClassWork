package Sep_27_2025;

public class Main {

    public static void main(String[] args) {

        Helper.demo();
    }
}

class Helper {

    public static void demo() {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Double[] doubleArray = {1.45, 2.45, 3.45, 4.69, 5.75, 6.45, 7.2, 8.5, 9.547};

        String[] stringArray = {"a", "b", "c", "d", "e", "f", "g", "h"};

        Student[] studentArray = {
                new Student("Cody",5),
                new Student("Ileana",10),
                new Student("Luke", 25),
                new Student("Penelope", 42)
        };

        Employee[] employeeArray = {
                new Employee("Cody","01"),
                new Employee("Ileana","02"),
                new Employee("Luke", "03"),
                new Employee("Penelope", "04")
        };

        System.out.println("Integers");
        System.out.println("Expected true: " + search(intArray, 7));
        System.out.println("Expected false: " + search(intArray, 88));

        System.out.println("\nDoubles");
        System.out.println("Expected true: " + search(doubleArray, 5.75));
        System.out.println("Expected false: " + search(doubleArray, 909.75));

        System.out.println("\nStrings");
        System.out.println("Expected true: " + search(stringArray, "e"));
        System.out.println("Expected false: " + search(stringArray, "z"));

        System.out.println("\nStudents");
        System.out.println("Expected true: " + search(studentArray, new Student("Cody",5)));
        System.out.println("Expected false: " + search(studentArray, new Student("Cody",99)));

        System.out.println("\nEmployees");
        System.out.println("Expected true: " + search(employeeArray, new Employee("Cody","01")));
        System.out.println("Expected false: " + search(employeeArray, new Employee("Cody","99324234234")));
    }

    public static <T extends Comparable<T>> boolean search(T[] array, T value) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int compare = value.compareTo(array[mid]);

            if (compare > 0)
                left = mid + 1;
            else if (compare < 0)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
}

class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

class Employee implements Comparable<Employee> {

    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }
}