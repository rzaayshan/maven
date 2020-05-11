package lesson40w07.warmup;

import java.math.BigInteger;

public class XtraLonmgFactApp {

  /*static BigInteger fact(BigInteger n){
    if(n==BigInteger.valueOf(1)) return BigInteger.valueOf(1);
    return n.multiply(fact(n.add(BigInteger.valueOf(1))));
  }*/
  static BigInteger fact(int n){
    BigInteger result =BigInteger.valueOf(1);
    while(n>1){
      result.multiply(BigInteger.valueOf(n));
      n=n-1;
    }
    return result;
  }

  static void extraLongFactorials(int n) {
    System.out.println(fact(n));
  }
}
