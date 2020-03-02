package app.lesson12;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IOFile {
    class Pair{
        int key;
        int value;
    }

    static List<Integer> generate(int n, int min, int max){
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            int rand=(int)(Math.random()*61-30);
            list.add(rand);
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
    static List<Integer> sort(List<Integer> l){
        Collections.sort(l);
        return l;
    }
    static List<Integer>convertSI(List<String> l){
        List<Integer> lInt = l.stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
        return lInt;
    }
    static List<String>convertIS(List<Integer> l){
        List<String> lStr = l.stream().map(x->x.toString()).collect(Collectors.toList());
        return lStr;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> randoms = generate(100, -30, 30);

        List<String> randoms2 = convertIS(randoms);
        write(randoms2, "file1.txt");
        List<String> contents = read("file1.txt");

        List<Integer> randoms3 = convertSI(contents);
        List<Integer> sorted_randoms = sort(randoms3);
        List<String> sorted_randomss = convertIS(sorted_randoms);
        write(sorted_randomss, "file2.txt");
    }
}
