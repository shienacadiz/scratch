package ulid;

import static org.junit.Assert.assertEquals;

import java.util.TreeMap;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UlidDemoTest {

    private UlidDemo ulidDemo;
    private int counter;

    @Before
    public void setUp() {
        ulidDemo = new UlidDemo();
        counter = 0;
    }

    //it's not actually sorted damnit
    @Ignore
    @Test
    public void shouldBeInOrderOnGenerateUlid() {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateUlid(300));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }

    //skips count since it creates duplicate due to speed
    @Test
    public void shouldBeInOrderOnGenerateInt() throws InterruptedException {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateInt(300));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }

    //a bit sorted - but still NOT sorted
    @Ignore
    @Test
    public void shouldBeInOrderOnGenerateUlidSulky() {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateUlidSulky(300));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }

    //importing the library does NOT work too
    @Ignore
    @Test
    public void shouldBeInOrderOnGenerateUlidSulkyImport() throws InterruptedException {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateUlidSulkyImport(300));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }

    // SORTED !!!
    @Test
    public void shouldBeInOrderOnGenerateUlidAzamImport() throws InterruptedException {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateUlidAzamImport(300));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }

    // SORTED !!!
    @Test
    public void shouldBeInOrderOnGenerateUlidGithubF4b6a3Import() {
        TreeMap<String, String> actualMap = new TreeMap<>(ulidDemo.generateUlidGithubF4b6a3(1000));

        actualMap.forEach(
            (ulid, order) -> {
                assertEquals(order, Integer.toString(counter));
                counter++;
                System.out.println(order + " " + ulid);
            }
        );
    }
}
