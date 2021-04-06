package cn.sharit.算法.KMP算法;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        int[] next = new KMP().next("ABCDABD");
        System.out.println(Arrays.toString(next));
    }

    public int[] next(String target) {
        int[] next = new int[target.length()];

        next[0] = 0;
        // 012345
        // ABCDAB
        for (int i = 1, j = 0; i < target.length(); i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }

            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

}
