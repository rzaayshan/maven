package app.lesson12;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IOFilePair {
    static class Pair implements Comparable<Pair>{
        int key;
        int value;
        public int compareTo(Pair that) {
            return this.key - that.key;
//    return this.name.compareTo(that.name);
        }
    }

    static List<Pair> generate(int n, int min, int max){
        List<Pair> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            int key=(int)(Math.random()*61-30);
            int val=(int)(Math.random()*61-30);
            Pair p = new Pair();
            p.value=val;
            p.key=key;
            list.add(p);
        }
        return list;
    }

    static void write(List<String> l, String name) throws IOException {
        File ofile = new File(name);
        BufferedWriter bw = new BufferedWriter(new FileWriter(ofile));
        for(String el: l){
            bw.write(el);
            bw.write("\n");
        }
        bw.close();
    }

    static List<String>read(String name) throws IOException {
        File ifile = new File(name);
        BufferedReader br = new BufferedReader(new FileReader(ifile));
        List<String> l = new LinkedList<>();
        List<Integer> lInt = new LinkedList<>();
        while(br.readLine()!=null){
            l.add(br.readLine());
        }
        br.close();
        return l;
    }
    static List<Pair> sort(List<Pair> p){
        Collections.sort(p);
        return p;
    }
    static List<Pair>convertSI(List<String> l){
        List <Pair> pairs = new ArrayList<>();
        for(String s:l) {
            String[] splitted = s.split(":");
            Pair p = new Pair();
            p.key=Integer.parseInt(splitted[0]);
            p.value=Integer.parseInt(splitted[1]);
            pairs.add(p);

        }
        return pairs;
    }
    static List<String>convertIS(List<Pair> pairs){
        List<String> str = new LinkedList<>();
        for(Pair p:pairs) {
            String s=String.format("%s:%s",p.key,p.value);
            str.add(s);
        }

        return str;
    }

    public static void main(String[] args) throws IOException {
        List<Pair> randoms = generate(100, -30, 30);

        List<String> randoms2 = convertIS(randoms);
        write(randoms2, "file1.txt");
        List<String> contents = read("file1.txt");

        List<Pair> randoms3 = convertSI(contents);
        List<Pair> sorted_randoms = sort(randoms3);
        List<String> sorted_randomss = convertIS(sorted_randoms);
        write(sorted_randomss, "file2.txt");
    }
}
