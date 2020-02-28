package app.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class myApp2 {
    public Set <Integer> func(Set <Integer> list1, Set <Integer> list2){
        Set<Integer> list3 = new HashSet<>();
        if (list1==null && list2==null)
            return list3;
        else if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        for(int el: list1){
            if(!list3.contains(el))
                list3.add(el);
        }
        for(int el: list2){
            if(!(list1.contains(el))){
                list3.add(el);
                }
        }
        return list3;

}}
