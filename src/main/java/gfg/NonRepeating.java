package gfg;

import java.util.HashSet;
import java.util.Set;

public class NonRepeating {
    public static char getNonRepeating(String paramString) {
        char returnChar = '$';
        Set validatedChars = new HashSet<>();

        char[] stringAsCharArray = paramString.toCharArray();
        for(char currentChar: stringAsCharArray) {
            if(validatedChars.contains(currentChar)) {
                continue;
            }
            if(paramString.chars().filter(ch -> ch == currentChar).count() == 1) {
                return currentChar;
            }
            validatedChars.add(currentChar);
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
