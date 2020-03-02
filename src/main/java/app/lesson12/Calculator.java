package app.lesson12;

import java.util.Scanner;

public class Calculator {
    static int operation(int a, int b, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
    }
    public static void main(String[] args) {
        String s="0123456789";
        while (true){
            StringBuilder firstS = new StringBuilder();
            StringBuilder secondS = new StringBuilder();
            int k=0,i;
            boolean flag=false;
            String input = new Scanner(System.in).next();
            if(input.equals("quit"))
                break;
            if(String.valueOf(input.charAt(0)).equals("-")){
                k++;
                flag=true;}
            for(i=k;i<input.length();i++){
                if(!s.contains(String.valueOf(input.charAt(i))))
                    break;
                firstS.append(input.charAt(i));
            }
            char op=input.charAt(i);
            for(i=i+1;i<input.length();i++){
                secondS.append(input.charAt(i));
            }
            int first=Integer.parseInt(firstS.toString());
            if(flag)
                first=-1*first;
            int second=Integer.parseInt(secondS.toString());
            System.out.println(operation(first,second,op));
    }}
}
