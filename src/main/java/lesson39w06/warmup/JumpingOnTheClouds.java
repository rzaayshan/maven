package lesson39w06.warmup;

public class JumpingOnTheClouds {

  static int jumpingOnClouds(int[] c) {
    int steps=0;
    int i=0;
    while(i<c.length-1){
      if(i+2==c.length || c[i+2]==1)
        i++;
      else
        i+=2;
      steps++;
    }
    return steps;
  }

}
