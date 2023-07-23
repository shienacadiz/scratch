package gfg.node;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s,
 * 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in
 * the mid of 0s and 2s.
 *
 * Input:
 * N = 8
 * value[] = {1,2,2,1,2,0,2,2}
 * Output: 0 1 1 2 2 2 2 2
 * Explanation: All the 0s are segregated
 * to the left end of the linked list,
 * 2s to the right end of the list, and
 * 1s in between.
 *
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 */
public class SortNode {
    public static Node sort(Node head) {
        Queue<Integer> nodeQueue = new PriorityQueue<>();
        Node node = head;
        while(Objects.nonNull(node)) {
            nodeQueue.add(node.data);
            node = node.next;
        }
        Node sortedNodeHead = new Node(nodeQueue.peek());
        nodeQueue.remove();
        Node tail = sortedNodeHead;

        while(!nodeQueue.isEmpty()){
            tail.next = new Node(nodeQueue.peek());
            tail = tail.next;
            nodeQueue.remove();
        }

        return sortedNodeHead;
    }
}
