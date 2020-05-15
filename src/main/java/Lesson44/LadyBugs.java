package Lesson44;

import freemarker.core.JSONOutputFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadyBugs {
    static String happyLadybugs(String b) {
        int len = b.length();
        HashMap<Character, Integer> count = new HashMap<>();
        int k=0;
        if(len==1)
            return "NO";
        if(b.contains("_")){
                for(int i=0;i<len;i++){
                    if(b.charAt(i)=='_'){
                        k++;
                        continue;
                    }
                    count.put(b.charAt(i),count.getOrDefault(b.charAt(i),0)+1);
                }
                if(k==len)
                    return "YES";
                for(Map.Entry<Character, Integer> entry : count.entrySet()){
                    if(entry.getValue()==1)
                        return "NO";
                }
                return "YES";
        }
        if(len%2==1){
            if(b.charAt(len-1)!=b.charAt(len-2))
                return "NO";
        }
        for(int i=0;i<len-1;i++){
            System.out.println(b.charAt(i));
            System.out.println(i);
            if(!String.valueOf(b.charAt(i)).equals(String.valueOf(b.charAt(++i))))
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(happyLadybugs("Q_ZEUKWDG_Q_VEE_Z_PDDDEEP_PVDVVGZUEU_Q_"));
        System.out.println();
    }
}
