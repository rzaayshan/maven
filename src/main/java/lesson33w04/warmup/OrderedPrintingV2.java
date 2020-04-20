package lesson33w04.warmup;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderedPrintingV2 {

  private static String dataOrdered(int R, int C, int[][] a) {
    return IntStream.range(0, R*C).map(idx -> {
      int col = C-idx / R-1;
      System.out.println(col);
      int delta = idx - (C-col-1) * R;
      System.out.println(delta);
      int row = (col&1)==0 ? delta : R-1-delta;
      System.out.println(row);
      return a[row][col];
    })
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    int[][]a =
        {
            {1,  2, 3, 4, },
            {5,  6, 7, 8, },
            {9, 10,11, 12,},
            {13,14,15, 16,},
            {17,18,19, 20,},
        };

    // reference output
    System.out.println("4 8 12 16 20 19 15 11 7 3 2 6 10 14 18 17 13 9 5 1");
    // your output
    System.out.println(dataOrdered(a.length, a[0].length, a));
  }

}
