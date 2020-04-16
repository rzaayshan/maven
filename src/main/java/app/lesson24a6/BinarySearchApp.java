package app.lesson24a6;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchApp {
  static int[] unsorted = new Random().ints(0, 10000).limit(1000).toArray();
  static int[] sorted = unsorted.clone();

  static String find_conventional(int[] origin, int number) {
    int counter = 0;
    for (int i=0;i<origin.length;i++) {
      counter++;
      if (origin[i] == number) return String.format("%s %d %d",true,i,counter);
    }
    return String.format("%s %d %d",false,counter);
  }

  static String find_binary(int[] origin, int number) {
    int counter = 0;
    int l = 0;
    int r = origin.length - 1;
    while (l <= r) {
      counter++;
      int m = (l+r)/2;
      if (number == origin[m]) return String.format("%s %d %d",true,m,counter);
      if (number < origin[m]) r = m - 1;
        // (number > origin[m])
      else l = m + 1;
    }
    return String.format("%s %d %d",false,counter);
  }

  static int run(int[] origin, int number, int l, int r, int counter){
      int mid =(l+r)/2;
      if(origin[mid]<number) return run(origin, number,mid+1,r,counter+1);
      else if(origin[mid]>number) return run(origin, number, l, mid-1,counter+1);
      return counter;
  }
  static int find(int[] origin, int number){
    return run(origin, number, 0, origin.length-1,0);
  }



  public static void main(String[] args) {
    Arrays.sort(sorted);
    System.out.println(Arrays.toString(unsorted));
    System.out.println(Arrays.toString(sorted));
    int rnd = sorted[(int) (Math.random()*1000)];
    String count1 = find_conventional(unsorted, rnd);
    String count2 = find_binary(sorted, rnd);
    System.out.println(count1);
    System.out.println(count2);
  }
}
