package gfg.node;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveDuplicateTest {

    private RemoveDuplicate removeDuplicate;

    @Before
    public void setUp() {
        removeDuplicate = new RemoveDuplicate();
    }

    @Test
    public void testRemoveDuplicates() {
        String input1 = "5 2 2 4";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicates(Node.convertToNode(input1))), is("5 2 4"));

        String input2 = "2 2 2 2";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicates(Node.convertToNode(input2))), is("2"));

        String input3 = "1 2 3 3 2 1 5 1233 54";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicates(Node.convertToNode(input3))), is("1 2 3 5 1233 54"));
    }

    @Test
    public void testRemoveDuplicatesUsingStreams() {
        String input1 = "5 2 2 4";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesUsingStreams(Node.convertToNode(input1))), is("5 2 4"));

        String input2 = "2 2 2 2";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesUsingStreams(Node.convertToNode(input2))), is("2"));

        String input3 = "1 2 3 3 2 1 5 1233 54";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesUsingStreams(Node.convertToNode(input3))), is("1 2 3 5 1233 54"));
    }

    @Test
    public void testRemoveDuplicatesLegacy() {
        String input1 = "5 2 2 4";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesLegacy(Node.convertToNode(input1))), is("5 2 4"));

        String input2 = "2 2 2 2";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesLegacy(Node.convertToNode(input2))), is("2"));

        String input3 = "1 2 3 3 2 1 5 1233 54";
        assertThat(Node.convertToString(removeDuplicate.removeDuplicatesLegacy(Node.convertToNode(input3))), is("1 2 3 5 1233 54"));
    }
}
