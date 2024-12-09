import java.util.Random;

public class MyString {
    public static void main(String[] args) {
        // Test cases can be added here or use the MyStringTest class to test.
    }

    public static int countChar(String str, char ch) {
        int counter = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean subsetOf(String str1, String str2) {
        if (str2 == null || str1 == null || str2.length() < str1.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str1, str1.charAt(i)) > countChar(str2, str1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String spacedString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String spacedStr = "";
        for (int i = 0; i < str.length(); i++) {
            spacedStr += str.charAt(i);
            if (i < str.length() - 1) {
                spacedStr += " ";
            }
        }
        return spacedStr;
    }

    public static String randomStringOfLetters(int n) {
        if (n <= 0) {
            return "";
        }
        Random r = new Random();
        String randomStr = "";
        for (int i = 0; i < n; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            randomStr += c;
        }
        return randomStr;
    }

    public static String remove(String str1, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return str1;
        }
        if (str1 == null || str1.isEmpty()) {
            return "";
        }
        for (int i = 0; i < str2.length(); i++) {
            int charIndex = str1.indexOf(str2.charAt(i));
            if (charIndex != -1) {
                str1 = str1.substring(0, charIndex) + str1.substring(charIndex + 1);
            }
        }
        return str1;
    }

    public static String insertRandomly(char ch, String str) {
        if (str == null) {
            str = "";
        }
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        return str.substring(0, randomIndex) + ch + str.substring(randomIndex);
    }
}