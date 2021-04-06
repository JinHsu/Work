package cn.sharit.算法题._005_两数之和;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            int cur = target - nums[i];
            if (map.containsKey(cur) && map.get(cur) != i) {
                return new int[]{map.get(cur), i};
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;

        int[] ints = new Solution().twoSum(nums, target);

        System.out.println(Arrays.toString(ints));

    }
}