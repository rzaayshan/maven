package lesson46;

public class MinimumSwaps2App_V1 {

  static int minimumSwaps(int[] arr) {
    int count=0;
    for(int i=0;i<arr.length;i++){
      while(arr[i]!=i+1){
        int temp=arr[i];
        arr[i]=arr[temp-1];
        arr[temp-1]=temp;
        count++;
      }
    }
    return count;

  }


  public static void main(String[] args) {

    System.out.println(minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
  }

}
