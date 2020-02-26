package app.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class myApp2Test {
    myApp2 b;
    ArrayList <Integer> list1;
    ArrayList <Integer> list2;
    ArrayList <Integer> exp;
    ArrayList <Integer> act;

    @BeforeEach
    public void init(){ b = new myApp2();}

    @Test
    public void test1(){
        list1 = new ArrayList<Integer>(Arrays.asList(1,5,8));
        list2 = new ArrayList<Integer>(Arrays.asList(1,6,8));
        exp = new ArrayList<Integer>(Arrays.asList(1,5,8,6));
        act = b.func(list1,list2);
        assertEquals(exp,act);
    }
    @Test
    public void test2(){
        list1 = new ArrayList<Integer>(Arrays.asList(1,1,1));
        list2 = new ArrayList<Integer>(Arrays.asList(2,2,2));
        exp = new ArrayList<Integer>(Arrays.asList(1,2));
        act = b.func(list1,list2);
        assertEquals(exp,act);
    }
    @Test
    public void test3(){
        list1 = new ArrayList<Integer>();
        list2 = new ArrayList<Integer>(Arrays.asList(1,5));
        exp = new ArrayList<Integer>(Arrays.asList(1,5));
        act = b.func(list1,list2);
        assertEquals(exp,act);
    }
    @Test
    public void test4(){
        //list1 = new ArrayList<Integer>();
        list2 = new ArrayList<Integer>();
        exp = new ArrayList<Integer>() ;
        act = b.func(list1,list2);
        assertEquals(exp,act);
    }


}