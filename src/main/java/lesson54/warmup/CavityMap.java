package lesson54.warmup;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/cavity-map/problem
 */
public class CavityMap {
    static Character[][] convert(String[] grid) {
        int dimY = grid.length;
        int dimX = grid[0].length();
        Character[][] data = new Character[dimY][dimX];
        IntStream.range(0, dimY).forEach(y ->
                IntStream.range(0, dimX).forEach(x ->
                        data[y][x] = grid[y].charAt(x)
                ));
        return data;
    }

    static int toInt(Character c){
        return Integer.parseInt(String.valueOf(c));
    }

    static String[] convert1(Character[][] grid) {
        int dimY = grid.length;
        String[] data = new String[dimY];
        for (int i=0;i<dimY;i++) {
            String collect = Arrays.stream(grid[i]).map(Object::toString).collect(Collectors.joining(""));
            data[i]=collect;
        }
        return data;
    }
    static String[] cavityMap(String[] grid) {
        Character[][] data = convert(grid);
        Character[][] data2 = convert(grid);

        for(int i=1;i<data.length-1;i++){
            for(int j=1;j<data[0].length-1;j++){
                char key = data[i][j];
                if(toInt(data[i-1][j])<toInt(key) &&
                        toInt(data[i][j-1])<toInt(key) &&
                        toInt(data[i+1][j])<toInt(key) &&
                        toInt(data[i][j+1])<toInt(key)){
                    data2[i][j]='X';
                }


            }
        }
        return convert1(data2);
    }

}
