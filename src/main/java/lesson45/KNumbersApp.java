package lesson45;

import java.util.stream.IntStream;

public class KNumbersApp {

  static boolean isKap(int n){
    int right = n*n;
    int i=0;
    int l;
    l = n%2==0 ? nLength(n)/2 : nLength(n)/2+1;
    int left=0;
    while (i!=l){
      int rem = right%10;
      right=right/10;
      left+=rem*Math.pow(10,i);
      i++;
    }
    return (left+right)==n;

  }

  static int nLength(int n){
    int i=0;
    while(n>0){
      n=n/10;
      i++;
    }
    return i;
  }

  static void kaprekarNumbers(int p, int q) {
//    IntStream.rangeClosed(p,q).filter(e->isKap(e))
//            .forEach(e-> System.out.printf("%d ",e));
    for(int i=p;i<q;i++){
      if(isKap(i))
        System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println(isKap(45));
    System.out.println(nLength(9));
    kaprekarNumbers(1,100);
  }
}
