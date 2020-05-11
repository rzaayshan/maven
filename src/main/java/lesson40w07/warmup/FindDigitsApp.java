package lesson40w07.warmup;

public class FindDigitsApp {

  static int findDigits(int n) {
    int c=0;
    int k=n;
    while(k>0){
      int dig = k%10;
      k=k/10;
      if(dig!=0 && n%dig==0)
        c++;
    }
    return c;
  }

}
