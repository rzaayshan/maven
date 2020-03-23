package lesson21;

public class FactorialApp {

  private static int fact(int n) {
    if(n==0) return 1;
    return n*fact(n-1);
  }

  public static void main(String[] args) {
    int N = 5;
    int f5 = fact(N);
    System.out.printf("Factorial: %d\n", f5);
  }

}
