package array;

/**
 * Created by fengweiwei on 2017/3/20.
 * 转圈打印矩阵
 */
public class Demo1 {
    /**
     * 总体思路：从外往内分圈打印
     *
     * @param arr
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void printMatrix(int[][] arr, int tR, int tC, int dR, int dC) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //只要左上角点坐标不超过右下角点坐标就要打印
        while (tR <= dR && tC <= dC) {
            //to right
            int p = tC;
            while (p < dC) {
                System.out.print(arr[tR][p++] + " ");
            }
            //down
            p = tR;
            while (p < dR) {
                System.out.print(arr[p++][dC] + " ");
            }
            //to left
            p = dC;
            while (p > tC) {
                System.out.print(arr[dR][p--] + " ");
            }
            //up
            p = dR;
            while (p > tR) {
                System.out.print(arr[p--][tC] + " ");
            }

            tR++;
            tC++;
            dR--;
            dC--;
        }
    }

    //这里是方阵
    public static void print(int[][] arr, int point1, int point2) {
        if (arr == null || arr.length == 0) {
            return;
        }
        while (point1 < point2) {
            int p = point1;
            //to right
            while (p < point2) {
                System.out.print(arr[point1][p++] + ", ");
            }
            //down
            p = point1;
            while (p < point2) {
                System.out.print(arr[p++][point2] + ", ");
            }
            //left
            p = point2;
            while (p > point1) {
                System.out.print(arr[point2][p--] + ", ");
            }
            //up
            p = point2;
            while (p > point1) {
                if ((point2 - point1) == 1) {
                    System.out.print(arr[p--][point1]);
                } else {
                    System.out.print(arr[p--][point1] + ", ");
                }
            }

            point1++;
            point2--;
        }
        //point1==point2
        if (point1 == point2) {
            System.out.print(arr[point1][point2]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3}
                , {5, 6, 4}
                , {9, 10, 7}
                , {11, 12, 14}
        };

        printMatrix(arr, 0, 0, arr.length - 1, arr[0].length - 1);
    }
}
