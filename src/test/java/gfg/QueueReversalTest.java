package gfg;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueReversalTest {

    @Test
    public void testReverse() {
        String actual = "1 2 3 4 5 1 23 4 54 334";
        String expected = "334 54 4 23 1 5 4 3 2 1";
        assertThat(QueueReversal.convertQueueToString(QueueReversal.reverse(
                QueueReversal.convertStringToQueue(actual))), is(expected));
    }

    @Test
    public void testReverseUsingCollections() {
        String actual = "1 2 3 4 5 1 23 4 54 334";
        String expected = "334 54 4 23 1 5 4 3 2 1";
        assertThat(QueueReversal.convertQueueToString(QueueReversal.reverseUsingCollectors(
                QueueReversal.convertStringToQueue(actual))), is(expected));
    }

    @Test
    public void testConversion() {
        String input1 = "1 2 3 4 5 1 23 4 54 334";
        assertThat(QueueReversal.convertQueueToString(QueueReversal.convertStringToQueue(input1)), is(input1));

        String input2 = "1 1 1 1 5 2 3 4 9 7 64 12 45645 613 4564 1 1 1 54647 7";
        assertThat(QueueReversal.convertQueueToString(QueueReversal.convertStringToQueue(input2)), is(input2));
    }
}
