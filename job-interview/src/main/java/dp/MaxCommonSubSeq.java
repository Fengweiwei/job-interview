package dp;

/**
 * Created by fengweiwei on 2017/4/13.
 * 最长公共子序列
 */
public class MaxCommonSubSeq {
    public static int maxLen(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        int     m  = s1.length() + 1;
        int     n  = s2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String s1 = "abcfbc";
        String s2 = "abfcab";
        System.out.println(maxLen(s1, s2));
        s1 = "programming";
        s2 = "contest";
        System.out.println(maxLen(s1, s2));
        s1 = "abcd";
        s2 = "mnp";
        System.out.println(maxLen(s1, s2));
    }
}
