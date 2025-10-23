package t_Oct_22_2025;

public class Main {

    public static void main(String[] args) {

    }


//        Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
//
//
//        everyNth("Miracle", 2) → "Mrce"
//        everyNth("abcdefg", 2) → "aceg"
//        everyNth("abcdefg", 3) → "adg"

    public String everyNth(String str, int n) {

        String output = "";

        for (int i = 0; i < str.length(); i += n) {
            output += str.charAt(i);
        }

        return output;
    }


//    Given a string and a non-negative int n, return a larger string that is n copies of the original string.
//
//
//    stringTimes("Hi", 2) → "HiHi"
//    stringTimes("Hi", 3) → "HiHiHi"
//    stringTimes("Hi", 1) → "Hi"

    public String stringTimes(String str, int n) {

        String output = "";

        for (int i = 0; i < n; i++) {
            output += str;
        }
        return output;
    }


//    Given a string and a non-negative int n,
//    we'll say that the front of the string is the first 3 chars,
//    or whatever is there if the string is less than length 3.
//    Return n copies of the front;
//
//    frontTimes("Chocolate", 2) → "ChoCho"
//    frontTimes("Chocolate", 3) → "ChoChoCho"
//    frontTimes("Abc", 3) → "AbcAbcAbc"

    public String frontTimes(String str, int n) {

        String front = "";
        int counter = 0;

        while (counter < 3 && counter < str.length()) {
            front += str.charAt(counter);
            counter++;
        }

        String output = "";

        for (int i = 0; i < n; i++) {
            output += front;
        }
        return output;

    }

//    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
//
//
//    countXX("abcxx") → 1
//    countXX("xxx") → 2
//    countXX("xxxx") → 3

    int countXX(String str) {
        str = str.toLowerCase();
        int xCounterInLoop = 0;
        int xPairCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                xCounterInLoop++;
            } else {
                xCounterInLoop = 0;
            }
            if (xCounterInLoop == 2) {
                xPairCounter++;
                xCounterInLoop--;
            }
        }
        return xPairCounter;
    }


//    Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
//
//
//    doubleX("axxbb") → true
//    doubleX("axaxax") → false
//    doubleX("xxxxx") → true

    boolean doubleX(String str) {
        str = str.toLowerCase();
        int xCounterInLoop = 0;
        boolean firstXFound = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                xCounterInLoop++;
                firstXFound = true;
            } else {
                xCounterInLoop = 0;
                if (firstXFound) {
                    return false;
                }
            }
            if (xCounterInLoop == 2) {
                return true;
            }
        }
        return false;
    }

//    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
//
//
//    stringBits("Hello") → "Hlo"
//    stringBits("Hi") → "H"
//    stringBits("Heeololeo") → "Hello"

    public String stringBits(String str) {
        String output = "";
        for (int i = 0; i < str.length(); i += 2) {
            output += str.charAt(i);
        }
        return output;
    }

//    Given a non-empty string like "Code" return a string like "CCoCodCode".
//
//
//    stringSplosion("Code") → "CCoCodCode"
//    stringSplosion("abc") → "aababc"
//    stringSplosion("ab") → "aab"

    public String stringSplosion(String str) {
        String output = "";
        String piece = "";

        for (int i = 0; i < str.length(); i++) {
            piece = str.substring(0, i + 1);
            output += piece;
        }
        return output;
    }

//    Given a string, return the count of the number of times that a substring length 2 appears in the string
//    and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
//
//    last2("hixxhi") → 1
//    last2("xaxxaxaxx") → 1
//    last2("axxxaaxx") → 2

    public int last2(String str) {
        if (str.length() < 2) {
            return 0;
        }

        String subStrPair = str.substring(str.length() - 2);
        String pairToCompare = "";
        int matchCounter = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            pairToCompare = str.substring(i, i + 2);
            if (pairToCompare.equals(subStrPair)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }


//    Given an array of ints, return the number of 9's in the array.
//
//    arrayCount9([1, 2, 9]) → 1
//    arrayCount9([1, 9, 9]) → 2
//    arrayCount9([1, 9, 9, 3, 9]) → 3

    public int arrayCount9(int[] nums) {
        int nineCount = 0;

        for (int num : nums) {
            if (num == 9) {
                nineCount++;
            }
        }
        return nineCount;
    }

//    Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
//
//
//    arrayFront9([1, 2, 9, 3, 4]) → true
//    arrayFront9([1, 2, 3, 4, 9]) → false
//    arrayFront9([1, 2, 3, 4, 5]) → false

    public boolean arrayFront9(int[] nums) {
        int index = 0;

        while (index < nums.length && index < 4) {
            if (nums[index] == 9) {
                return true;
            }
            index++;
        }
        return false;
    }
}