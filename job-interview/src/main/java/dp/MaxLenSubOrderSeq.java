package dp;

import java.util.Arrays;

/**
 * Created by fengweiwei on 2017/4/10.
 * 最长上升子序列
 */
public class MaxLenSubOrderSeq {
    public static int maxLen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 5, 9, 4, 8};
        System.out.println(maxLen(arr));
    }
}
