package array;

/**
 * Created by fengweiwei on 2017/3/1.
 */
public class MergeSort {
    private static MergeSort Inst = null;

    //singleton
    public static MergeSort getInstance() {
        //double check
        if (Inst == null) {
            synchronized (MergeSort.class) {
                if (Inst == null) {
                    Inst = new MergeSort();
                }
//                Inst = new MergeSort();
            }
        }
        return Inst;
    }

    private MergeSort() {
    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 23, 2, 5, 3, 7, 13, -12, 8, 123};
        mergeSort(arr);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    protected static void fun() {
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (start >= end) {
            return;
        }

        int mid = (end + start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int   k   = 0;
        int   i   = start;
        int   j   = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (k = 0; k < tmp.length; k++) {
            arr[start + k] = tmp[k];
        }
    }
}
