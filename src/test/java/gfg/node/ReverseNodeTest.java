package gfg.node;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseNodeTest {

    @Test
    public void testReverse1() {
        String input1 = "1 2 2 4 5 6 7 8";
        assertThat(Node.convertToString(ReverseNode.reverse(Node.convertToNode(input1), 4)), is("4 2 2 1 8 7 6 5"));
    }

    @Test
    public void testReverse2() {
        String input2 = "1 2 3 4 5";
        assertThat(Node.convertToString(ReverseNode.reverse(Node.convertToNode(input2), 3)), is("3 2 1 5 4"));
    }
}
