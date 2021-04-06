package cn.sharit.算法题._008_数字翻转;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
    }


    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10; // 个位

            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }

            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            ans = ans * 10 + pop;
            x /= 10;
        }

        return ans;
    }

}
