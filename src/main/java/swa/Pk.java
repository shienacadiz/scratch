package swa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pk {

    public static long getHeaviestPackage(List<Integer> packageWeights) {
        List<Integer> oldWeights = new ArrayList<>();
        List<Integer> newWeights = new ArrayList<>(packageWeights);

        while(!oldWeights.equals(newWeights)) {
            oldWeights = new ArrayList<>(newWeights);
            newWeights = mergePackage(newWeights);
        }
        Collections.sort(newWeights);
        return newWeights.get(newWeights.size()-1);
    }

    public static List<Integer> mergePackage(List<Integer> packageWeights) {
        List<Integer> sortedPackageWeights = new ArrayList<>(packageWeights);
        Collections.sort(sortedPackageWeights);

        boolean isFound = false;
        for(int x=0 ; x<sortedPackageWeights.size() && !isFound ; x++) {
            for(int y=0 ; y<packageWeights.size()-1 ; y++) {
                if((sortedPackageWeights.get(x) == packageWeights.get(y)) && (packageWeights.get(y) < packageWeights.get(y+1))) {
                    packageWeights.set(y, packageWeights.get(y) + packageWeights.get(y+1));
                    packageWeights.remove(y+1);
                    isFound = true;
                    break;
                }
            }
        }
        return packageWeights;
    }
}
