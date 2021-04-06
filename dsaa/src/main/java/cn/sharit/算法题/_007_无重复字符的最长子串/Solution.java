package cn.sharit.算法题._007_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwabcwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));

    }
}