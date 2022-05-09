package hackerrank;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    private static final DecimalFormat df = new DecimalFormat("0.000000");

    public static void evaluateAndPrint(List<Integer> arr) {
        PlusMinusZero result = new PlusMinusZero();
        IntStream.range(1, arr.size()+1).forEach(currentNum -> {
            if(currentNum>0) {
                result.setPositive(result.getPositive()+1);
            } else if(currentNum<0) {
                result.setNegative(result.getNegative()+1);
            } else {
                result.setZero(result.getZero()+1);
            }
        });
        final int sum = result.getPositive() + result.getNegative() + result.getZero();
        System.out.println(formatNumber(getPercentage(sum, result.getPositive())));
        System.out.println(formatNumber(getPercentage(sum, result.getNegative())));
        System.out.println(formatNumber(getPercentage(sum, result.getZero())));
    }

    public static String evaluate(List<Integer> arr) {
        PlusMinusZero result = new PlusMinusZero();
        arr.stream().forEach(currentNum -> {
            if(currentNum>0) {
                result.setPositive(result.getPositive()+1);
            } else if(currentNum<0) {
                result.setNegative(result.getNegative()+1);
            } else {
                result.setZero(result.getZero()+1);
            }
        });

        final int sum = result.getPositive() + result.getNegative() + result.getZero();
        return new StringBuilder()
                .append(formatNumber(getPercentage(sum, result.getPositive()))).append("\n")
                .append(formatNumber(getPercentage(sum, result.getNegative()))).append("\n")
                .append(formatNumber(getPercentage(sum, result.getZero())))
                .toString();
    }

    public static String formatNumber(String num) {
        return new StringBuilder()
                .append(StringUtils.rightPad(num, 8, '0'))
                .toString();
    }

    public static String getPercentage(int sum, int num){
        return df.format((double) num/sum);
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        evaluateAndPrint(arr);
        bufferedReader.close();
    }

    static class PlusMinusZero {
        private int positive = 0;
        private int negative = 0;
        private int zero = 0;

        public int getPositive() {
            return positive;
        }

        public void setPositive(int positive) {
            this.positive = positive;
        }

        public int getNegative() {
            return negative;
        }

        public void setNegative(int negative) {
            this.negative = negative;
        }

        public int getZero() {
            return zero;
        }

        public void setZero(int zero) {
            this.zero = zero;
        }
    }
}
