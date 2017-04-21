package array;

/**
 * Created by fengweiwei on 2017/3/20.
 * N*N矩阵顺时针转90度
 */
public class Demo2 {
    public static void rotate(int[][] arr) {
        int tR = 0;
        int tC = 0;
        int dR = arr.length - 1;
        int dC = arr[0].length - 1;
        while (tR <= dR && tC <= dC) {
            rotateEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    public static void rotateEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        int len = dC - tC;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = arr[tR][tC + i];
            arr[tR][tC + i] = arr[dR - i][tC];
            arr[dR - i][tC] = arr[dR][dC - i];
            arr[dR][dC - i] = arr[tR + i][dC];
            arr[tR + i][dC] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}
                , {13, 14, 15, 16}
        };

        rotate(arr);
        System.console();
    }
}
