package Sep_2_2025;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private double gpa;

    public Student() {
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    public int compareTo(Student student) {
        if (Double.compare(this.gpa, student.gpa) > 0) {
            return 1;
        }  else if (Double.compare(this.gpa, student.gpa) < 0) {
            return -1;
        } else {
            if (Integer.compare(this.age, student.age) > 0) {
                return 1;
            }   else if (Integer.compare(this.age, student.age) < 0) {
                return -1;
            } else {
                if (this.name.compareTo(student.name) > 0) {
                    return 1;
                } else if  (this.name.compareTo(student.name) < 0) {
                    return -1;
                } else  {
                    return 0;
                }
            }
        }
    }
}