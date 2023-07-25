package gfg;

/**
 * Given a string S consisting of lowercase Latin Letters.
 * Return the first non-repeating character in S. If there is no non-repeating character, return '$'.
 *
 * Input:
 * S = zxvczbtxyzvy
 * Output: c
 * Explanation: In the given string, 'c' is
 * the character which is non-repeating.
 *
 * https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/0
 */
public class NonRepeating {
    public static char getNonRepeating(String paramString) {
        char returnChar = '$';

        char[] stringAsCharArray = paramString.toCharArray();
        for(char currentChar: stringAsCharArray) {
            if(paramString.chars().filter(ch -> ch == currentChar).count() == 1) {
                return currentChar;
            }
        }
        return returnChar;
    }

    public static char getNonRepeatingOthers(String S)
    {
        for(char i:S.toCharArray()){
            if(S.indexOf(i)==S.lastIndexOf(i)){
                return i;
            }
        }
        return '$';
    }
}
