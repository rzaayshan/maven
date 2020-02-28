package app.lesson11;

import java.util.*;
import java.util.stream.IntStream;

public class warmUp {
    static Map<Character, Integer>count (String s){
        HashMap <Character, Integer> map = new HashMap<>();
        s.chars().mapToObj(c->(char) c).forEach(c ->{
            int count = map.getOrDefault(c,0);
            map.put(c,++count);
        });
        return map;
    }

    static Map<Character, List<Integer>>position (String s){
        HashMap <Character, List<Integer>> map = new HashMap<>();
        IntStream.range(0, s.length()).forEach(i -> {
            char c = s.charAt(i);
            List<Integer> positions = map.getOrDefault(c, new ArrayList<>());
            positions.add(i);
            map.put(c, positions);
             });
        return map;
    }
    static HashMap <Character,HashMap<Integer,List<Integer>>>CountPos (String s){
        HashMap <Character, HashMap<Integer,List<Integer>>> map = new HashMap<>();
        IntStream.range(0, s.length()).forEach(i -> {
            char c = s.charAt(i);
            int count = count(s).get(c);
            List <Integer> position = position(s).get(c);
            HashMap<Integer,List<Integer>> map2 = new HashMap<>();
            map2.put(count,position);
            map.put(c,map2);
        });
        return map;
    }
    public static void main(String[] args) {
        String s="Hello World";
        count(s).forEach((k,v)->{
            System.out.printf("'%c':%d, ", k, v);

        });
        System.out.println();
        position(s).forEach((k,v)->{
            System.out.printf("'%c':%s, ", k, v);

        });
        System.out.println();
        CountPos(s).forEach((k,v)->{
            System.out.printf("'%c': ",k);
            v.forEach((k1,v1)->{
                System.out.printf("%d: %s \n", k1, v1);
            });
        });


    }

}
