package lesson13;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentences {
    private static void write(List<String> lines, String filename) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String line: lines) {
            bw.write(line);
            bw.write("\n");
        }
        bw.close();
    }
    private static List<String> read(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br.lines().collect(Collectors.toList());
    }



    static Map<String, List<String>> createMap(List<String> data) throws FileNotFoundException {
        Map<String, List<String>> map = new HashMap<>();
        Iterator<String> it = data.iterator();
        while (it.hasNext()){
            String el = it.next();
            String []splitted = el.split("[:,]");
            List<String> val = new ArrayList<>();
            for(int i=1;i<splitted.length;i++)
                val.add(splitted[i]);
            map.put(splitted[0],val);}
            return map;
    }

    public static void main(String[] args) throws FileNotFoundException {

        List<String>verb_obj=read("verb_obj_.txt");
        List<String>subj_verb=read("subj_verb_.txt");
        Map<String, List<String>> verb_obj_map = createMap(verb_obj);
        Map<String, List<String>> subj_verb_map = createMap(subj_verb);
        Iterator<String> it_subj = subj_verb_map.keySet().iterator();
        Iterator<String> it_verb = verb_obj_map.keySet().iterator();
        List<String> sentences = new ArrayList<>();
        String sentence = null;
        while (it_subj.hasNext()){
            String subj = it_subj.next();
            List<String> verbs = subj_verb_map.get(subj);
            for(int i=0;i<verbs.size();i++){
                String verb = verbs.get(i);
                List<String> obj = verb_obj_map.get(verb);
                for (int j=0;j<obj.size();j++){
                    sentence = String.format("%s %s %s",subj,verb,obj.get(j));
                    sentences.add(sentence);
                }

            } }
        for(String k: sentences)
            System.out.println(k);




        }



    }

