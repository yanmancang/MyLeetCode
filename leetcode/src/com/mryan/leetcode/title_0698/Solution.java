package com.mryan.leetcode.title_0698;

import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     * <p>
     * 示例 1：
     * <p>
     * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * 输出： True
     * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     *  
     * <p>
     * 注意:
     * <p>
     * 1 <= k <= len(nums) <= 16
     * 0 < nums[i] < 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (Arrays.stream(nums).sum() % k != 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum() / k;
        int start = 0;
        int cursum = 0;
        int target = sum;
        boolean[] used = new boolean[nums.length];
        if (cantotarget(nums, start, cursum, k, target, used)) {
            return true;
        }
        return false;
    }

    public boolean cantotarget(int[] nums, int start, int cursum, int k, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (cursum == target) {
            return cantotarget(nums, 0, 0, k - 1, target, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cursum + nums[i] <= target) {
                used[i] = true;
                if (!cantotarget(nums, i + 1, cursum + nums[i], k, target, used)) {
                    used[i] = false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{
                10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6
        };
        System.out.println(new Solution().canPartitionKSubsets(num, 3));
    }
}
