package others;

import de.huxhorn.sulky.ulid.ULID;

public class UlidDemo {
    public static void main(String[] args) {
        ULID ulid = new ULID();
        System.out.println(ulid.nextULID());
        System.out.println(ulid.nextULID());
        System.out.println(ulid.nextULID());
    }
}
