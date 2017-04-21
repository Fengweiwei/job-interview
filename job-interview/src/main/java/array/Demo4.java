package array;

/**
 * Created by fengweiwei on 2017/3/20.
 * 找到无序数组中最小的k个数
 */
public class Demo4 {
    /***
     * 堆：首先，将一个数组假想成一颗完全二叉树，数组对应下标从1开始
     * 这样就有很好的性质，左右孩子在数组中的下标 left = root * 2,right = root * 2 + 1(如果存在的话)
     * max-heap性质：对每个节点，它的值比它的左右孩子都要大
     */
    /**
     * 叶子节点肯定满足heap，
     * 每次调用heapify(arr, i)
     * 那么每次left，right都满足堆性质，
     * 只要调整i节点即可
     *
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        int index = (arr.length - 1) / 2;
        while (index != 0) {
            heapify(arr, index);
            index--;
        }
    }

    /***
     * 从index下标开始，维护最大堆的性质,
     * 从index开始的子树不符合heap的性质，
     * 所以要修改这颗子树，达到heap的性质
     * @param arr
     * @param index
     */
    public static void heapify(int[] arr, int index) {
        int left  = index * 2;
        int right = index * 2 + 1;

        while (left < arr.length) {
            if (right > arr.length - 1) {
                //没有右孩子
                if (arr[index] < arr[left]) {
                    swap(arr, index, left);
                    index = left;
                }
            } else {
                if (arr[left] > arr[right]) {
                    swap(arr, left, index);
                    index = left;
                } else if (arr[left] < arr[right]) {
                    swap(arr, right, index);
                    index = right;
                } else {
                    break;
                }
            }
            left = index * 2;
            right = index * 2 + 1;
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int[] findTopK(int[] arr, int k) {
        if (arr.length < k || k < 1) {
            return arr;
        }
        //create heap
        int[] kHeap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            kHeap[1 + i] = arr[i];
        }
        buildMaxHeap(kHeap);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < kHeap[1]) {
                kHeap[1] = arr[i];
                heapify(kHeap, 1);
            }
        }
        return kHeap;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 3, 34, 5, 6, 6, 78, 7, 8989, 80, 9, 0, -3};
        int[] ret = findTopK(arr, 4);
        System.console();
    }
}
