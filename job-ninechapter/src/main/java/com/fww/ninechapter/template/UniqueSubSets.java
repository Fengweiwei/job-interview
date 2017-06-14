package com.fww.ninechapter.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengweiwei on 2017/6/14.
 */
public class UniqueSubSets {
    //nums: {1,2,2,3}
    public static List<List<Integer>> getUniqueSubSets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        UniqueSubSetsHelper(nums, subSets, new ArrayList<Integer>(), 0);
        return subSets;
    }

    private static void UniqueSubSetsHelper(int[] nums, List<List<Integer>> subSets, List<Integer> list, int step) {
        subSets.add(new ArrayList<Integer>(list));

        for (int i = step; i < nums.length; i++) {
            //和前面一样的就不要拿了，跳过
            if (i > step && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            UniqueSubSetsHelper(nums, subSets, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[]               nums    = {1, 2, 2, 3};
        List<List<Integer>> subSets = getUniqueSubSets(nums);
        subSets.forEach(l -> {
            System.out.print("[");
            l.forEach(e -> {
                System.out.print(e + ",");
            });
            System.out.print("]\n");
        });
    }
}
