package t_Oct_23_2025;

public class Main {
    public static void main(String[] args) {

    }


//    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
//
//
//    array123([1, 1, 2, 3, 1]) → true
//    array123([1, 1, 2, 4, 1]) → false
//    array123([1, 1, 2, 1, 2, 3]) → true

    public boolean array123(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }


//    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
//    So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
//
//
//    stringMatch("xxcaazz", "xxbaaz") → 3
//    stringMatch("abc", "abc") → 2
//    stringMatch("abc", "axc") → 0

    public int stringMatch(String a, String b) {
        int matchCounter = 0;
        int index = 0;

        while (index < a.length() - 1 && index < b.length() - 1) {
            if (a.substring(index, index + 2).equals(b.substring(index, index + 2))) {
                matchCounter++;
            }
            index++;
        }
        return matchCounter;
    }


//    Given a string, return a version where all the "x" have been removed.
//    Except an "x" at the very start or end should not be removed.
//
//    stringX("xxHxix") → "xHix"
//    stringX("abxxxcd") → "abcd"
//    stringX("xabxxxcdx") → "xabcdx"

    public String stringX(String str) {
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'x' || i == 0 || i == str.length() - 1) {
                newString += str.charAt(i);
            }
        }
        return newString;
    }

//    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//
//
//    altPairs("kitten") → "kien"
//    altPairs("Chocolate") → "Chole"
//    altPairs("CodingHorror") → "Congrr"

    public String altPairs(String str) {
        String newString = "";

        if (str.length() > 1) {
            newString += str.charAt(0);
            newString += str.charAt(1);
        } else {
            newString += str;
        }

        if (str.length() >= 4) {
            newString += str.charAt(4);
        }

        if (str.length() > 5) {
            newString += str.charAt(5);
        }

        if (str.length() > 8) {
            newString += str.charAt(8);
        }

        if (str.length() > 9) {
            newString += str.charAt(9);
        }

        if (str.length() > 13) {
            newString += str.charAt(12);
            newString += str.charAt(13);
        }

        return newString;
    }



//    Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed,
//    but the "a" can be any char. The "yak" strings will not overlap.
//
//
//    stringYak("yakpak") → "pak"
//    stringYak("pakyak") → "pak"
//    stringYak("yak123ya") → "123ya"

    public String stringYak(String str) {
        int yakCounter = 0;
        boolean yak = true;

        if (str.length() < 3) {
            return str;
        }

        while (yak) {
            for (int i = 0; i < str.length() - 2; i++) {
                if (str.charAt(i) == 'y' && str.charAt(i + 1) == 'a' && str.charAt(i + 2) == 'k') {
                    yakCounter++;
                    str = str.substring(0,i) + str.substring(i + 3);
                }
            }
            if (yakCounter == 0) {
                yak = false;
            }
            yakCounter = 0;
        }
        return str;
    }


//    Given an array of ints, return the number of times that two 6's are next to each other in the array.
//    Also count instances where the second "6" is actually a 7.
//
//
//    array667([6, 6, 2]) → 1
//    array667([6, 6, 2, 6]) → 1
//    array667([6, 7, 2, 6]) → 1

    public int array667(int[] nums) {
        int matchCounter = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }


//    Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
//    Return true if the array does not contain any triples.
//
//    noTriples([1, 1, 2, 2, 1]) → true
//    noTriples([1, 1, 2, 2, 2, 1]) → false
//    noTriples([1, 1, 1, 2, 2, 2, 1]) → false

    public boolean noTriples(int[] nums) {
        boolean noTriples = true;

        if (nums.length < 3) {
            return noTriples;
        }

        if (nums.length == 3) {
            if ((nums[0] == nums[1]) && (nums[1] == nums[2])) {
                noTriples = false;
            }
        }

            for (int i = 0; i < nums.length - 3; i++) {
                if ((nums[i] == nums[i + 1]) && (nums[i + 1] == nums[i + 2])) {
                    noTriples = false;
                    break;
                }
            }
        return noTriples;
    }


//    Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value,
//    followed by the value plus 5, followed by the value minus 1.
//    Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
//
//    has271([1, 2, 7, 1]) → true
//    has271([1, 2, 8, 1]) → false
//    has271([2, 7, 1]) → true

    public boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 5 ) {
                if (nums[i + 2] >= nums[i] - 3) {
                    if (nums[i + 2] <= nums[i] + 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


//    Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
//
//    helloName("Bob") → "Hello Bob!"
//    helloName("Alice") → "Hello Alice!"
//    helloName("X") → "Hello X!"

    public String helloName(String name) {
        return "Hello " + name + "!";
    }


//    Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
//
//    makeAbba("Hi", "Bye") → "HiByeByeHi"
//    makeAbba("Yo", "Alice") → "YoAliceAliceYo"
//    makeAbba("What", "Up") → "WhatUpUpWhat"

    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }


//    The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text.
//    In this example, the "i" tag makes <i> and </i> which surround the word "Yay".
//    Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".
//
//    makeTags("i", "Yay") → "<i>Yay</i>"
//    makeTags("i", "Hello") → "<i>Hello</i>"
//    makeTags("cite", "Yay") → "<cite>Yay</cite>"

    public String makeTags(String tag, String word) {
        return String.format("<%s>%s</%s>", tag, word, tag);
    }


//    Given an "out" string length 4, such as "<<>>",
//    and a word, return a new string where the word is in the middle of the out string, e.g. "<<word>>".
//    Note: use str.substring(i, j) to extract the String starting at index i
//    and going up to but not including index j.
//
//    makeOutWord("<<>>", "Yay") → "<<Yay>>"
//    makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
//    makeOutWord("[[]]", "word") → "[[word]]"

    public String makeOutWord(String out, String word) {
        String left = out.substring(0, out.length() / 2);
        String right = out.substring(out.length() / 2);

        return left + word + right;
    }

//    Given a string, return a new string made of 3 copies of the last 2 chars
//    of the original string. The string length will be at least 2.
//
//    extraEnd("Hello") → "lololo"
//    extraEnd("ab") → "ababab"
//    extraEnd("Hi") → "HiHiHi"

    public String extraEnd(String str) {
        return str.substring(str.length() - 2) + str.substring(str.length() - 2) + str.substring(str.length() - 2);
    }


//    Given a string, return the string made of its first two chars,
//    so the String "Hello" yields "He". If the string is shorter than length 2,
//            return whatever there is, so "X" yields "X", and the empty string ""
//    yields the empty string "". Note that str.length() returns the length of a string.
//
//    firstTwo("Hello") → "He"
//    firstTwo("abcdefg") → "ab"
//    firstTwo("ab") → "ab"

    public String firstTwo(String str) {
        if  (str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }


//    Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
//
//    firstHalf("WooHoo") → "Woo"
//    firstHalf("HelloThere") → "Hello"
//    firstHalf("abcdef") → "abc"

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }


//    Given a string, return a version without the first and last char, so "Hello" yields "ell". The string length will be at least 2.
//
//    withoutEnd("Hello") → "ell"
//    withoutEnd("java") → "av"
//    withoutEnd("coding") → "odin"

    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }


//    Given 2 strings, a and b, return a string of the form short+long+short,
//    with the shorter string on the outside and the longer string on the inside.
//    The strings will not be the same length, but they may be empty (length 0).
//
//    comboString("Hello", "hi") → "hiHellohi"
//    comboString("hi", "Hello") → "hiHellohi"
//    comboString("aaa", "b") → "baaab"

    public String comboString(String a, String b) {
        if (a.length() > b.length()) {
            return b + a + b;
        }
        return a + b + a;
    }


//    Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.
//
//    nonStart("Hello", "There") → "ellohere"
//    nonStart("java", "code") → "avaode"
//    nonStart("shotl", "java") → "hotlava"

    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }


//    Given a string, return a "rotated left 2" version where the first 2 chars
//    are moved to the end. The string length will be at least 2.
//
//    left2("Hello") → "lloHe"
//    left2("java") → "vaja"
//    left2("Hi") → "Hi"

    public String left2(String str) {
        return str.substring(2) + str.substring(0,2);
    }


//    Given a string, return a "rotated right 2" version where the last 2 chars
//    are moved to the start. The string length will be at least 2.
//
//    right2("Hello") → "loHel"
//    right2("java") → "vaja"
//    right2("Hi") → "Hi"

    public String right2(String str) {
        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }


//    Given a string, return a string length 1 from its front, unless front is false,
//    in which case return a string length 1 from its back. The string will be non-empty.
//
//    theEnd("Hello", true) → "H"
//    theEnd("Hello", false) → "o"
//    theEnd("oh", true) → "o"

    public String theEnd(String str, boolean front) {
        return front ? str.substring(0,1) : str.substring(str.length() - 1);
    }


//    Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.
//
//    withouEnd2("Hello") → "ell"
//    withouEnd2("abc") → "b"
//    withouEnd2("ab") → ""

    public String withouEnd2(String str) {
        return str.length() <= 1 ? "" : str.substring(1, str.length() - 1);
    }


//    Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri".
//    The string length will be at least 2.
//
//    middleTwo("string") → "ri"
//    middleTwo("code") → "od"
//    middleTwo("Practice") → "ct"

    public String middleTwo(String str) {
        return str.length() <= 1 ? "" : str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }


//    Given a string, return true if it ends in "ly".
//
//    endsLy("oddly") → true
//    endsLy("y") → false
//    endsLy("oddy") → false


    public boolean endsLy(String str) {
        return str.endsWith("ly");
    }


//    Given a string and an int n, return a string made of the first and last n chars from the string.
//    The string length will be at least n.
//
//    nTwice("Hello", 2) → "Helo"
//    nTwice("Chocolate", 3) → "Choate"
//    nTwice("Chocolate", 1) → "Ce"

    public String nTwice(String str, int n) {
        return str.substring(0,n) + str.substring(str.length() - n);
    }


//    Given a string and an index, return a string length 2 starting at the given index.
//    If the index is too big or too small to define a string length 2, use the first 2 chars.
//    The string length will be at least 2.
//
//    twoChar("java", 0) → "ja"
//    twoChar("java", 2) → "va"
//    twoChar("java", 3) → "ja"

    public String twoChar(String str, int index) {
        if (str.length() - index < 2 || index < 0) {
            return str.substring(0,2);
        }
        return str.substring(index,index + 2);
    }

//    Given a string of odd length, return the string length 3 from its middle,
//    so "Candy" yields "and". The string length will be at least 3.
//
//    middleThree("Candy") → "and"
//    middleThree("and") → "and"
//    middleThree("solving") → "lvi"

    public String middleThree(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 2);
    }


//    Given a string, return true if "bad" appears starting at index 0 or 1 in the string,
//    such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0.
//    Note: use .equals() to compare 2 strings.
//
//    hasBad("badxx") → true
//    hasBad("xbadxx") → true
//    hasBad("xxbadxx") → false

    public boolean hasBad(String str) {
        if  (str.length() < 3) {
            return false;
        }

        if (str.substring(0,3).equals("bad")) {
            return true;
        }

        if (str.length() > 3 ) {
            if (str.substring(1,4).equals("bad")) {
                return true;
            }
        }
        return false;
    }


//    Given a string, return a string length 2 made of its first 2 chars.
//    If the string length is less than 2, use '@' for the missing chars.
//
//    atFirst("hello") → "he"
//    atFirst("hi") → "hi"
//    atFirst("h") → "h@"

    public String atFirst(String str) {

        if (str.length() < 1) {
            return "@@";
        }

        if (str.length() < 2) {
            return str.substring(0,1) + "@";
        }

        return str.substring(0, 2);
    }


//    Given 2 strings, a and b, return a new string made of the first char of a
//    and the last char of b, so "yo" and "java" yields "ya". If either string is length 0,
//    use '@' for its missing char.
//
//    lastChars("last", "chars") → "ls"
//    lastChars("yo", "java") → "ya"
//    lastChars("hi", "") → "h@"

    public String lastChars(String a, String b) {
        String aPart;
        if (a.length() < 1) {
            aPart = "@";
        } else {
            aPart = a.substring(0,1);
        }

        String bPart;
        if (b.length() < 1) {
            bPart = "@";
        } else {
            bPart = b.substring(b.length() - 1);
        }
        return aPart + bPart;
    }


//    Given two strings, append them together (known as "concatenation") and return the result.
//    However, if the concatenation creates a double-char, then omit one of the chars,
//    so "abc" and "cat" yields "abcat".
//
//    conCat("abc", "cat") → "abcat"
//    conCat("dog", "cat") → "dogcat"
//    conCat("abc", "") → "abc"

    public String conCat(String a, String b) {

        if (a.length() < 1) {
            return b;
        }

        if (b.length() < 1) {
            return a;
        }

        if (a.substring(a.length() - 1).equals(b.substring(0,1))) {
            return a.substring(0, a.length() - 1) + b;
        }
        return a + b;
    }


//    Given a string of any length, return a new string where the last 2 chars, if present,
//    are swapped, so "coding" yields "codign".
//
//    lastTwo("coding") → "codign"
//    lastTwo("cat") → "cta"
//    lastTwo("ab") → "ba"

    public String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }

        return str.substring(0,str.length() - 2) + str.substring(str.length() - 1) + str.charAt(str.length() - 2);
    }


//    Given a string, if the string begins with "red" or "blue" return that color string, otherwise return the empty string.
//
//    seeColor("redxx") → "red"
//    seeColor("xxred") → ""
//    seeColor("blueTimes") → "blue"

    public String seeColor(String str) {
        if (str.startsWith("blue")) {
            return "blue";
        }

        if (str.startsWith("red")) {
            return "red";
        }
        return "";
    }


//    Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".
//
//    frontAgain("edited") → true
//    frontAgain("edit") → false
//    frontAgain("ed") → true

    public boolean frontAgain(String str) {

    }

























}