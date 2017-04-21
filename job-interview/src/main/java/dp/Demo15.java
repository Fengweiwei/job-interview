package dp;

/**
 * Created by fengweiwei on 2017/3/22.
 * 跳跃游戏
 */
public class Demo15 {
    /***
     * 题目都叫跳跃游戏了，那么想象成一个点
     * 在数组从左往右跳跃
     * @param arr
     * @return
     */
    public static int minSteps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int cur  = 0;//当前能到多远
        int next = 0;//下一跳能跳到多远
        int step = 0;//当前跳了多少步
        for (int i = 0; i < arr.length; i++) {
            if (cur >= arr.length - 1) {
                break;
            }
            //for loop 描述出点在数组上跳跃
            //看能不能走到位置i
            if (cur >= i) {
                next = Math.max(next, i + arr[i]);
            } else {
                step++;
                cur = next;
                next = Math.max(next, i + arr[i]);
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 4};
        int   ret = minSteps(arr);
        System.out.println("");
    }
}
