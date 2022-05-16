package swa;

import java.util.Arrays;

public class MaxDev {
    public static int getMaxFreqDeviation(String s) {
        char[] stringAsChars = s.toCharArray();
        Arrays.sort(stringAsChars);
        int min = 0;
        int max = 0;

        for(int x=0; x<stringAsChars.length ; ) {
            int counter = 0;
            for(int y=x; y<stringAsChars.length-1 ; y++) {
                if(stringAsChars[x] == stringAsChars[y]) {
                    counter++;
                    continue;
                } else if(counter > max) {
                    max = counter;
                } else if(counter<max && counter<min) {
                    min = counter;
                }
                x+=counter;
                break;
            }
        }

        return max-min;
    }
}
