package array;

/**
 * Created by fengweiwei on 2017/3/22.
 * 未排序正数数组中累加和为给定值的最长子数组长度
 */
public class Demo10 {
    public static int getMaxLengh(int[] arr, int key) {
        int ret = 0;
        if (arr == null || arr.length == 0) {
            return ret;
        }

        int i   = 0;
        int j   = 0;//i,j确定子数组范围
        int sum = arr[0];//sum={arr[i]+...+arr[j]}
        while (i <= j && j < arr.length) {
            if (sum == key) {
                ret = Math.max(ret, j - i + 1);
                sum -= arr[i++];
            } else if (sum < key) {
                if (j == arr.length - 1) {//注意，j+1；如果j已经到头了，说明结束了，break掉
                    break;
                }
                sum += arr[++j];
            } else {
                sum -= arr[i++];
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 1};
        int   ret = getMaxLengh(arr, 4);
        System.console();
    }
}
