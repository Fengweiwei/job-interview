package com.fww.ninechapter.binarysearch;

/**
 * Created by fengweiwei on 2017/4/19.
 */
public class Demo1 {
    public static int binarysearch(int key, int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int lo = start;
        int hi = end;
        int mid;
        while (lo <= hi) {
            mid = lo + (lo + hi) >> 1;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
