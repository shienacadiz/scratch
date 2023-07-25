package gfg.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given a binary tree and the task is to find the spiral order traversal of the tree.
 *
 * Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's
 * value from right to left and for all the odd levels we print the node's value from left to right.
 *
 * For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
 *
 *         1
 *       /   \
 *      2     3
 *    /  \  /  \
 *   7   6 5   4
 *
 * https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/0
 */
public class TreeSpiral {
    private Map<Integer, List<TreeNode>> treeNodeMap = new HashMap<>();
    private ArrayList<Integer> spiralNodeList = new ArrayList<>();
    ArrayList<Integer> findSpiral(TreeNode treeNode)
    {
        if(Objects.nonNull(treeNode)) {
           spiralNodeList.add(treeNode.data);
        }
        collapse(treeNode, 1);
        generateSpiral();
        return spiralNodeList;
    }

    private void generateSpiral() {
        for(Map.Entry<Integer, List<TreeNode>> currentTree : treeNodeMap.entrySet()) {
            addToSpiralList(currentTree.getValue(), currentTree.getKey()%2==0);
        }
    }

    private void addToSpiralList(List<TreeNode> nodeList, boolean isReversed) {
        if(isReversed) {
            Collections.reverse(nodeList);
        }
        nodeList.forEach(node -> {
            if(isReversed) {
                if(Objects.nonNull(node.right)) {
                    spiralNodeList.add(node.right.data);
                }
                if(Objects.nonNull(node.left)) {
                    spiralNodeList.add(node.left.data);
                }
            } else {
                if(Objects.nonNull(node.left)) {
                    spiralNodeList.add(node.left.data);
                }
                if(Objects.nonNull(node.right)) {
                    spiralNodeList.add(node.right.data);
                }
            }
        });
    }

    private void collapse(TreeNode treeNode, int level) {
        if(Objects.nonNull(treeNode)) {
            addToTreeNodeList(treeNode, level);
        }
        if(Objects.nonNull(treeNode.left)) {
            collapse(treeNode.left, level+1);
        }
        if(Objects.nonNull(treeNode.right)) {
            collapse(treeNode.right, level+1);
        }
    }

    private void addToTreeNodeList(TreeNode node, int level) {
        if(treeNodeMap.containsKey(level)) {
            treeNodeMap.get(level).add(node);
        } else {
            treeNodeMap.put(level, new ArrayList<>(Arrays.asList(node)));
        }
    }
}
