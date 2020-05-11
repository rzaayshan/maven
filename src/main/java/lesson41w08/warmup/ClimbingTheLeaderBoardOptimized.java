package lesson41w08.warmup;

import java.util.Arrays;

public class ClimbingTheLeaderBoardOptimized {

  static int[] climbingLeaderboard(int[] scores, int[] alice) {
//    int [] ranges = new int[alice.length];
//    for(int i=0;i<alice.length;i++){
//      int range = 0;
//
//      if(alice[i]>scores[0]){
//        ranges[i]=range;
//        continue;
//      }
//      for (int j=1;j<scores.length;j++) {
//        if(scores[j-1]!=scores[j])
//          range++;
//        if (alice[i] >=scores[j])
//          break;
//      }
//      ranges[i]=range;
//    }
//    return ranges;
    int ranges[] = new int[alice.length];
    for(int i=0;i<alice.length;i++){
      int finalI = i;
      ranges[i] = (int) Arrays.stream(scores).filter(s -> s > alice[finalI]).distinct().count()+1;
    }
    return ranges;
  }

}
