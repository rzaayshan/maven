package app.test;

public class myApp {

    boolean isVowel(char c){
        String vowel = "euioa";
        return vowel.contains(String.valueOf(c));

    }
    String filter(String s){
        StringBuilder con = new StringBuilder();
        String lower = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(!isVowel(lower.charAt(i)))
                con.append(lower.charAt(i));
        }
        return con.toString();



    }}


