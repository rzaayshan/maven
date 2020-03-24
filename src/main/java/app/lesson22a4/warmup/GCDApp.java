package app.lesson22a4.warmup;

public class GCDApp {
  int gcd(int a, int b) {
    if(a==b) return a;
    else if(a>b) return gcd(a-b,b);
    return gcd(a,b-a);
  }
}
