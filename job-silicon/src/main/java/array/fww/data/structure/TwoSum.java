package array.fww.data.structure;

/**
 * Created by fengweiwei on 2018/1/30.
 */

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

/***
 * 数组有关的面试题，通常有以下几种：排序，两指针，动态规划，排列组合。
 * 对于二维数组，还可以考虑dfs和bfs
 */
public class TwoSum {
    /**
     * page60
     * 给定一个整形数组，是否能找出其中的两个数使其和为某个指定的值
     */
    public static int[] twoSum1(int[] arr, int key) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        //这里做法是排序，然后首尾两指针，时间复杂度O(nlogn)
        Arrays.sort(arr);
        int   start  = 0;
        int   end    = arr.length - 1;
        int[] result = new int[2];
        while (start < end) {
            if (arr[start] + arr[end] > key) {
                end--;
            } else if (arr[start] + arr[end] < key) {
                start++;
            } else if (arr[start] + arr[end] == key) {
                result[0] = arr[start];
                result[1] = arr[end];
                return result;
            }
        }
        return null;
    }

    /**
     * 给定一个整形的数组，找出其中的两个数使其和为某个指定的值。并返回这两个数的下标。假设数组元素的值各不相同，
     * 要求时间复杂度使O(n)
     *
     * @param arr
     * @param key
     * @return
     */
    public static int[] twoSum2(int[] arr, int key) {
        //做法是，牺牲空间，采用哈希表，时间复杂度O(n)
        if (arr == null || arr.length < 2) {
            return null;
        }
        //<k, v>:<value, index>
        Map<Integer, Integer> table = Maps.newHashMap();
        for (int i = 0; i < arr.length; i++) {
            table.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (table.containsKey(key - arr[i]) && !table.get(key - arr[i]).equals(i)) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = table.get(key - arr[i]);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr    = {5, 3, 3, 1};
        int[] result = twoSum2(arr, 10);
        System.out.println();
    }
}
