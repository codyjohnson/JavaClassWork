package Sep_4_2025;
/*
 * Author: Cody Johnson
 * Activity: Sep_4_2025 Class Work
 * Class: Object-Oriented Programming (Java) (31498)
 * Date: 20250904
 */
public class Main {

    public static void main(String[] args) {

        int[][] arr1 = new int[][]{{1, 3, 5}, {2, 1, 2}};

        System.out.println("arr1: ");
        printMatrix(arr1);

        int[][] arr2 = new int[][]{{2, 1}, {3, 2}, {4, 3}};

        System.out.println("arr2: ");
        printMatrix(arr2);

        System.out.println("result arr: ");
        printMatrix(multiplyMatrices(arr1, arr2));
    }

    public static int[][] multiplyMatrices(int[][] arr1, int[][] arr2) {

        if (!isPossibleCheck(arr1, arr2)) {
            System.out.println("Cannot multiply these matrices.");
            return new int[0][0];
        }

        int[][] resultArr = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                for (int k = 0; k < arr1[j].length; k++) {
                        resultArr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return resultArr;
    }

    public static boolean isPossibleCheck(int[][] arr1, int[][] arr2) {
        return arr1[0].length == arr2.length;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
