package lesson50;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class warmup {
    List<Character> sToL(String s){
        return s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
    }
    static long substrCount(int n, String s) {
        int len = s.length();
        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Long reduce = collect.values().stream().filter(aLong -> aLong > 1)
                .map(aLong -> (len - aLong) * aLong / 2).reduce(0L,
                        Long::sum);
        reduce+=collect.values().stream().reduce(0L,Long::sum);

        return reduce;


    }

}
