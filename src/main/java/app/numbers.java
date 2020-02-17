package app;

import java.util.Scanner;

public class numbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int w = s.nextInt();
        int [][] a = new int [h][w];
        for (int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                a[i][j]=0;
        int k=0;
        while (true){
            for (int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if((i==k || j==k || i==h-k-1 || j==w-k-1) && (a[i][j]==0))
                        a[i][j]=k+1;
                }}
            k++;

            if(k==(h<w ? h :w))
                break;}

        for (int i=0;i<h;i++) {
            for (int j = 0; j < w; j++)
                System.out.print(a[i][j]);
            System.out.println();
        }


    }

}
