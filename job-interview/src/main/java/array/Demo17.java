package array;

import java.util.Arrays;

/**
 * Created by fengweiwei on 2017/4/5.
 * 子矩阵的最大累加和问题
 */
public class Demo17 {
    public static int maxSum(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int   sum = 0;
        int   max = Integer.MIN_VALUE;
        int[] acc = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = 0; k < acc.length; k++) {
                    acc[k] += arr[j][k];//update acc
                    sum += acc[k];
                    if (sum < 0) {
                        sum = 0;
                    }
                    max = Math.max(sum, max);
                }
            }
            Arrays.fill(acc, 0);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-90, 48, 78}
                , {64, -40, 64}
                , {-81, -7, 66}
        };

        System.out.println(maxSum(arr));
    }
}
