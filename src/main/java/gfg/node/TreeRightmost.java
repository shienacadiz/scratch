package gfg.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeRightmost {
    private ArrayList<Integer> rightmostList = new ArrayList<>();

    private Map<Integer, Integer> levelMap = new TreeMap<>();
    ArrayList<Integer> rightView(TreeNode node) {
        getRightMost(node, 1);
        for(Map.Entry<Integer, Integer> cur : levelMap.entrySet()) {
            rightmostList.add(cur.getValue());
        }
        return rightmostList;
    }

    private void getRightMost(TreeNode currentNode, int depth) {
        if(Objects.nonNull(currentNode)) {
            System.out.println("Value: " + currentNode + "Depth: " + depth);
            levelMap.putIfAbsent(depth, currentNode.data);
            if (Objects.nonNull(currentNode.right)) {
                getRightMost(currentNode.right, depth+1);
            }
            if (Objects.nonNull(currentNode.left)) {
                getRightMost(currentNode.left, depth+1);
            }
        }
    }
}
