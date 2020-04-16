package app.lesson25;

import java.util.Arrays;
import java.util.HashMap;

public class lesson25 {
    public static void main(String[] args) {
        int a[] = new int [50];
        for(int i=0;i<a.length;i++)
            a[i]=(int)(Math.random()*16+10);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                int count = map.get(a[i]);
                map.put(a[i],++count);
        }
            else{
                map.put(a[i],1);
            }
        }
        int num, numRep;
        num = a[0];
        numRep=map.get(a[0]);
        for(int b: map.keySet()){
            if(numRep>map.get(b)){
                num=b;
                numRep=map.get(b);
            }
        }
        Arrays.stream(a).forEach(l-> System.out.printf("%s ",l));
        System.out.println();
        System.out.printf("%s %s",num, numRep);


    }

}
