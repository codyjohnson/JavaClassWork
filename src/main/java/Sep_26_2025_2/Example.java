package Sep_26_2025_2;

public class Example {

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 9, 1, 3};
        System.out.println("Before sorting:");
        printArray(intArray);

        bubbleSort(intArray);

        System.out.println("After sorting:");
        printArray(intArray);

        String[] stringArray = {"banana", "apple", "orange", "grape"};
        System.out.println("\nBefore sorting:");
        printArray(stringArray);

        bubbleSort(stringArray);

        System.out.println("After sorting:");
        printArray(stringArray);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void printArray(T[] array) {

        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}