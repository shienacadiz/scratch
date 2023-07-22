package gfg.node;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NodeTest {

    @Test
    public void testConversion() {
        String actual1 = "5 10 15 10 5 2 341 45";
        assertThat(Node.convertToString(Node.convertToNode(actual1)), is(actual1));

        String actual2 = "1 123 1 3 1 23 423 32 4324 21 34";
        assertThat(Node.convertToString(Node.convertToNode(actual2)), is(actual2));
    }
}
