package swa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxDevTest {
    @Test
    public void testGetMaxFreqDeviation() {
        assertThat(MaxDev.getMaxFreqDeviation("z"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation(""), is(0));
        assertThat(MaxDev.getMaxFreqDeviation("bbacccabab"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("aaaaaaa"), is(7));
        assertThat(MaxDev.getMaxFreqDeviation("zzzzaaaa"), is(4));
        assertThat(MaxDev.getMaxFreqDeviation("zzzzaaaaz"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("zzaazzaaz"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("aabbbbbbcdaaz"), is(5));
        assertThat(MaxDev.getMaxFreqDeviation("abdbacadabbadddd"), is(5));
        assertThat(MaxDev.getMaxFreqDeviation("ddddddddddddddaaacccccccccccccaaddddaabbbbbbbbbbbbbbbbbaaaaaaaaaaa" +
                "aaaaaaaaacccccccccccaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaacccccccccaaaaaaaaaaccccccc" +
                "ccaaaaaaaccccaaaddddddddddddddddddddddddddddddddddddddddaaaacccaaddddddaaaaaaaaaaaaaaaaaddaaaaaaaaa" +
                "abbbbbbbbbaaaaaaaaaaaaaaaaaaaaaadddaaabcccc"), is(79));
    }

    @Test
    public void testViaIndex() {
        assertThat(MaxDev.viaLastIndex("z"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation(""), is(0));
        assertThat(MaxDev.getMaxFreqDeviation("bbacccabab"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("aaaaaaa"), is(7));
        assertThat(MaxDev.getMaxFreqDeviation("zzzzaaaa"), is(4));
        assertThat(MaxDev.getMaxFreqDeviation("zzzzaaaaz"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("zzaazzaaz"), is(1));
        assertThat(MaxDev.getMaxFreqDeviation("aabbbbbbcdaaz"), is(5));
        assertThat(MaxDev.getMaxFreqDeviation("abdbacadabbadddd"), is(5));
        assertThat(MaxDev.getMaxFreqDeviation("ddddddddddddddaaacccccccccccccaaddddaabbbbbbbbbbbbbbbbbaaaaaaaaaaa" +
                "aaaaaaaaacccccccccccaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaacccccccccaaaaaaaaaaccccccc" +
                "ccaaaaaaaccccaaaddddddddddddddddddddddddddddddddddddddddaaaacccaaddddddaaaaaaaaaaaaaaaaaddaaaaaaaaa" +
                "abbbbbbbbbaaaaaaaaaaaaaaaaaaaaaadddaaabcccc"), is(79));
    }
}
