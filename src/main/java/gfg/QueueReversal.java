package gfg;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * Given a Queue Q containing N elements. The task is to reverse the Queue.
 * Your task is to complete the function rev(), that reverses the N elements of the queue.
 *
 * Input:
 * 6
 * 4 3 1 10 2 6
 * Output:
 * 6 2 10 1 3 4
 * Explanation:
 * After reversing the given elements of the queue , the resultant queue will be 6 2 10 1 3 4.
 *
 * https://practice.geeksforgeeks.org/problems/queue-reversal/1
 */
public class QueueReversal {

    private static final String SPACE = " ";
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Queue<Integer> reverseQueue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }

        while(!stack.empty()) {
            reverseQueue.add(stack.peek());
            stack.pop();
        }
        return reverseQueue;
    }


    public static Queue<Integer> reverseUsingCollectors(Queue<Integer> queue) {
        Queue<Integer> reverseQueue = new LinkedList<>();
        Stack<Integer> stack = queue.stream().collect(Collectors.toCollection(Stack::new));
        while(!stack.empty()) {
            reverseQueue.add(stack.peek());
            stack.pop();
        }
        return reverseQueue;
    }

    public static Queue<Integer>
    convertStringToQueue(String input) {
        List<String> inputList = Arrays.asList(input.split(SPACE));
        return inputList.stream().map(Integer::parseInt).collect(Collectors.toCollection(LinkedBlockingQueue::new));
    }

    public static String convertQueueToString(Queue input) {
        List inputList = new ArrayList();
        while(!input.isEmpty()) {
            inputList.add(input.peek());
            input.remove();
        }
        return StringUtils.join(inputList, SPACE);
    }
}
