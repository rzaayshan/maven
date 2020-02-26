package app.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class myAppTest {
    myApp a ;

    @BeforeEach
    public void init() {this.a = new myApp();};

    @Test
    public void test1(){
        String exp = "yshn";
        String act = a.filter("Ayshan");
        assertEquals(exp,act);
    }
    @Test
    public void test2(){
        String exp = "";
        String act = a.filter("");
        assertEquals(exp,act);
    }
    @Test
    public void test3(){
        String exp = "bbbb";
        String act = a.filter("aaaBBBBaaa");
        assertEquals(exp,act);
    }



}