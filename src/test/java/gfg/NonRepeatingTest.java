package gfg;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NonRepeatingTest {

    @Test
    public void testNonRepeating() {
        assertThat(NonRepeating.getNonRepeating("zxvczbtxyzvy"), is('c'));
        assertThat(NonRepeating.getNonRepeating("hello"), is('h'));
    }

    @Test
    public void testNonRepeatingOthers() {
        assertThat(NonRepeating.getNonRepeatingOthers("zxvczbtxyzvy"), is('c'));
        assertThat(NonRepeating.getNonRepeatingOthers("hello"), is('h'));
    }

    @Test
    public void testUniqueString() {
        assertThat(NonRepeating.getNonRepeating("sssss"), is('$'));
        assertThat(NonRepeating.getNonRepeatingOthers("fdfdsdsdsd"), is('$'));
    }
}
