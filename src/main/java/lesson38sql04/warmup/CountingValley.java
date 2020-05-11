package lesson38sql04.warmup;

public class CountingValley {
    static int countingValleys(int n, String s) {
        int h=0;
        int c=0;
        for(int i=0;i<n;i++){
            if (s.charAt(i) == 'U') {
                h=h+1;
            } else {
                h=h-1;
            }
            if(s.charAt(i)=='U' && h==0)
                c=c+1;
        }
        return c;
    }

}
