package app.lesson12;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IOFile {

    static List<Integer> generate(int n, int min, int max){
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
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
    static List<Integer>convert(List<String> l){
        List<Integer> lInt = l.stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
        return lInt;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> randoms = generate(100, -30, 30);
        write(randoms, "file1.txt");
        List<String> contents = read("file1.txt");
        List<Integer> randoms2 = convert(contents);
        List<Integer> sorted_randoms = sort(randoms2);
        write(sorted_randoms, "file2.txt");

    }
}
