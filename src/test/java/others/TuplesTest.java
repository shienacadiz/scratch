package others;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TuplesTest {
    private static int INDEX_CHAR = 0;
    private static int INDEX_COUNT = 1;

    @Test
    public void shouldReturnOnSingleChars() {
        List<List<Object>> actual = Tuples.encode("abc");

        assertThat(actual.size(), is(3));
        assertThat(actual.get(0).get(INDEX_CHAR), is('a'));
        assertThat(actual.get(0).get(INDEX_COUNT), is(1));
        assertThat(actual.get(1).get(INDEX_CHAR), is('b'));
        assertThat(actual.get(1).get(INDEX_COUNT), is(1));
        assertThat(actual.get(2).get(INDEX_CHAR), is('c'));
        assertThat(actual.get(2).get(INDEX_COUNT), is(1));
    }

    @Test
    public void shouldReturnOnStringWithDuplicateChars() {
        List<List<Object>> actual = Tuples.encode("assassin");

        assertThat(actual.size(), is(6));
        assertThat(actual.get(0).get(INDEX_CHAR), is('a'));
        assertThat(actual.get(0).get(INDEX_COUNT), is(1));
        assertThat(actual.get(1).get(INDEX_CHAR), is('s'));
        assertThat(actual.get(1).get(INDEX_COUNT), is(2));
        assertThat(actual.get(2).get(INDEX_CHAR), is('a'));
        assertThat(actual.get(2).get(INDEX_COUNT), is(1));
        assertThat(actual.get(3).get(INDEX_CHAR), is('s'));
        assertThat(actual.get(3).get(INDEX_COUNT), is(2));
        assertThat(actual.get(4).get(INDEX_CHAR), is('i'));
        assertThat(actual.get(4).get(INDEX_COUNT), is(1));
        assertThat(actual.get(5).get(INDEX_CHAR), is('n'));
        assertThat(actual.get(5).get(INDEX_COUNT), is(1));
    }

    @Test
    public void shouldReturnOnEmptyString() {
        List<List<Object>> actual = Tuples.encode("");

        assertThat(actual.size(), is(0));
    }

    @Test
    public void shouldReturnOnStringWithSpace() {
        List<List<Object>> actual = Tuples.encode("  ");

        assertThat(actual.size(), is(1));
        assertThat(actual.get(0).get(INDEX_CHAR), is(' '));
        assertThat(actual.get(0).get(INDEX_COUNT), is(2));
    }

    @Test
    public void shouldReturnOnSingleChar() {
        List<List<Object>> actual = Tuples.encode("x");

        assertThat(actual.size(), is(1));
        assertThat(actual.get(0).get(INDEX_CHAR), is('x'));
        assertThat(actual.get(0).get(INDEX_COUNT), is(1));
    }

    @Test
    public void shouldReturnOnStringWithDuplicateEndString() {
        List<List<Object>> actual = Tuples.encode("xyzzzz");

        assertThat(actual.size(), is(3));
        assertThat(actual.get(0).get(INDEX_CHAR), is('x'));
        assertThat(actual.get(0).get(INDEX_COUNT), is(1));
        assertThat(actual.get(1).get(INDEX_CHAR), is('y'));
        assertThat(actual.get(1).get(INDEX_COUNT), is(1));
        assertThat(actual.get(2).get(INDEX_CHAR), is('z'));
        assertThat(actual.get(2).get(INDEX_COUNT), is(4));
    }
}
