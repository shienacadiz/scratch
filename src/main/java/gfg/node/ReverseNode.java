package gfg.node;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the
 * linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered
 * as a group and must be reversed (See Example 2 for clarification).
 *
 * Input:
 * LinkedList: 1->2->2->4->5->6->7->8
 * K = 4
 * Output: 4 2 2 1 8 7 6 5
 * Explanation:
 * The first 4 elements 1,2,2,4 are reversed first
 * and then the next 4 elements 5,6,7,8. Hence, the
 * resultant linked list is 4->2->2->1->8->7->6->5.
 *
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/0
 */
public class ReverseNode {

    static Node head;

    public static Node reverse(Node node, int k) {
        head = null;
        List<Integer> currentBlock = new ArrayList<>();
        Node tail = head;
        int ctr = 0;

        while(node != null) {
            if(ctr >= k-1) {
                currentBlock.add(node.data);
                tail = addReverseNode(tail, currentBlock);
                currentBlock = new ArrayList<>();
                node = node.next;
                ctr = 0;
                continue;
            }
            currentBlock.add(node.data);
            node = node.next;
            if(node == null) {
                addReverseNode(tail, currentBlock);
            }
            ctr++;
        }
        return head;
    }

    private static Node addReverseNode(Node tail, List<Integer> currentBlock) {
        int ctr = 0;
        Collections.reverse(currentBlock);
        if(head == null) {
            head = new Node(currentBlock.get(ctr));
            tail = head;
            ctr++;
        }
        for( ; ctr < currentBlock.size(); ctr++) {
            tail.next = new Node(currentBlock.get(ctr));
            tail = tail.next;
        }
        return tail;
    }
}
