package lesson37sql03.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {
    static void miniMaxSum(int[] arr) {
        int[] sum ={0};
        List<Integer> collect = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        Arrays.stream(arr).forEach(el->sum[0]=sum[0]+el);
        System.out.printf("%d %d", collect.get(0),collect.get(collect.size()-1));
    }
}
