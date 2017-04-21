package array;

/**
 * Created by fengweiwei on 2017/3/20.
 * 之字形打印矩阵
 */
public class Demo3 {
    public static void print(int[][] arr) {
        int     tR   = 0;
        int     tC   = 0;
        int     dR   = 0;
        int     dC   = 0;
        Boolean flag = true;

        while (tR != arr.length && tC != arr[0].length) {
            printLine(arr, tR, tC, dR, dC, flag);
            if (tR >= (arr.length - 1)) {
                tC++;
            } else {
                tR++;
            }
            if (dC >= (arr[0].length - 1)) {
                dR++;
            } else {
                dC++;
            }
            flag = !flag;
        }
    }

    public static void printLine(int[][] arr, int tR, int tC, int dR, int dC, Boolean flag) {
        if (tR == dR && tC == dC) {
            System.out.print(arr[tR][tC] + " ");
            return;
        }

        if (flag) {
            //邪上打印
            int pR = tR;
            int pC = tC;
            while (pR != dR && pC != dC) {
                System.out.print(arr[pR--][pC++] + " ");
            }
            System.out.print(arr[dR][dC] + " ");
            flag = false;
        } else {
            //斜下打印
            int pR = dR;
            int pC = dC;
            while (pR != tR && pC != tC) {
                System.out.print(arr[pR++][pC--] + " ");
            }
            System.out.print(arr[tR][tC] + " ");
            flag = true;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4}
                , {5, 6, 7, 8}
                , {9, 10, 11, 12}
        };

        print(arr);
    }
}
