package com.fww.ninechapter.template;

/**
 * Created by fengweiwei on 2017/6/15.
 */
public class BinarySearch {
    //二分搜索模板
    public static int binarySearch(int[] nums, int key) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low  = 0;
        int high = nums.length - 1;
        //low和high相邻或者相等的时候退出循环
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > key) {
                high = mid;
            } else if (nums[mid] < key) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return nums[low] == key ? low : high;
    }


    public static void main(String[] args) {

    }
}
