package array;

import com.fww.util.Misc;

/**
 * Created by fengweiwei on 2017/4/5.
 * 奇数下标都是奇数或者偶数下标都是偶数
 */
public class Demo15 {
    public static void transform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i   = 0;
        int j   = 1;
        int std = arr.length - 1;
        while (i < arr.length && j < arr.length) {
            if (arr[std] % 2 == 1) {
                Misc.swap(arr, std, j);
                j = j + 2;
            }
            if (arr[std] % 2 == 0) {
                Misc.swap(arr, std, i);
                i = i + 2;
            }
        }
    }

    public static boolean check(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < arr.length; i = i + 2) {
            if (arr[i] % 2 != 0) {
                flag = false;
            }
        }
        if (!flag) {
            for (int i = 1; i < arr.length; i = i + 2) {
                if (arr[i] % 2 != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        transform(arr);
        System.out.println(check(arr));
    }
}
