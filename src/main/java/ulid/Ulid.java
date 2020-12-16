package ulid;

/**
 * https://www.javatips.net/api/Tundra.java-master/src/main/java/permafrost/tundra/id/ULID.java
 */
public class Ulid {

    private static final char[] ENCODE_TABLE = {
        '0','1','2','3','4','5','6','7','8','9',
        'a','b','c','d','e','f','g','h','j','k',
        'm','n','p','q','r','s','t','v','w','x',
        'y','z'
    };
    private static final int TIME_LENGTH = 10;
    private static final int RANDOM_LENGTH = 16;
    private static final double RANDOM_MULTIPLIER = Math.pow(2, 40);

    public static String generate() {
        StringBuilder buffer = new StringBuilder();
        encodeRandom(buffer);
        encodeTime(buffer);
        return buffer.reverse().toString();
    }

    private static void encode(StringBuilder buffer, long value, int length) {
        for (int i = 0; i < length; i++) {
            int remainder = (int)(value % ENCODE_TABLE.length);
            value = (value - remainder) / ENCODE_TABLE.length;
            buffer.append(ENCODE_TABLE[remainder]);
        }
    }

    private static void encodeTime(StringBuilder buffer) {
        encode(buffer, System.currentTimeMillis(), TIME_LENGTH);
    }

    private static void encodeRandom(StringBuilder buffer) {
        encode(buffer, (long)(Math.random() * RANDOM_MULTIPLIER), RANDOM_LENGTH/2);
        encode(buffer, (long)(Math.random() * RANDOM_MULTIPLIER), RANDOM_LENGTH/2);
    }
}
