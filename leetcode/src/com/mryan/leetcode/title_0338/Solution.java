package com.mryan.leetcode.title_0338;

import java.util.ArrayList;
import java.util.List;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */
class Solution {


    public int[] countBits(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            list.add(Integer.bitCount(i));
        }
        // list.stream().mapToInt(Integer::valueOf).toArray();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBits(5));
    }
}
