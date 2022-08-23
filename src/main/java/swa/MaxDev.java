package swa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxDev {

    public static int viaLastIndex(String s) {
        char[] stringAsChars = s.toCharArray();
        Arrays.sort(stringAsChars);
        String sortedString = String.valueOf(stringAsChars);

        List<Integer> countList = new ArrayList<>();
        for(int x=0; x<sortedString.length() ; ) {
            int firstIndexOfChar = sortedString.indexOf(stringAsChars[x], x);
            int lastIndexOfChar = sortedString.lastIndexOf(stringAsChars[x], firstIndexOfChar);
            if (firstIndexOfChar == lastIndexOfChar) {
                countList.add(1);
            } else {
                countList.add(lastIndexOfChar-firstIndexOfChar);
            }
            x = x + lastIndexOfChar + 1;
        }
        Collections.sort(countList);
        return deductMinFromMax(countList);
    }

    public static int getMaxFreqDeviation(String s) {
        char[] stringAsChars = s.toCharArray();
        Arrays.sort(stringAsChars);

        List<Integer> countList = new ArrayList<>();
        for(int x=0; x<stringAsChars.length ; ) {
            int counter = 0;
            for(int y=x; y<stringAsChars.length ; y++) {
                if(stringAsChars[x] == stringAsChars[y]) {
                    counter++;
                    if(x+counter >= stringAsChars.length){
                        x+=counter;
                    }
                    continue;
                }
                x+=counter;
                break;
            }
            countList.add(counter);
        }
        Collections.sort(countList);
        return deductMinFromMax(countList);
    }

    private static int deductMinFromMax(List<Integer> countList) {
        if (countList.isEmpty()) {
            return 0;
        } else if (countList.get(0).equals(countList.get(countList.size() - 1))) {
            return countList.get(0);
        } else {
            return countList.get(countList.size()-1) - countList.get(0);
        }
    }
}
