package com.mryan.leetcode.title_0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * 分析：利用单方向查找，避免同一组数字查询多次，如-1 0 1，固定-1，从-1右边开始查找；假如固定 0 从两边查找可能存在3组结果
 * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L]和 nums[R]，计算三个数的和 sum判断是否满足为 0，满足则添加进结果集
 * 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
 * 如果 nums[i] =nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sum=0 时，nums[L]= nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sum= 0 时，nums[R]= nums[R−1]则会导致结果重复，应该跳过，R−−
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> target = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return target;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                break;
            }
            // 0,0,0,0 避免两个相同的值的情况
            // 对于包装类型尽量不要使用 == 来比较，开始使用==比较，leetcode测试用例始终有一个不能通过
            if (i > 0 && list.get(i).equals(list.get(i - 1))) {
                continue;
            }
            int L = i + 1;
            int R = list.size() - 1;
            //-4,-1,-1,0, 1, 2
            while (L < R) {
                int sum = list.get(i) + list.get(L) + list.get(R);
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(i));
                    tmp.add(list.get(L));
                    tmp.add(list.get(R));
                    target.add(tmp);
                    // 去除左边重复的序列，避免-1,0,0，1
                    while (L < R && list.get(L).equals(list.get(L + 1))) {
                        L++;
                    }
                    // 去除右边重复的序列，避免-1,0,1,1
                    while (L < R && list.get(R).equals(list.get(R - 1))) {
                        R--;
                    }
                    // 数组已经是按照有小到大排列，且将重复的部分去除;避免存在 -1，-1，0，1，2
                    L++;
                    R--;


                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return target;
        /**
         *         List<List<Integer>> ans = new ArrayList();
         *         int len = nums.length;
         *         if(nums == null || len < 3) return ans;
         *         Arrays.sort(nums); // 排序
         *         for (int i = 0; i < len ; i++) {
         *             if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
         *             if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
         *             int L = i+1;
         *             int R = len-1;
         *             while(L < R){
         *                 int sum = nums[i] + nums[L] + nums[R];
         *                 if(sum == 0){
         *                     ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
         *                     while (L<R && nums[L] == nums[L+1]) L++; // 去重
         *                     while (L<R && nums[R] == nums[R-1]) R--; // 去重
         *                     L++;
         *                     R--;
         *                 }
         *                 else if (sum < 0) L++;
         *                 else if (sum > 0) R--;
         *             }
         *         }
         *         return ans;
         * ————————————————
         * 版权声明：本文为CSDN博主「xushiyu1996818」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
         * 原文链接：https://blog.csdn.net/xushiyu1996818/article/details/83540923
         */
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        System.out.println(new Solution().threeSum(nums));
    }
}
