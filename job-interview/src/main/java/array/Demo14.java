package array;

import com.fww.util.Misc;

/**
 * Created by fengweiwei on 2017/3/22.
 * 自然数数组的排序
 */
public class Demo14 {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                Misc.swap(arr, i, arr[i] - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
