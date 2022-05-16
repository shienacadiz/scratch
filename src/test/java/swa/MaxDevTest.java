package swa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxDevTest {
    @Test
    public void testaseds() {
        assertThat(MaxDev.getMaxFreqDeviation("bbacccabab"), is(2));
    }
}
