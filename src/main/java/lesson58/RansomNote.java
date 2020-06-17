package lesson58;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {

  static Map<String, Long> count(String[] st){
    return Arrays.stream(st).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
  }

  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Long> mag = count(magazine);
    Map<String, Long> not = count(note);

    System.out.println(not.entrySet().stream().anyMatch(n ->
            n.getValue() > mag.getOrDefault(n.getKey(), 0L)) ?
            "No":"Yes");


  }
}
