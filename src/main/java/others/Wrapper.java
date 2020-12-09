package others;

public class Wrapper {
    public static final IncrementingClass objectOne = new IncrementingClass();
    public final IncrementingClass objectTwo = new IncrementingClass();

    public void run() {
        objectOne.increment();
        objectTwo.increment();

        System.out.println("Object1.counter = " + objectOne.counter);
        System.out.println("Object2.counter = " + objectTwo.counter);
        System.out.println();
    }
}
