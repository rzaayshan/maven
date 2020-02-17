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
        String s;
        int n=20;
        System.out.println("Please, enter string: ");
        s = new Scanner(System.in).nextLine();
        String vowel = new String();
        String consonant = new String();
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))) vowel=vowel+s.charAt(i);
            else consonant=consonant+s.charAt(i);
        }
        System.out.println(s);
        System.out.println(vowel);
        System.out.println(consonant);
    }
}
