package Sep_10_2025;
/*
 * Author: Cody Johnson
 * Activity: Sep_10_2025 Exam 2
 * Class: Object-Oriented Programming (Java) (31498)
 * Date: 20250910
 */

public class Main {

    public static void main(String[] args) {

//        1. Write a Java program to swap two string variables without using third or temp variable?

        String str1 = "Cody";

        String str2 = "Johnson";

        System.out.println("Before Swap:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2 + "\n");

        str2 = str1 + str2;

        str1 = str2.substring(str1.length());

        str2 = str2.substring(0, str2.length() - str1.length());

        System.out.println("After Swap:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

//        2. Write a Java program to find all permutations of a string recursively.

        String str = "JSP";

        String prefix = "";
        String remaining =  str;

        System.out.println("\n\nPermutations:");

        Main.permutations(prefix, remaining);
    }

    static void permutations(String s1, String s2) {

        if (s2.length() == 0) {
            System.out.println(s1);
            return;
        }

        for (int i = 0; i < s2.length(); i++) {
            permutations(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1, s2.length()));
        }
    }
}