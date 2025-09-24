package Aug_28_2025;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 5, 7, 12, 4};
        int length = arr.length;
        System.out.println(func1(arr, length));
        System.out.println(10 + 5 + 7 + 12 + 4);

    }


    public static int func1(int[] arr, int length) {
        if (length == 0)
            return 0;

        return arr[length - 1] + func1(arr, --length);
    }
}
