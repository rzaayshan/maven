package lesson21;

public class Fibonacci {
    static int fibo(int n){
        if(n==0 || n==1)
            return 1;
        return fibo(n-1)+fibo(n-2);

    }
    public static void main(String[] args) {
        int n=6;
        System.out.printf("%dth element:%d",n,fibo(6));

    }
}
