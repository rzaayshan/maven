package app;

import java.util.Arrays;
import java.util.Scanner;

public class shift {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int []a = new int [n];
        int []num = new int [n];
        for(int i=0;i<n;i++){
            a[i] = (int)(Math.random()*21-10);
        }
        System.out.println(Arrays.toString(a));
        int []shiftA = new int [n];

        /*int temp=a[n-1];
        for(int i=0;i<n-1;i++){
            if(a[i]>0)
            shiftA[i+1]=a[i];
        }
        shiftA[0]=temp;*/
        int k=0;
        for(int i=0;i<n;i++)
            if(a[i]>0){
                num[k]=i;
                k++;
            }
        int l=0;
        System.out.println(Arrays.toString(num));
        System.out.println(a[num[0]]);

        for(int i=num[1];i<n;i++){
                if(a[i]>0){
                    System.out.println("num "+num[l]);
                    System.out.println("a num"+a[num[l]]);
                    a[i]=a[num[l]];
                    l++;
                    //System.out.println("num "+num[l]);
                    System.out.println("a i"+a[i]);
                    System.out.println("l "+l);
                }

            }
        if(l!=k){
            a[num[0]]=a[num[l-1]];


        }
        System.out.println(a[num[0]]);


        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(shiftA));


    }
}
