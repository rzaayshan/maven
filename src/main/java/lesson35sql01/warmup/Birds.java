package lesson35sql01.warmup;


import java.util.*;


public class Birds {
    static int migratoryBirds(List<Integer> arr) {
        Iterator<Integer> it = arr.iterator();
        HashMap<Integer,Integer> count = new HashMap<>();

        while(it.hasNext()){
            int el=it.next();
            int c=count.getOrDefault(el,0);
            count.put(el,c+1);
        }
        int min_num=Integer.MAX_VALUE;
        int occ = 2;

        for(Map.Entry<Integer,Integer> el : count.entrySet()){
            if(occ<el.getValue()){
                min_num=el.getKey();
                occ=el.getValue();
            }
            else if(occ==el.getValue()){
                min_num=Math.min(min_num,el.getKey());
            }
        }

        return min_num;

    }


}
