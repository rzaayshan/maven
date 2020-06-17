package lesson53;

import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/two-pluses/problem
 */
public class TwoPlusesApp {

  static final int FREE = 0;
  static final int OCCUPIED = 1;
  static final int BUSY = 9;

  static int[][] convert(String[] grid) {
    int dimY = grid.length;
    int dimX = grid[0].length();
    int[][] data = new int[dimY][dimX];
    IntStream.range(0, dimY).forEach(y ->
            IntStream.range(0, dimX).forEach(x ->
                    data[y][x] = grid[y].charAt(x) == 'G' ? FREE : BUSY
            ));
    return data;
  }

  static boolean isFreeHorAt(int x, int y, int len, int[][] data) {
    return IntStream.range(0, len).allMatch(i -> data[y][x + i] == FREE);
  }

  static boolean isFreeVerAt(int x, int y, int len, int[][] data) {
    return IntStream.range(0, len).allMatch(i -> data[y + i][x] == FREE);
  }

  static boolean isPossibleAt(int x, int y, int size, int[][] data) {
    return isFreeHorAt(x, y + size / 2, size, data)
            && isFreeVerAt(x + size / 2, y, size, data);
  }

  static void putValHorAt(int x, int y, int len, int val, int[][] data) {
    IntStream.range(0, len).forEach(i -> data[y][x + i] = val);
  }

  static void putValVerAt(int x, int y, int len, int val, int[][] data) {
    IntStream.range(0, len).forEach(i -> data[y + i][x] = val);
  }

  static void occupyAt(int x, int y, int size, int[][] data) {
    putValHorAt(x, y + size / 2, size, OCCUPIED, data);
    putValVerAt(x + size / 2, y, size, OCCUPIED, data);
  }

  static void releaseAt(int x, int y, int size, int[][] data) {
    putValHorAt(x, y + size / 2, size, FREE, data);
    putValVerAt(x + size / 2, y, size, FREE, data);
  }


}
