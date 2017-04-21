package dp;

/**
 * Created by fengweiwei on 2017/3/24.
 * 矩阵的最小路径和
 */
public class Demo2 {
    public static int minPathSum(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] dp = new int[arr[0].length];
        //一层一层算。空间复杂度可以降到O(arr[0].length)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = arr[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + arr[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + arr[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + arr[i][j];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 9}
                , {8, 1, 3, 4}
                , {5, 0, 6, 1}
                , {8, 8, 4, 0}
        };

        int ret = minPathSum(arr);
        System.console();
    }
}
