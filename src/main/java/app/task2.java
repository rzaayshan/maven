package app;

import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a1[] = new int [n];
        int a2[] = new int [n];
        int a3[] = new int [n];
        int a4[] = new int [3*n];

        for(int i=0;i<n;i++){
            int temp = (int) (Math.random()*200-100);
            a1[i] = 2*temp;
            a2[i] = 7*temp;
            a3[i] = 11*temp;
            }

        int i=0, k=0, l=0, m=0;
        while(i<3*n){
            if(k<n){
                a4[i]=a1[k];
                k++;
                i++;}
            else if(l<n){
                a4[i]=a2[l];
                l++;
                i++;
            }
            else {
                a4[i]=a3[m];
                m++;
                i++;
            }
            }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));

        for(int j=0;j<n;j++){
            if(j!=n-1 || j!=n-2){
                while(i<n){
                    k=a4[i+1];
                    a4[i+1]=a4[i];
                    a4[i+2]=k;
                    i+=3;
                    }
                a4[0]=a4[n-1];
                a4[n-1]=a4[n-2];
                a4[n-2]=k;

            }

        }
        System.out.println(Arrays.toString(a4));







        }




    }

