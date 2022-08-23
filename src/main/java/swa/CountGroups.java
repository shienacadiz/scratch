package swa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountGroups {

    public static int countGroups(List<String> related) {
        List<Set<Integer>> groupList = new ArrayList<>();
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        for(int x=0 ; x<related.size() ; x++){
            char[] ch = related.get(x).toCharArray();
            Set<Integer> pairedList = new HashSet<>();
            for(int y=0 ; y<ch.length ; y++) {
                if(x==y) {
                    continue;
                }
                if(ch[y] == '1') {
                    pairedList.add(y);
                }
            }
            groups.put(x, pairedList);
        }

        groups.entrySet().stream().forEach(group -> {
            if (group.getValue().isEmpty()) {
                groupList.add(new HashSet<>(Arrays.asList(group.getKey())));
            } else {
                group.getValue().stream().forEach(item -> {});
            }


//            else if(!isFound(groupList, group.getKey())) {
//                Set<Integer> currentSet = new HashSet<>();
//                currentSet.add(group.getKey());
//                group.getValue().stream().forEach(item -> currentSet.add(item));
//                groupList.add(currentSet);
//            }
        });

        return groupList.size();
    }

    public static boolean isFound(List<Set<Integer>> integerSet, int numToBeFound) {
        boolean isFound = false;

        for(Set<Integer> currentSet : integerSet) {
            if(currentSet.contains(numToBeFound)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
}
