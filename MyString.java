import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {

    public static void main(String[] args) {
        // Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     *
     * @param str - a string
     * @param ch - a character
     * @return the number of times ch appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns true if str1 is a subset string of str2, false otherwise.
     * Examples:
     * subsetOf("sap", "space") returns true
     * subsetOf("spa", "space") returns true
     * subsetOf("pass", "space") returns false
     * subsetOf("c", "space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true if str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i); 
            if (countChar(str1, c) > countChar(str2, c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     *
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            if (i < str.length() - 1) {
                result += " ";
            }
        }
        return result;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     *
     * Example: randomStringOfLetters(3) can return "zoo"
     *
     * @param n - the number of letters to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < n; i++) {
            char c = (char) ('a' + random.nextInt(26));
            result += c;
        }
        return result;
    }

    /**
     * Returns a string consisting of str1, minus all the characters in str2.
     * Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet", "committee") returns "comit".
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            char letter = str2.charAt(i);
            int index = str1.indexOf(letter);
            if (index != -1) {
                str1 = str1.substring(0, index) + str1.substring(index + 1);
            }
        }
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s", "cat") can return "scat", or "csat", or "cast", or "cats".
     *
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        return str.substring(0, randomIndex) + ch + str.substring(randomIndex);
    }
}