package array.fww.data.structure;

/**
 * Created by fengweiwei on 2018/1/30.
 */
public class ArrayRotation {
    /**
     * page64
     * 返回将一维数组向右旋转k个位置的结果。比如，一维数组{1，2，3，4，5}，
     * k=2时，返回结果是{4，5，1，2，3}.要求常数级空间复杂度，允许修改原有数组。
     */
    public static int[] rotation(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //时间复杂度：O(kn)
        int tmp;
        for (int i = 0; i < k; i++) {
            tmp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = tmp;
        }
        return arr;
    }

    /***
     * 三步反转法：1.反转整个arr，2.反转前k个数，3.反转剩下的数
     * 时间复杂度：O(n)
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotation(arr, 2);
        System.out.println();
    }
}
