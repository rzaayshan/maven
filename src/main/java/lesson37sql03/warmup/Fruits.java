package lesson37sql03.warmup;

import java.util.Arrays;

public class Fruits {
    static int count(int s, int t, int coorTree, int[] fruits){
        return (int) Arrays.stream(fruits).map(coor -> coor + coorTree)
                .filter(coor -> coor >= s && coor <= t).count();
    }
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(count(s,t,a,apples));
        System.out.println(count(s,t,b,oranges));
    }


}
