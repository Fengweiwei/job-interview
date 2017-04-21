package array;

/**
 * Created by fengweiwei on 2017/3/21.
 * 最长的可整合子数组长度
 */
public class Demo8 {
    public static int getMaxLen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ret = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {//i到j范围找
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                if (max - min == j - i) {
                    ret = Math.max(ret, j - i + 1);
                }
            }
            max = Integer.MIN_VALUE;//注意，一轮找完后，需要重新初始化
            min = Integer.MAX_VALUE;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 4};
        int   ret = getMaxLen(arr);
        System.console();
    }
}
