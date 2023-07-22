package gfg.node;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
