package app;

import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        int[] even = new int [30];
        int sum_even = 0;
        int[] odd = new int [30];
        int sum_odd = 0;
        /////////////////////////////////////
        for(int i=0;i<30;){
            int a = (int) (Math.random()*40-20);
            if(a%2==0){
                even[i]= a;
                i++;
            }}
        for(int i=0;i<30;){
            int a = (int) (Math.random()*60-30);
            if(a%2!=0){
                odd[i]= a;
                sum_odd+=odd[i];
                i++;}
        }
        //////////////////////////////////////
        for(int i=0;i<30;i++){
               sum_even+=even[i];
                }

        for(int i=0;i<30;i++){
            sum_even+=even[i];
        }
        /////////////////////////////////////////////
        String evenString = Arrays.toString(even);
        System.out.println(evenString);
        System.out.println(sum_even);

        String oddString = Arrays.toString(odd);
        System.out.println(oddString);
        System.out.println(sum_odd);





    }}





