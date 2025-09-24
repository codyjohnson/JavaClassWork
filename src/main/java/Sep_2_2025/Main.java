package Sep_2_2025;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

//        ArrayList<Employee> arr = new ArrayList<>();
//
//        arr.add(new Employee(52,40000));
//        arr.add(new Employee(41,32500));
//        arr.add(new Employee(37,4000));
//        arr.add(new Employee(23,115000));
//
//        System.out.println(arr);
//
//        Collections.sort(arr);
//
//        System.out.println(arr);


//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("Cody", 33, 3.7));
//        students.add(new Student("Jack", 23, 3.7));
//        students.add(new Student("Bob", 44, 4.0));
//        students.add(new Student("Sally", 33, 3.9));
//        students.add(new Student("Zach", 33, 3.9));
//
//        System.out.println(students);
//        Collections.sort(students);
//        System.out.println(students);


        int[] arr = new int[]{10, 3, 5, 11, 2, 12, 99, 17, 14, 1};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        Main.func1(arr,0,arr.length-1);



        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void func1(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        func1(arr, left, middle);
        func1(arr, middle + 1, right);
        func2(arr, left, middle, right);
    }

    public static void func2(int[] arr, int left, int middle, int right) {

        int[] arr1 = new int[middle - left + 1];
        int[] arr2 = new int[right - middle];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[left + i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[middle + 1 + i];
        }

        int arrNewIndex = left;
        int arr1Index = 0;
        int arr2Index = 0;

        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] < arr2[arr2Index]) {
                arr[arrNewIndex++] = arr1[arr1Index++];
            } else {
                arr[arrNewIndex++] = arr2[arr2Index++];
            }
        }

        while (arr1Index < arr1.length) {
            arr[arrNewIndex++] = arr1[arr1Index++];
        }

        while (arr2Index < arr2.length) {
            arr[arrNewIndex++] = arr2[arr2Index++];
        }
    }
}