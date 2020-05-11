package lesson36sql02.warmup;

import java.util.List;
import java.util.stream.Collectors;

public class Students {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        return grades.stream().map(el -> {
            if (el > 37) {
                int rem = 5 - el % 5;
                if (rem < 3)
                    return el + rem;
            }
            return el;
        }).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(gradingStudents(List.of(73,67,38,33)));
    }
}
