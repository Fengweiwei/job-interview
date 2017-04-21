package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fengweiwei on 2017/3/24.
 * N皇后问题
 */
public class Demo17 {
    public static List<int[]> nQueen(int n) {
        List<int[]> ret = new ArrayList<>();

        int[] path = new int[n];

        //处理不同
        boolean[] booked = new boolean[n];
        //处理对角线
        boolean[] cross   = new boolean[3 * n];
        boolean[] ancross = new boolean[3 * n];

        step(0, n, booked, cross, ancross, path, ret);
        return ret;
    }

    public static void step(int step
            , int n
            , boolean[] booked
            , boolean[] cross
            , boolean[] ancross
            , int[] list
            , List<int[]> coll) {

        if (step == n) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");

            coll.add(Arrays.copyOf(list, list.length));//这里注意要创建新的数组，不然coll每个元素指向同一数组
            return;
        }

        for (int i = 0; i < n; i++) {
            if (booked[i] == false) {
                if ((cross[step + i] == false) && (ancross[step - i + n] == false)) {
                    //放i位置棋子
                    list[step] = i;
                    booked[i] = true;
                    cross[step + i] = true;
                    ancross[step - i + n] = true;
                    //从i+1开始放完所有旗子
                    step(step + 1, n, booked, cross, ancross, list, coll);
                    //
                    booked[i] = false;
                    cross[step + i] = false;
                    ancross[step - i + n] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<int[]> ret = nQueen(16);
        System.console();
    }
}
