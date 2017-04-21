package array;

/**
 * Created by fengweiwei on 2017/4/17.
 * 在数组中找到一个局部最小的位置
 */
public class Demo18 {
    public static int findLocalMin(int[] arr) {
        if (arr == null || arr.length == 0) {//不存在局部最小
            return -1;
        } else if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        } else if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int lo = 1;
        int hi = arr.length - 2;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > arr[mid - 1]) {
                hi = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
