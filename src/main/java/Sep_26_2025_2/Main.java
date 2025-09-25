package Sep_26_2025_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {5,32,1,4,5,234,1,42};

        System.out.println(Arrays.toString(arr));

        Helper helper = new Helper();

        helper.bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

        String[] arr1 = {"b","d","a","c"};

        System.out.println(Arrays.toString(arr1));

        helper.bubbleSort(arr1);

        System.out.println(Arrays.toString(arr1));

        Double[] arr2 = {1.5,7.8,2.2,3.4,5.8};

        System.out.println(Arrays.toString(arr2));

        helper.bubbleSort(arr2);

        System.out.println(Arrays.toString(arr2));

        Employee[] arr3 = {new Employee("Cody", 99), new Employee("Luke",2),new Employee("Penelope",1), new Employee("Ileana",30)};

        System.out.println(Arrays.toString(arr3));

        helper.bubbleSort(arr3);

        System.out.println(Arrays.toString(arr3));


    }






}
