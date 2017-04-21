package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengweiwei on 2017/3/21.
 * 问题：不重复打印排序数组中相加和为给定值的所有二元组
 * 进阶问题：不重复打印排序数组中相加和为给定值的所有二元组
 */
public class Demo9 {
    public static List<List<Integer>> ThreeSumPair(int[] arr, int key) {
        List<List<Integer>> ret = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return ret;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {//注意，这里也要去重
                Map<Integer, Integer> map = findRest(arr, i + 1, arr.length - 1, key - arr[i]);
                if (!map.isEmpty()) {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        List<Integer> item = new ArrayList<>();
                        item.add(arr[i]);
                        item.add(entry.getKey());
                        item.add(entry.getValue());

                        ret.add(item);
                    }
                }
            }
        }

        return ret;
    }

    public static Map<Integer, Integer> findRest(int[] arr, int start, int end, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        while (start < end) {
            if (arr[start] + arr[end] == key) {
                //注意去重
                if (start == 0 || (start > 0 && arr[start] != arr[start - 1])) {
                    map.put(arr[start], arr[end]);
                }
                start++;
                end--;
            } else if (arr[start] + arr[end] < key) {
                start++;
            } else {
                end--;
            }
        }

        return map;
    }

    public static Map<Integer, Integer> twoSumPair(int[] arr, int key) {
        Map<Integer, Integer> map = new HashMap<>();

        if (arr == null || arr.length == 0) {
            return map;
        }

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == key) {
                if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {//check duplicate
                    map.put(arr[i], arr[j]);
                }
                i++;
                j--;
            } else if (sum < key) {
                i++;
            } else {
                j--;
            }
        }
        return map;
    }


    public static void main(String[] args) {
        int[]                 arr = {1, 1, 1, 9};
        Map<Integer, Integer> ret = twoSumPair(arr, 10);
    }
}
