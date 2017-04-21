package array;

/**
 * Created by fengweiwei on 2017/4/17.
 * 数组中子数组的最大累乘积
 */
public class Demo19 {
    public static int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        int ret = max;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(Math.max(max * arr[i], min * arr[i]), arr[i]);
            min = Math.min(Math.min(max * arr[i], min * arr[i]), arr[i]);
            ret = Math.max(max, ret);
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
