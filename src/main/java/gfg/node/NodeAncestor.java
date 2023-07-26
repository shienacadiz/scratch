package gfg.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given a binary tree of size  N, a node, and a positive integer k., Your task is to complete the
 * function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree.
 * If there does not exist any such ancestor then return -1.
 *
 * Note: It is guaranteed that the node exists in the tree.
 *
 *         1
 *       /  \
 *      2   3
 *    /  \
 *   4   5
 *
 * Input:
 * K = 2 Node = 4
 * Output: 1
 * Explanation:
 * Since, K is 2 and node is 4, so we
 * first need to locate the node and
 * look k times its ancestors.
 * Here in this Case node 4 has 1 as his
 * 2nd Ancestor aka the Root of the tree.
 */
public class NodeAncestor {

    private Map<Integer, List<Integer>> treeNodeHierarchy = new HashMap<>();

    private int index;

    public int kthAncestor(TreeNode root, int ancestorLevel, int node) {
        int ancestorValue = -1;
        List<Integer> currentTree = new ArrayList<>();
        if(Objects.nonNull(root) && (Objects.nonNull(root.left) || Objects.nonNull(root.right))) {
            treeNodeHierarchy.putIfAbsent(index, new ArrayList<>(Arrays.asList(root.data)));
            currentTree.add(root.data);
            populateTrees(root, currentTree);
            for(Map.Entry<Integer, List<Integer>> curList : treeNodeHierarchy.entrySet()) {
                if(curList.getValue().contains(node)) {
                    int index = curList.getValue().indexOf(node);
                    int ancestorIndex = index-ancestorLevel;
                    if(ancestorIndex >= 0) {
                        return curList.getValue().get(ancestorIndex);
                    } else {
                        return ancestorValue;
                    }
                }
            }
        }
        return ancestorValue;
    }

    private void populateTrees(TreeNode node, List<Integer> currentTree) {
        if(Objects.nonNull(node)) {
            List<Integer> modifiedTree;
            boolean hasFirstChild = false;
            if(Objects.nonNull(node.left)) {
                hasFirstChild = true;
                modifiedTree = addToTreeHierarchy(node.left.data, currentTree, false);
                populateTrees(node.left, modifiedTree);
            }
            if(Objects.nonNull(node.right)) {
                modifiedTree = addToTreeHierarchy(node.right.data, currentTree, hasFirstChild);
                populateTrees(node.right, modifiedTree);
            }
        }
    }

    private List<Integer> addToTreeHierarchy(int nodeValue, List<Integer> currentTree, boolean isBranchOut) {
        List<Integer> modifiedTree = new ArrayList<>(currentTree);
        modifiedTree.add(nodeValue);
        if(isBranchOut) {
            index++;
            treeNodeHierarchy.put(index, modifiedTree);
        } else {
            treeNodeHierarchy.replace(index, modifiedTree);
        }
        return modifiedTree;
    }
}
