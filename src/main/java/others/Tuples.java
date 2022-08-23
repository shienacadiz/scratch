package others;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Write a function “encode”, that accepts a string, and emits a list of tuples (or list of lists). Each tuple in the list contains the count of subsequent characters encountered in the string.

Examples:
encode("abc") ==> [("a", 1), ("b", 1), ("c", 1)]
encode("assassin") ==> [("a", 1), ("s", 2), ("a", 1), ("s", 2), ("i", 1), ("n", 1)]
encode("")  ==>[]
 */
public class Tuples {
    private static int INDEX_COUNT_COUNTER = 1;

    public static List encode(String sourceString) {
        List<List<Object>> result = new ArrayList<>();
        List<Character> stringAsChars = sourceString.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        List<Object> charAndCountWrapper = new ArrayList<>();
        Character previousChar = null;
        for(int x=0; x<stringAsChars.size(); x++) {
            if(previousChar == stringAsChars.get(x)) {
                charAndCountWrapper.set(INDEX_COUNT_COUNTER, (int) charAndCountWrapper.get(INDEX_COUNT_COUNTER)+1);
                if( x+1 == stringAsChars.size()) {
                    result.add(charAndCountWrapper);
                }
            } else {
                previousChar = stringAsChars.get(x);
                if(!charAndCountWrapper.isEmpty()) {
                    result.add(charAndCountWrapper);
                }
                charAndCountWrapper = new ArrayList<>();
                charAndCountWrapper.add(stringAsChars.get(x));
                charAndCountWrapper.add(1);
                if(x+1 == stringAsChars.size()) {
                    result.add(charAndCountWrapper);
                }
            }
        }
        return result;
    }
}
