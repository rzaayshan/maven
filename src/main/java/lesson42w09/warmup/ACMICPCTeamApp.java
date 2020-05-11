package lesson42w09.warmup;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ACMICPCTeamApp {

  static int[] acmTeam(String[] topics) {
    int n = topics.length;
    int max = 0;
    int count = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i; j < n; j++) {
        int m = 0;
        for (int k = 0; k < topics[i].length(); k++) {
          if (topics[i].charAt(k) == '1' || topics[j].charAt(k) == '1')
            m++;
        }
        if (m == max)
          count++;
        else if (m > max) {
          count = 1;
          max = m;
        }
      }
    }
    return new int[]{max, count};

  }
}
