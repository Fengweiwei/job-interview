package string;

/**
 * Created by fengweiwei on 2017/3/24.
 */
public class Demo2 {
    public static int sum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int sum  = 0;
        int item = 0;
        int flag = 1;//- or +
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                flag = -flag;
            } else if ((ch - '0') >= 0 && (ch - '0') <= 9) {
                //number
                if (i > 0 && str.charAt(i - 1) != '-') {
                    flag = 1;//无效
                }
                item = item * 10 + (ch - '0');
            } else {//不是数字，前面的加起来
                sum = sum + item * flag;
                flag = 1;
                item = 0;
            }
        }
        if (item != 0) {
            sum = sum + item * flag;
        }

        return sum;
    }

    public static void main(String[] args) {
        String str = "A1CD2E33";
        str = "A-1BC--12";
        int ret = sum(str);
        System.console();
    }
}
