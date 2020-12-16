package ulid;

import com.github.f4b6a3.ulid.UlidCreator;
import de.huxhorn.sulky.ulid.ULID;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class UlidDemo {

    public TreeMap<String, String> generateUlidGithubF4b6a3(int count) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            sortedMap.put(UlidCreator.getUlidString(), Integer.toString(x));
        }
        return sortedMap;
    }

    public TreeMap<String, String> generateUlidSulkyImport(int count) throws InterruptedException {
        ULID ulid = new ULID();
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            sortedMap.put(ulid.nextULID(), Integer.toString(x));
        }
        return sortedMap;
    }

    public TreeMap<String, String> generateUlidAzamImport(int count) throws InterruptedException {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            Thread.sleep(1);
            sortedMap.put(io.azam.ulidj.ULID.random(), Integer.toString(x));
        }
        return sortedMap;
    }

    public TreeMap<String, String> generateUlidSulky(int count) {
        UlidSulky ulidSulky = new UlidSulky();
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            sortedMap.put(ulidSulky.nextULID(), Integer.toString(x));
        }
        return sortedMap;
    }

    public TreeMap<String, String> generateUlid(int count) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            sortedMap.put(Ulid.generate(), Integer.toString(x));
        }
        return sortedMap;
    }

    public TreeMap<String, String> generateInt(int count) throws InterruptedException {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        for (int x=0 ; x<count ; x++) {
            Thread.sleep(1);
            sortedMap.put(Long.toString(Timestamp.valueOf(LocalDateTime.now()).getTime()) + x,
                Integer.toString(x));
        }
        return sortedMap;
    }
}
