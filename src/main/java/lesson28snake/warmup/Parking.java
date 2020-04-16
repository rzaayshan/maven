package lesson28snake.warmup;

import java.util.*;

public class Parking {
  public static long carParkingRoof(List<Long> cars, int k) {
    Collections.sort(cars);
    Iterator<Long> it = cars.iterator();
    Long min_step=cars.get(cars.size()-1);
    for(int i=0;i<cars.size()-k;i++){
      Long step = cars.get(i+k-1)-cars.get(i)+1;
      if(min_step>step)
        min_step=step;
    }
    return min_step;
  }

  public static void main(String[] args) {
    List<Long> cars = Arrays.asList(6L, 2L, 12L, 7L);
    long r = carParkingRoof(cars, 3);
    System.out.println(r); // 6
  }
}
