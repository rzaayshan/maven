package lesson13;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sentences2 {
    public static void main(String[] args) throws IOException {
        // read 1st
        List<String> f1 = read("subj_verb.txt");
        // read second
        List<String> f2 = read("verb_obj_.txt");
        // convert 1st to map
        if(!(f1==null || f2==null)) {
            Map<String, List<String>> sv = convert(f1);
            // convert 2nd to map
            Map<String, List<String>> vo = convert(f2);
            // combine sentences
            List<Sentence> sentences = combine(sv, vo);
            // write to file
            write("combined.txt", sentences);}

    }



    private static List<Sentence> combine(Map<String, List<String>> sv, Map<String, List<String>> vo) {
        return sv.keySet().stream().flatMap(subj ->
                sv.get(subj).stream().flatMap(verb ->
                        vo.get(verb).stream().map(obj ->
                                new Sentence(subj, verb, obj)
                        )
                )
        ).collect(Collectors.toList());
    }

    private static Map<String, List<String>> convert(List<String> list) {
        HashMap<String, List<String>> data = new HashMap<>();
        for (String line: list) {
            String[] splitted = line.split(":");
            // Noel : wrote, chased, slept on
            // splitted[0] = `Noel `
            // splitted[1] = ` wrote, chased, slept on`
            String[] splited2 = splitted[1].split(",");
            // [0] = ` wrote` [1] = ` chased` [2] = ` slept on`
            data.put(
                    splitted[0].trim(),
                    Arrays.stream(splited2).map(s -> s.trim()).collect(Collectors.toList())
                    // [0] = `wrote` [1] = `chased` [2] = `slept on`
            );
        }
        return data;
    }

    private static void write(String filename, List<Sentence> sentences) throws IOException {
        File file = new File(filename);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Sentence sentence: sentences) {
            bw.write(sentence.represent());
            bw.write("\n");
        }
        bw.close();
    }

    private static List<String> read(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if(file.exists())
            return new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
        System.out.println("The file doesn't exist");
        return null;
    }

    }

