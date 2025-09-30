//Name: Cody Johnson
//Class: Java Programming (Intermediate) (31502)
//Exam: Exam 1
//Date: 20250930

package Sep_30_2025;

public class Main {

    public static void main(String[] args) {

        Demo.demo();
    }
}




class Demo {

    public static void demo() {

        System.out.println("\nGeneric Quick Sort\n");

        //Integers
        System.out.println("Integers");
        Integer[] array1 = {7,2,4,1,11,23,14,6,8,9};
        System.out.print("Pre-sort: [");
        for (int i = 0; i < array1.length; i++) {
            if (i == array1.length - 1) {
                System.out.println(array1[i] + "]");
            } else {
                System.out.print(array1[i] + ", ");
            }
        }
        CustomSort.quickSort(array1, 0, array1.length - 1, array1.length / 2);
        System.out.print("Post-sort: [");
        for (int i = 0; i < array1.length; i++) {
            if (i == array1.length - 1) {
                System.out.println(array1[i] + "]");
            } else {
                System.out.print(array1[i] + ", ");
            }
        }
        System.out.println("\n");

        //Doubles
        System.out.println("Doubles");
        Double[] array2 = {12.1,7.8,5.4,2.3,10.9,9.3};
        System.out.print("Pre-sort: [");
        for (int i = 0; i < array2.length; i++) {
            if (i == array2.length - 1) {
                System.out.println(array2[i] + "]");
            } else {
                System.out.print(array2[i] + ", ");
            }
        }
        CustomSort.quickSort(array2, 0, array2.length - 1, array2.length / 2);
        System.out.print("Post-sort: [");
        for (int i = 0; i < array2.length; i++) {
            if (i == array2.length - 1) {
                System.out.println(array2[i] + "]");
            } else {
                System.out.print(array2[i] + ", ");
            }
        }
        System.out.println("\n");

        //Strings
        System.out.println("Strings");
        String[] array3 = {"Cody", "Ben", "Ileana", "Luke", "Penelope", "John"};
        System.out.print("Pre-sort: [");
        for (int i = 0; i < array3.length; i++) {
            if (i == array3.length - 1) {
                System.out.println(array3[i] + "]");
            } else {
                System.out.print(array3[i] + ", ");
            }
        }
        CustomSort.quickSort(array3, 0, array3.length - 1, array3.length / 2);
        System.out.print("Post-sort: [");
        for (int i = 0; i < array3.length; i++) {
            if (i == array3.length - 1) {
                System.out.println(array3[i] + "]");
            } else {
                System.out.print(array3[i] + ", ");
            }
        }
        System.out.println("\n");

        //Employees
        System.out.println("Employees");
        Employee[] array4 = {
                new Employee("Cody", 99),
                new Employee("Ben", 8),
                new Employee("Ileana", 9),
                new Employee("Luke", 17),
                new Employee("Penelope", 6),
                new Employee("John", 35),
        };
        System.out.print("Pre-sort: [");
        for (int i = 0; i < array4.length; i++) {
            if (i == array4.length - 1) {
                System.out.println(array4[i] + "]");
            } else {
                System.out.print(array4[i] + ", ");
            }
        }
        CustomSort.quickSort(array4, 0, array4.length - 1, array4.length / 2);
        System.out.print("Post-sort: [");
        for (int i = 0; i < array4.length; i++) {
            if (i == array4.length - 1) {
                System.out.println(array4[i] + "]");
            } else {
                System.out.print(array4[i] + ", ");
            }
        }
    }
}

class CustomSort {

    public static <T extends Comparable<T>> void quickSort(T[] inputArray, int left, int right, int randNumIndex) {

        if  (left >= right) {
            return;
        }

        T randNumValue = inputArray[randNumIndex];

        T[] smallArray = inputArray.clone();
        int smallArrayCounter = 0;

        T[] bigArray = inputArray.clone();
        int bigArrayCounter = 0;

        for (int i = left; i <= right; i++) {
            if (inputArray[i].compareTo(randNumValue) < 0) {
                smallArray[smallArrayCounter++] = inputArray[i];
            }
            if (inputArray[i].compareTo(randNumValue) > 0) {
                bigArray[bigArrayCounter++] = inputArray[i];
            }
        }

        int inputArrayNewIndex = left;

        for  (int i = 0; i < smallArrayCounter; i++) {
            inputArray[inputArrayNewIndex++] = smallArray[i];
        }

        int partitionIndex = inputArrayNewIndex;
        inputArray[inputArrayNewIndex++] = randNumValue;

        for (int i = 0; i < bigArrayCounter; i++) {
            inputArray[inputArrayNewIndex++] = bigArray[i];
        }

        if (left < partitionIndex) {
            quickSort(inputArray, left, partitionIndex - 1, left);
        }

        if (partitionIndex < right) {
            quickSort(inputArray, partitionIndex + 1, right, partitionIndex + 1);
        }
    }
}

class Employee implements Comparable<Employee> {

    String name;
    int age;

    public Employee(String name, int age) {
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
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}