package hackerrank;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ZigZagSequenceTest {

    @Test
    public void testZigZag() {
        int[] arrayInt = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {1, 2, 3, 7, 6, 5, 4};
        assertThat(ZigZagSequence.findZigZagSequence(arrayInt, arrayInt.length),
                is((StringUtils.join(ArrayUtils.toObject(expected), " "))));
    }
}
