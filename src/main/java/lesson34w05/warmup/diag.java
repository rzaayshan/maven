package lesson34w05.warmup;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class diag {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[][] = new int [n][n];
        int[] sum1 = {0};
        int[] sum2 = {0};
        int res;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=s.nextInt();

        int sum = IntStream.range(0, n).map(i -> a[i][i] - a[i][n - i - 1]).sum();

        System.out.println(Math.abs(sum));
    }
}
