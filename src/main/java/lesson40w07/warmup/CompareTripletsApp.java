package lesson40w07.warmup;

import java.util.ArrayList;
import java.util.List;

public class CompareTripletsApp {

  static List<Integer> compareTriplets1(List<Integer> a, List<Integer> b) {
    List <Integer> result = new ArrayList<>();
    int Ascore = 0;
    int Bscore = 0;
    for(int i=0;i<a.size();i++){
      if(a.get(i)>b.get(i))
        Ascore++;
      else if(a.get(i)<b.get(i))
        Bscore++;
    }
    result.add(Ascore);
    result.add(Bscore);
    return result;
  }

}
