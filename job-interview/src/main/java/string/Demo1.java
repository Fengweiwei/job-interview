package string;

/**
 * Created by fengweiwei on 2017/3/24.
 * 判断两个字符串是否互为变形词
 */
public class Demo1 {
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        int[] map = new int[300];
        for (int i = 0; i < str1.length(); i++) {
            map[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            map[str2.charAt(i)]--;
            if (map[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String  str1 = "fdssd";
        String  str2 = "fsdsd";
        boolean ret  = isDeformation(str1, str2);
        System.console();
    }
}
