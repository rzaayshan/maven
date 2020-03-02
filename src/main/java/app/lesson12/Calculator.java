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
            int i,k=0;
            boolean flag1=false,flag2=false;
            String input = new Scanner(System.in).next();
            if(input.equals("quit"))
                break;
            for(i=0;i<input.length();i++){
                if(String.valueOf(input.charAt(i)).equals("(") ||
                        String.valueOf(input.charAt(i)).equals(")")
                )
                    continue;
                boolean contains = s.contains(String.valueOf(input.charAt(i)));
                if(contains)
                    firstS.append(input.charAt(i));
                if(String.valueOf(input.charAt(i)).equals("-") && firstS.equals(null)){
                    flag1=true;
                    k++;
                    continue;
                }
                if(!contains && !firstS.equals(null))
                    break;
            }
            char op=input.charAt(i++);
            for(int j=i;j<input.length();j++){
                if(String.valueOf(input.charAt(j)).equals("(") ||
                        String.valueOf(input.charAt(j)).equals(")")
                )
                    continue;
                if(String.valueOf(input.charAt(j)).equals("-")){
                    flag2=true;}
                secondS.append(input.charAt(j));
            }
            int first=Integer.parseInt(firstS.toString());
            int second=Integer.parseInt(secondS.toString());
            if(flag1)
                first=-1*first;
            if(flag2)
                second=-1*second;
            System.out.println(operation(first,second,op));

    }}
}
