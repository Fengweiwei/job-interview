package dp;

import java.util.Arrays;

/**
 * Created by fengweiwei on 2017/4/10.
 */
public class TranglePathSum {
    public static int sum(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = Arrays.copyOf(arr[arr.length - 1], arr[arr.length - 1].length);
        for (int i = arr.length - 2; i >= 0; i--) {
            //这样会更新错误
//            for(int j=arr[i].length-1; j>=0; j--){
//                dp[j] = arr[i][j] + Math.max(dp[j+1], dp[j]);
//            }
            for (int j = 0; j < arr[i].length; j++) {
                dp[j] = arr[i][j] + Math.max(dp[j + 1], dp[j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {7}
                , {3, 8}
                , {8, 1, 0}
                , {2, 7, 4, 4}
                , {4, 5, 2, 6, 5}
        };
        System.out.println(sum(arr));
    }
}
