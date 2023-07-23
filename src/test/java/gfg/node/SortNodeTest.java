package gfg.node;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortNodeTest {

    @Test
    public void testSortNode() {
        String input1 = "1 2 2 1 2 0 2 2";
        assertThat(Node.convertToString(SortNode.sort(Node.convertToNode(input1))), is("0 1 1 2 2 2 2 2"));

        String input2 = "2 2 0 1";
        assertThat(Node.convertToString(SortNode.sort(Node.convertToNode(input2))), is("0 1 2 2"));
    }
}
