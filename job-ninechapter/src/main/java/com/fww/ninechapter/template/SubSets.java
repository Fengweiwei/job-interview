package com.fww.ninechapter.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengweiwei on 2017/6/14.
 */
public class SubSets {
    //排列组合模板
    //产生subsets
    //所有的子集，search
    private static void subsetsHelper(List<List<Integer>> ret,
                                      List<Integer> list,
                                      int[] nums,
                                      int step) {
        ret.add(new ArrayList<Integer>(list));

        for (int i = step; i < nums.length; i++) {
            //加i位置这个数
            list.add(nums[i]);
            //然后从i+1位置开始，递归执行
            //产生所有以list中元素开头的所有子集
            subsetsHelper(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> getSubSets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<List<Integer>>();
        subsetsHelper(subSets, new ArrayList<Integer>(), nums, 0);
        return subSets;
    }

    public static void main(String[] args) {
        int[]               nums    = {1, 2, 3, 4};
        List<List<Integer>> subSets = getSubSets(nums);
        subSets.forEach(l -> {
            System.out.print("[");
            l.forEach(e -> {
                System.out.print(e + ",");
            });
            System.out.print("]\n");
        });
    }
}
