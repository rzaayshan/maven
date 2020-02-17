package app;

import java.util.Scanner;


public class string {
    static boolean isVowel(char a){
        String v = "aeuio";
        for(int i=0;i<v.length();i++)
            if(a==v.charAt(i))
                return true;
        return false;
    }
    public static void main(String[] args) {
        String s = new String();
        String v = "aeuio";
        int n=20;
        StringBuilder vowel = new StringBuilder();
        StringBuilder consonant = new StringBuilder();
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        String k;
        char letter;
        for(int i=0;i<n;i++){
            int ran = (int)(Math.random()*10-5);
            if(ran>0)
                letter = (char)(int)(Math.random()*26+65);
            else
                letter = (char)(int)(Math.random()*26+97);
            s = s+letter;}

        k = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            int b = (int) s.charAt(i);
            //uppercase
            if(b>64 && b<91)  upper.append(s.charAt(i));
            //lowercase
            else lower.append(s.charAt(i));
            //vowel
            if(v.contains(String.valueOf(k.charAt(i)))) vowel.append(s.charAt(i));
            //consonant
            else consonant.append(s.charAt(i));
        }

        System.out.println(s);
        System.out.println(vowel);
        System.out.println(consonant);
        System.out.println(upper);
        System.out.println(lower);
    }
}
