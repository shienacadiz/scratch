package gfg.node;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }

    public static Node convertToNode(String line) {
        List<String> nodeList = Arrays.asList(line.split(" "));
        Node head = new Node(Integer.parseInt(nodeList.get(0)));
        Node tail = head;
        for(int ctr=1 ; ctr < nodeList.size() ; ctr++) {
            tail.next = new Node(Integer.parseInt(nodeList.get(ctr)));
            tail = tail.next;
        }
        return head;
    }

    public static String convertToString(Node node) {
        List<Integer> nodeList = new ArrayList<>();
        while(node != null) {
            nodeList.add(node.data);
            node = node.next;
        }
        return StringUtils.join(nodeList, " ");
    }
}
