package hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlusMinusTest {

    @Test
    public void testPlusMinus1() {
        List<Integer> test1 = Arrays.asList(-4, 3, -9, 0, 4, 1);
        String expectedResult1 = "0.500000\n0.333333\n0.166667";
        assertThat(PlusMinus.evaluate(test1), is(expectedResult1));
    }

    @Test
    public void testPlusMinus2() {
        List<Integer> test2 = Arrays.asList(1, 2, 3, -1, -2, -3, 0, 0);
        String expectedResult2 = "0.375000\n0.375000\n0.250000";
        assertThat(PlusMinus.evaluate(test2), is(expectedResult2));
    }

}
