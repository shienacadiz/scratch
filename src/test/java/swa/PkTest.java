package swa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PkTest {
    @Test
    public void testPk() {
        List<Integer> testList = new ArrayList<>();
        testList.add(20);
        testList.add(13);
        testList.add(8);
        testList.add(9);

        List<Integer> expected = new ArrayList<>();
        expected.add(20);
        expected.add(13);
        expected.add(17);

        assertThat(Pk.mergePackage(testList), is(expected));
        assertThat(Pk.getHeaviestPackage(testList), is(50L));
    }

    @Test
    public void testThree() {
        List<Integer> testList = new ArrayList<>();
        testList.add(20);
        testList.add(13);

        List<Integer> expected = new ArrayList<>();
        expected.add(20);
        expected.add(13);

        assertThat(Pk.mergePackage(testList), is(expected));
    }

    @Test
    public void testFour() {
        List<Integer> testList = new ArrayList<>();
        testList.add(20);

        List<Integer> expected = new ArrayList<>();
        expected.add(20);

        assertThat(Pk.mergePackage(testList), is(expected));
    }


    @Test
    public void testTwo() {
        List<Integer> testList = new ArrayList<>();
        testList.add(4);
        testList.add(20);
        testList.add(13);
        testList.add(8);
        testList.add(9);

        List<Integer> expected = new ArrayList<>();
        expected.add(50);

        assertThat(Pk.mergePackage(testList), is(expected));
    }
}
