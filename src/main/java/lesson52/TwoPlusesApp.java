package lesson52;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/two-pluses/problem
 */
public class TwoPlusesApp {
  static final int OCCUPY = 1;

  static int twoPluses(String[] grid) {
    int l1=grid.length;
    int l2=grid[0].length();
    int res=1;
    int flag=0;

    for(int i=1;i<grid.length;i++){
      for(int j=1;j<grid[i].length();j++){
        int k=1;

        char key=grid[i].charAt(j);
        while (k<=i && k<=j && i+k<l1 && j+k<l2){
          System.out.println("k"+k);
          if(Stream.of(grid[i].charAt(j),
                  grid[i-k].charAt(j),
                  grid[i+k].charAt(j),
                  grid[i].charAt(j-k),
                  grid[i].charAt(j+k)
          ).allMatch(c->c.equals(key))){
            res*=2*k+1;
            System.out.println("res"+res);
            flag++;
            System.out.println("flag"+flag);
          }
          if(flag==2) return res;
          k++;
        }
      }
    }
    return res;
  }

  static void occupyVerAt(int x, int y, int len, int [][]data){
    IntStream.range(0,len/2).forEach(i->{
      data[y+i][x]=OCCUPY;
      data[y-i][x]=OCCUPY;
    });
  }

  public static void main(String[] args) {
    String [] a = {"GGGGGG","GBBBGB","GGGGGG","GGBBGB","GGGGGG"};
    System.out.println(twoPluses(a));
  }

}
