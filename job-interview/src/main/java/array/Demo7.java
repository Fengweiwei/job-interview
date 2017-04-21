package array;

/**
 * Created by fengweiwei on 2017/3/21.
 * 在行列都排好序的矩阵中找数
 */
public class Demo7 {
    public static boolean isContain(int[][] arr, int key) {
        boolean ret = false;
        if (arr == null || arr.length == 0) {
            return ret;
        }
        int i = 0;
        int j = arr[0].length - 1;
        while (j >= 0 && i < arr.length) {
            if (arr[i][j] == key) {
                return true;//find
            } else {
                if (arr[i][j] > key) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 5}
                , {2, 3, 4, 7}
                , {4, 4, 4, 8}
                , {5, 7, 7, 9}
        };

        System.out.println(isContain(arr, 0));
    }
}
