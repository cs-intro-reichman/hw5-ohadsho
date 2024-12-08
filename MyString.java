import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        String runi = "runi";
       System.out.println(subsetOf("silent","s i l e n t"));
      System.out.println(countChar(hello, 'l'));
       System.out.println(countChar(hello, 'z'));
        System.out.println(remove("committee", "meet"));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        if (str.isEmpty()) {
            return 0;
        }
        int counter =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) ==ch){
                counter++;
            }

        }
        return counter;
        
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if(str2.length()<str1.length() )
        return false;

        if(str1.isEmpty())
        return true;

        for(int i=0;i<str1.length(); i++){
            if(countChar(str1 , str1.charAt(i)) > countChar(str2 , str2.charAt(i)))
            return false;
        }
        return true;      
    }


    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str.isEmpty() ||str == null ) {
            return" ";
        }

        String spacedStr = str;
        for(int i=0; i<str.length() +str.length() -1 ;i++){
            spacedStr = spacedStr.substring(0, i) + " " + spacedStr.substring(i);
            i++;
        }
        return spacedStr ;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        Random r = new Random();
        String randomStr = "";
        for(int i=0; i<n ; i++){
            char c = (char)(r.nextInt(26) + 'a');
            randomStr = randomStr + c; 
        }
        return randomStr;


        
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if(str2 == null || str2.isEmpty())
        return str1;

        if(str1 == null || str1.isEmpty())
        return " ";


        if(str1.equals(str2))
        return "";


        String copyStr1 = str1;
        String copyStr2 = str2;


        for(int i=0; i < copyStr1.length() ; i++){
            if(copyStr1.charAt(i) == copyStr2.charAt(0) ){
                copyStr1 =  copyStr1.substring(0,i) + copyStr1.substring(i+1,copyStr1.length());
                copyStr2 =  copyStr2.substring(0,0) + copyStr2.substring(0+1,copyStr2.length());
                i--;
            }

        }
        return copyStr1;
      
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
