package Sep_17_2025_Activity;

import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

//      Write a Java recursive method to find the maximum element in an array.
        int[] arr1 = {5, 10, 2, 38, 16, 3, 20, 9};
        int index = 0;
        int maxElement = arr1[0];
        System.out.println("Maximum element recursive method.");
        Main.maximumElement(arr1, maxElement, index);
        System.out.println("\n");

//      Write a Java recursive method to check if a given array is sorted in ascending order.
        int[] arr2 = {5, 10, 2, 38, 16, 3, 20, 9};
        int arr2Length = arr2.length;
        System.out.println("Sorted in ascending order checker given an - unsorted array.");
        Main.arrayIsSorted(arr2, arr2Length);
        System.out.println("\n");
        int[] arr3 = {2, 10, 15, 54, 102, 132, 200, 999};
        int arr3Length = arr3.length;
        System.out.println("Sorted in ascending order checker given a - sorted array.");
        Main.arrayIsSorted(arr3, arr3Length);
    }

    static void maximumElement(int[] arr1, int maxElement, int index) {

        if (index == arr1.length) {
            System.out.println("Largest element: " + maxElement);
            return;
        }

        if (arr1[index] > maxElement) {
            maxElement = arr1[index++];
            maximumElement(arr1, maxElement, index);
        } else {
            index++;
            maximumElement(arr1, maxElement, index);
        }

    }

    static void arrayIsSorted(int[] arr, int length) {
        if  (length == 1) {
            System.out.println("Array is sorted");
            return;
        }

        if (arr[length - 1] > arr[length - 2]) {
            arrayIsSorted(arr, length - 1);
        }  else {
            System.out.println("Array is not sorted");
        }
    }
}
