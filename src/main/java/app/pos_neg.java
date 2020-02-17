package app;

import java.util.Arrays;

public class pos_neg {
    public static void main(String[] args) {
        int []a = new int [20];
        int []pos = new int [20];
        int []neg = new int [20];
        int m=0;
        int n=0;
        ////////////////////////////////////
        for(int i=0;i<20;i++){
            a[i]= (int) (Math.random()*200-100);
        }
        //////////////////////////////////////
        for(int el : a){
            if(el>0){
                pos[m++]=el;
                }
            else {
                neg[n++]=el;
                }
        }
        /////////////////////////////////////

        for(int i=0;i<m;i++)
            System.out.printf("%d ",pos[i]);
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.printf("%d ",neg[i]);



    }
}
