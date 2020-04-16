import java.util.Arrays;
import java.util.Random;

public class lesson26 {
    public static void main(String[] args) {
        int[] array = new Random()
                .ints(10, 51)
                .limit(30)
                .toArray();
        int min_index=0;
        int min_sum=Integer.MAX_VALUE;
        for(int i=0;i<array.length-1;i++){
            if(min_sum>array[i]+array[i+1]){
                min_index=i;
                min_sum=array[i]+array[i+1];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.printf("index %d\n",min_index);
        System.out.printf("num1 %d\n", array[min_index]);
        System.out.printf("num2 %d\n", array[min_index+1]);
        System.out.printf("sum %d\n", min_sum);

    }
}
