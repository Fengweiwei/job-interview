package array;

/**
 * Created by fengweiwei on 2017/3/6.
 */
public class CountInversions {
    public static int countInversions(int[] arr) {
        return sortAndCount(arr, 0, arr.length - 1);
    }

    private static int sortAndCount(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (start >= end) {
            return 0;
        }

        int mid   = (start + end) / 2;
        int left  = sortAndCount(arr, start, mid);
        int right = sortAndCount(arr, mid + 1, end);
        int cross = mergeAndCout(arr, start, end);
        return left + right + cross;
    }

    private static int mergeAndCout(int arr[], int start, int end) {
        int cnt = 0;

        int   len = end - start + 1;
        int   mid = (start + end) / 2;
        int   i   = start;
        int   j   = mid + 1;
        int[] tmp = new int[len];
        int   k   = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];

                cnt = cnt + (mid - i + 1);
            } else {
                tmp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
//            cnt = cnt + end - mid;
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (k = 0; k < len; k++) {
            arr[start + k] = tmp[k];
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        int   ret = countInversions(arr);
        System.out.println(ret);
    }
}
