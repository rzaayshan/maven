package app.test;

import java.util.ArrayList;

public class myApp2 {
    public ArrayList <Integer> func(ArrayList <Integer> list1, ArrayList <Integer> list2){
        ArrayList <Integer> list3 = new ArrayList<>();
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;

        for(int el: list1){
            if(!list3.contains(el))
                list3.add(el);
        }
        for(int el: list2){
            if(!(list1.contains(el) || list3.contains(el))){
                list3.add(el);
                }
        }
        return list3;

}}
