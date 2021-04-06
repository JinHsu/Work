package cn.sharit.ds;

public class Test5 {

    public static void main(String[] args) {
        String s = "  - 321432534abcs";
        char[] chars = s.toCharArray();

        boolean flag = false;
        int i = 0;
        int pos = 0;
        while (i < chars.length) {
            char c = chars[i];
            if (c == ' ') {
                i++;
                continue;
            }
            if (c == '-' && i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                flag = true;
                i++;
                pos = i;
                break;
            }

            if (c >= '0' && c <= '9') {
                pos = i;
                break;
            }
            i++;
        }

        int n = 0;
        while (i < chars.length) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                n += (c - 48) * 10;
                i++;
            } else {
                break;
            }
        }

        System.out.println(flag);
        System.out.println(pos);
        System.out.println('0');
    }
}
