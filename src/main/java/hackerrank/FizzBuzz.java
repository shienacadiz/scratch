package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void evaluateAndPrint(int n) {
        IntStream.range(1, n+1).forEach(
                fb -> printFizzBuzz(fb)
        );
    }

    private static void printFizzBuzz(int n) {
        if ((n%3==0) && (n%5==0)) {
            System.out.println("FizzBuzz");
        } else if (n%3==0) {
            System.out.println("Fizz");
        } else if (n%5==0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
    }

    public static String fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        IntStream.range(1, n+1).forEach( fb -> {
            if ((fb % 3 == 0) && (fb % 5 == 0)) {
                results.add("FizzBuzz");
            } else if (fb % 3 == 0) {
                results.add("Fizz");
            } else if (fb % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(Integer.toString(fb));
            }
        });
        return String.join("\n", results);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        evaluateAndPrint(n);
        bufferedReader.close();
    }
}
