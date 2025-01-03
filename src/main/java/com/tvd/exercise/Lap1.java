package com.tvd.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lap1 {
    
    // 1. Two Sum - https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    // 136. Single Number - https://leetcode.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // 485. Max Consecutive Ones - https://leetcode.com/problems/max-consecutive-ones/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                max_res = Math.max(max_res, cnt);
                cnt = 0;
            }
        }
        return Math.max(max_res, cnt);
    }

    // 169. Majority Element - https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > nums.length / 2) {
                return x;
            }
        }
        return 0;
    }

    // 1470. Shuffle the Array - https://leetcode.com/problems/shuffle-the-array/
    public int[] shuffle(int[] nums, int n) {
        int nums_size = n * 2;
        int[] res = new int[nums_size];
        int k = 0;
        for (int i = 0; i < nums_size; i += 2) {
            res[i] = nums[k];
            res[i + 1] = nums[n + k];
            k++;
        }
        return res;
    }

    // 268. Missing Number - https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {
        int nums_size = nums.length;
        int[] marked = new int[nums_size + 5];
        Arrays.fill(marked, 0);
        for (int i = 0; i < nums_size; i++) marked[nums[i]] = 1;
        for (int i = 0; i <= nums_size; i++) {
            if (marked[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // 1480. Running Sum of 1d Array - https://leetcode.com/problems/running-sum-of-1d-array/
    public int[] runningSum(int[] nums) {
        int nums_size = nums.length;
        int sum = 0;
        int[] res = new int[nums_size];
        for (int i = 0; i < nums_size; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    // 1920. Build Array from Permutation - https://leetcode.com/problems/build-array-from-permutation/
    public int[] buildArray(int[] nums) {
        int nums_size = nums.length;
        int[] res = new int[nums_size];
        for (int i = 0; i < nums_size; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    // 55. Jump Game - https://leetcode.com/problems/jump-game/
    public boolean canJump(int[] nums) {
        int nums_size = nums.length;
        int[] dp = new int[nums_size + 5];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < nums_size; i++) {
            if (dp[i] != 1) continue;
            for (int j = 1; j <= Math.min(nums[i], nums_size - i - 1); j++) {
                if (dp[i + j] == 1) continue;
                dp[i + j] = 1;
                if (i + j == nums_size - 1) return true;
            }
        }     
        return dp[nums_size - 1] == 1;
    }

    // 836. Rectangle Overlap - https://leetcode.com/problems/rectangle-overlap/
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
         return !(rec1[2] <= rec2[0] ||
                 rec1[0] >= rec2[2] || 
                 rec1[3] <= rec2[1] || 
                 rec1[1] >= rec2[3]); 
    }
}
