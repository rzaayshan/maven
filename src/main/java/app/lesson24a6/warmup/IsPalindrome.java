package app.lesson24a6.warmup;

public class IsPalindrome {

  public boolean check(int n) {
    String a = Integer.toString(n);
    for(int i=0;i<a.length()-1;i++){
      if(a.charAt(a.length()-i-1)!=a.charAt(i))
        return false;
    }
    return true;
  }
}
