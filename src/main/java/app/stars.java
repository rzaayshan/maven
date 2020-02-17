package app;

import java.io.InputStream;
import java.util.Scanner;

public class stars {
    public static void main(String[] args) {
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        System.out.println("Enter width:");
        int width = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter height:");
        int height = Integer.parseInt(scanner.nextLine());
        double k = ((double) width)/height;
        String a[][] = new String [height][width];

        /////////////////////////////////////////////////////
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++)
                a[i][j]=" ";
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++){
                if(i==0 || j==0 || i==height-1 || j==width-1 )
                    a[i][j]="*";
                if(i==j || i==(width-j-1) )
                    a[i][j]="*";
            }

        //////////////////////////////////////////////////////
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.printf("%s",a[i][j]);}
            System.out.println();}




    }



}
