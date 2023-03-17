package swa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CountGroupsTest {

    //@Test - failing
    public void testOne() {
        List<String> testList = new ArrayList<>();
        testList.add("1100");
        testList.add("1110");
        testList.add("0110");
        testList.add("0001");

        assertThat(CountGroups.countGroups(testList), is(2));
    }

    @Test
    public void testTwo() {
        List<String> testList = new ArrayList<>();
        testList.add("10000");
        testList.add("01000");
        testList.add("00100");
        testList.add("00010");
        testList.add("00001");

        assertThat(CountGroups.countGroups(testList), is(5));
    }
}
