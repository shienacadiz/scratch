package swa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TransactionLogsTest {

    @Test
    public void testOne() {
        List<String> testList = new ArrayList<>();
        testList.add("9 7 50");
        testList.add("22 7 20");
        testList.add("33 7 50");
        testList.add("22 7 30");

        List<String> expectedList = new ArrayList<>();
        expectedList.add(Integer.toString(7));
        assertThat(TransactionLogs.processLogs(testList,3), is(expectedList));
    }

    @Test
    public void testTwo() {
        List<String> testList = new ArrayList<>();
        testList.add("2 2 50");
        testList.add("2 2 20");
        testList.add("2 2 50");
        testList.add("2 2 30");

        assertThat(TransactionLogs.processLogs(testList,5), is(new ArrayList<>()));
    }

    @Test
    public void testThree() {
        List<String> testList = new ArrayList<>();
        testList.add("1 2 50");
        testList.add("1 7 70");
        testList.add("1 3 20");
        testList.add("2 2 17");

        List<String> expectedList = new ArrayList<>();
        expectedList.add(Integer.toString(1));
        expectedList.add(Integer.toString(2));
        assertThat(TransactionLogs.processLogs(testList,2), is(expectedList));
    }
}
