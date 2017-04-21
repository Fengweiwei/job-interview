package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengweiwei on 2017/3/21.
 * 在数组中找出现次数大于N/K的数
 */
public class Demo6 {
    /***
     * 找出一个数组中出现次数超过一半的数（当然也可能没有）
     * @param arr
     */
    public static int printHalfMajor(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int cnt   = 0;
        int token = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                token = arr[i];
                cnt = 1;
                continue;
            }

            if (arr[i] == token) {
                cnt++;
            } else {
                cnt--;
            }
        }

        //check
        cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (token == arr[i]) {
                cnt++;
            }
        }
        if (cnt > arr.length / 2) {
            return token;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static List<Integer> printKMajor(int[] arr, int k) {
        if (arr == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //种类竞争
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                //种类竞争，同种类+1
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                if (map.size() == k - 1) {
                    ;//容器满了，对里面每个元素杀1
                    List<Integer> deleteList = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == 1) {
                            //要从容器中删除掉一个
                            deleteList.add(arr[i]);
                        } else {
                            map.put(arr[i], map.get(arr[i]) - 1);
                        }
                    }
                    for (Integer deleteKey : deleteList) {
                        map.remove(deleteKey);
                    }
                } else {
                    //容器没有满，加进去
                    map.put(arr[i], 1);
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        int           cnt = 0;
        //check
        for (Integer key : map.keySet()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key) {
                    cnt++;
                }
            }
            if (cnt > arr.length / k) {
                ret.add(key);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int   ret = printHalfMajor(arr);
        System.console();
    }
}
