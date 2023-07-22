package gfg.node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List.
 * When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.
 *
 * Input:
 * N = 4
 * value[] = {5,2,2,4}
 * Output: 5 2 4
 * Explanation:Given linked list elements are
 * 5->2->2->4, in which 2 is repeated only.
 * So, we will delete the extra repeated
 * elements 2 from the linked list and the
 * resultant linked list will contain 5->2->4
 *
 * https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 */
public class RemoveDuplicate {

    public Node removeDuplicates(Node node) {
        List<Integer> nodeList = new ArrayList<>();
        while(Objects.nonNull(node)) {
            nodeList.add(node.data);
            node = node.next;
        }

        Set<Integer> uniqueSet = new HashSet<>();
        nodeList.removeIf(current -> !uniqueSet.add(current));

        int ctr = 0;
        Node head = new Node(nodeList.get(ctr));
        Node tail = head;
        for(ctr=1; ctr<nodeList.size(); ctr++) {
            tail.next = new Node(nodeList.get(ctr));
            tail = tail.next;
        }
        return head;
    }

    public Node removeDuplicatesUsingStreams(Node node) {
        List<Integer> nodeList = new ArrayList<>();
        while(Objects.nonNull(node)) {
            nodeList.add(node.data);
            node = node.next;
        }

        List<Integer> uniqueList = nodeList.stream().distinct().collect(Collectors.toList());

        int ctr = 0;
        Node head = new Node(uniqueList.get(ctr));
        Node tail = head;
        for(ctr=1; ctr<uniqueList.size(); ctr++) {
            tail.next = new Node(uniqueList.get(ctr));
            tail = tail.next;
        }
        return head;
    }

    public Node removeDuplicatesLegacy(Node node) {
        Node head = new Node(node.data);
        Node tail = head;
        List<Integer> uniqueList = new ArrayList<>();
        uniqueList.add(node.data);
        Node next = node.next;
        while(Objects.nonNull(next)) {
            if(uniqueList.contains(next.data)) {
                next = next.next;
                continue;
            }
            tail.next = new Node(next.data);
            tail = tail.next;
            uniqueList.add(next.data);
            next = next.next;
        }
        return head;
    }
}
