package Sep_3_2025;

import java.util.Random;

/*
 * Author: Cody Johnson
 * Activity: Exam 1
 * Class: Object-Oriented Programming (Java) (31498)
 * Date: 20250903
 */

public class Main {

    public static void main(String[] args) {

        //Initial integer array for use in the sorting algorithm
        int[] arr = {11, 25, 64, 7, 5, 6, 9, 101, 1, 2, 15};

        //Creation of random object to use for selecting the first random index
        Random random = new Random();

        //Selection of the first random index that will be provided to the sorting method. Start is inclusive. End is exclusive
        int randIndex = random.nextInt(0, arr.length);

        //Printout of initial unsorted array
        System.out.print("Unsorted array: [");
        for (int i = 0; i < arr.length; i++) {
            if  (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else  {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");

        //New line
        System.out.println("\n");

        //Calling the sorting algorithm with initial array, left/right indices, and the random index
        partition(arr,0,arr.length-1, randIndex);

        //Printout of sorted array
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            if  (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else  {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    //Sorting algorithm that splits array into two at a random index. One array produced from split has values lower than the value at the random index.
    //The other array has values higher than the value at the random index. The method then recursively calls itself to select new random indices as the array
    //continues to split and conduct value comparisons
    public static void partition(int[] arr, int left, int right, int randNumIndex) {

        //Terminating condition. Returns when left of the array is equal to or greater than the right-most index
        if  (left >= right) {
            return;
        }

        //Capturing the value at the provided random index
        int randNumValue = arr[randNumIndex];

        //Temporary array (one) used to store values less than the value of randNumValue. Size is set to original array size for safety. Counter is
        //created to track the true size of the array
        int[] arr1 = new int[arr.length];
        int arr1Counter = 0;

        //Temporary array (two) used to store values greater than the value of randNumValue. Size is set to original array size for safety. Counter is
        //created to track the true size of the array
        int[] arr2 = new int[arr.length];
        int arr2Counter = 0;

        //Random number value comparison at each index and the loading of both temporary arrays
        for (int i = left; i <= right; i++) {
            //Left-side smaller number temp array
            if (arr[i] < randNumValue) {
                arr1[arr1Counter++] = arr[i];
            }
            //Right-side bigger number temp array
            if (arr[i] > randNumValue) {
                arr2[arr2Counter++] = arr[i];
            }
        }

        //Temp index used to overwrite original array values in the coming for loops
        int originalArrayNewIndex = left;

        //Overwriting left half of the original array with unsorted values smaller than the random number value
        for  (int i = 0; i < arr1Counter; i++) {
            arr[originalArrayNewIndex++] = arr1[i];
        }

        //Correctly ordered final placement of the random number value into the original array
        arr[originalArrayNewIndex++] = randNumValue;

        //Overwriting the right half of the original array with unsorted values greater than the random number value
        for (int i = 0; i < arr2Counter; i++) {
            arr[originalArrayNewIndex++] = arr2[i];
        }

        //Creation of a new index used to track where the last random number value was placed in the original array
        int partitionIndex = left + arr1Counter;

        //Creation of a random object to create new random index selection for follow-on recursive calls to the sorting method
        Random random = new Random();

        //Guard clause used to ensure left array has at least one element before making a recursive call to the sorting method
        if (left < partitionIndex) {
            //Recursive call to the sorting method targeting the left array while selecting a new random index within the left array's range
            partition(arr, left, partitionIndex - 1, random.nextInt(left, partitionIndex));
        }

        //Guard clause used to ensure right array has at least one element before making a recursive call to the sorting method
        if (partitionIndex < right) {
            //Recursive call to the sorting method targeting the right array while selecting a new random index within the right array's range
            partition(arr, partitionIndex + 1, right, random.nextInt(partitionIndex + 1, right + 1));
        }
    }
}