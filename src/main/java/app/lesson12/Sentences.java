package app.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Sentences {





    public static void main(String[] args) {
        List<String> subjects = new ArrayList(Arrays.asList("Noel", "The cat", "The dog"));
        List<String> verbs = new ArrayList(Arrays.asList("wrote", "chased", "slept on"));
        List<String> objects =  new ArrayList(Arrays.asList("the book","the ball","the bed"));
        List<String> sentences = new ArrayList<>();
        for(String subject : subjects){
            for(String verb: verbs){
                for(String object: objects){
                    String s = String.format("%s %s %s", subject, verb, object);
                    sentences.add(s);
                }
            }
        }
        for(String el: sentences)
            System.out.println(el);






    }
}
