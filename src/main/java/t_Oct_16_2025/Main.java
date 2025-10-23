package t_Oct_16_2025;

public class Main {

    public static void main(String[] args) {

    }


//    Return true if the given string contains between 1 and 3 'e' chars.
//
//
//    stringE("Hello") → true
//    stringE("Heelle") → true
//    stringE("Heelele") → false

    public boolean stringE(String str) {
        int eCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                eCounter++;
            }
        }

        return eCounter >= 1 && eCounter <= 3;
    }

//    Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57.
//    Note that the % "mod" operator computes remainders, so 17 % 10 is 7.
//
//    lastDigit(7, 17) → true
//    lastDigit(6, 17) → false
//    lastDigit(3, 113) → true

    public boolean lastDigit(int a, int b) {

        while (a >= 10) {
            a = a % 10;
        }

        while (b >= 10) {
            b = b % 10;
        }
        return a == b;
    }

//    Given a string, return a new string where the last 3 chars are now in upper case.
//    If the string has less than 3 chars, uppercase whatever is there.
//    Note that str.toUpperCase() returns the uppercase version of a string.
//
//
//    endUp("Hello") → "HeLLO"
//    endUp("hi there") → "hi thERE"
//    endUp("hi") → "HI"

    public String endUp(String str) {
        if (str.length() < 3) {
            return str.toUpperCase();
        }

        String newString = "";

        String tempStart = str.substring(0, str.length() - 3);
        String tempEnd = str.substring(str.length() - 3);

        tempEnd = tempEnd.toUpperCase();

        return  tempStart + tempEnd;
    }
}