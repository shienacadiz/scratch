package hackerrank;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 * RULE: Change at MAX 3 lines
 */
public class ZigZagSequence {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
    }

    public static String findZigZagSequence(int [] a, int n){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(a);
        int mid = n/2;  //1. before: int mid = (n + 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2; //2. before: int ed = n - 1;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;    //3. before: ed = ed + 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) {
                System.out.print(" ");
                sb.append(" ");
            }
            System.out.print(a[i]);
            sb.append(a[i]);
        }
        System.out.println();

        return sb.toString();
    }
}
