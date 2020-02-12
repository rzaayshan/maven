package app;

import java.util.Arrays;

public class array1 {
    public static void main(String[] args) {
        int[] even = new int [30];
        int sum_even = 0;
        int[] odd = new int [30];
        int sum_odd = 0;
        /////////////////////////////////////
        for(int i=0;i<30;i++){
            int a = (int) (Math.random()*20-10);
            a = 2*a;
            even[i]= a;
            }
        for(int i=0;i<30;i++){
            int a = (int) (Math.random()*30-15);
            a = 2*a+1;
            odd[i]= a;
        }
        //////////////////////////////////////
        for(int i=0;i<30;i++){
            sum_even+=even[i];
        }

        for(int i=0;i<30;i++){
            sum_odd+=odd[i];
        }
        /////////////////////////////////////////////
        String evenString = Arrays.toString(even);
        System.out.println(evenString);
        System.out.println(sum_even);

        String oddString = Arrays.toString(odd);
        System.out.println(oddString);
        System.out.println(sum_odd);
        int sum = sum_even+sum_odd;

        System.out.println(sum);
    }
}
