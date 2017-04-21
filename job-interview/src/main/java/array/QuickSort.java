package array;

/**
 * Created by fengweiwei on 2017/3/21.
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }

        int pivot_index = partition_proposal(arr, start, end);
        quickSort(arr, start, pivot_index - 1);
        quickSort(arr, pivot_index + 1, end);
    }

    //遍历数组，想象成左边访问过的，和右边没访问过的，j是访问过的和没访问过的边界线，
    //i是访问过的中左边小于pivot和右边大于pivot的边界线
    public static int partition_proposal(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i     = start + 1;
        int j     = start + 1;
        for (; j <= end; j++) {
            if (arr[j] < pivot) {
                swap(arr, j, i++);
            }
        }
        swap(arr, i - 1, start);
        return i;
    }

    //This is a little tricky
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i     = start;//记住i从start开始
        int j     = end;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, start, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 4, 1, 6, 5};
//        partition_proposal(arr, 0, arr.length-1);
        quickSort(arr);
        System.console();
    }
}
