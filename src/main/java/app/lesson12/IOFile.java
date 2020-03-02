package app.lesson12;



import java.io.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IOFile {

    static List<Integer> generate(int n, int min, int max){
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<100;i++){
            int rand=(int)(Math.random()*61-30);
            list.add(rand);
        }
        return list;
    }

    static void write(List<Integer> l, String name) throws IOException {
        File ofile = new File(name);
        BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
        for(Integer el: l){
            bw.write(el.toString());
            bw.write("\n");
        }
        bw.close();
    }

    static List<Integer>read(String name) throws IOException {
        File ifile = new File(name);
        BufferedReader br = new BufferedReader(new FileReader(ifile));
        List<String> l = new LinkedList<>();
        List<Integer> lInt = new LinkedList<>();
        while(br.readLine()!=null){
            l.add(br.readLine());
        }
        br.close();
        for(String el: l)
            lInt.add(Integer.parseInt(el));
        return lInt;
    }
    static List<Integer> sort(List<Integer> l){
        Collections.sort(l);
        return l;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> randoms = generate(100, -30, 30);
        write(randoms, "file1.txt");
        List<Integer> randoms2 = read("file1.txt");
        List<Integer> sorted_randoms = sort(randoms2);
        write(sorted_randoms, "file2.txt");


    }
}
