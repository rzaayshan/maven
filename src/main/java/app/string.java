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
        int n=20;
        String vowel = new String();
        String consonant = new String();
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
            if(isVowel(k.charAt(i))) vowel=vowel+s.charAt(i);
            else consonant=consonant+s.charAt(i);
        }
        System.out.println(s);
        System.out.println(vowel);
        System.out.println(consonant);
    }
}
