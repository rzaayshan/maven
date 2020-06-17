package lesson55;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FairRationsApp {
    static int fairRations(int[] B) {
//        IntStream.range(1, B.length)
//                .filter(i->(B[i]&1)==1)
//                .forEach(i->{
//                    B[i]+=1;
//                    if((B[i-1]&1)==1)
//                        B[i-1]+=1;
//                    else if((B[i+1]&1)==1)
//                        B[i+1]+=1;
//                    else if((B[i+1]&1)==0 && (B[i+2]&1)==0)
//
//                });
        int c=0;
        for(int i=0;i<B.length;i++){
            if((B[i]&1)==1){
                if((B[i-1]&1)==1){
                    c++;
                    B[i-1]+=1;
                }
                else if((B[i+1]&1)==1){
                    B[i+1]+=1;
                    c++;
                }
                else if((B[i+1]&1)==0 && (B[i+2]&1)==0)
                    return -1;
                else if((B[i+1]&1)==0 && (B[i+2]&1)==1){
                    c++;
                    B[i+1]+=1;
                }
                System.out.println(Arrays.toString(B));


            }
        }
        return c;


    }

    public static void main(String[] args) {
        fairRations(new int[]{2, 3, 4, 5, 6});
    }

}
