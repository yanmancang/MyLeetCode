package com.mryan.leetcode.title_0347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < k) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int[] tmp = new int[k];
        int base = 0;
        for (int i = 0; i < k; i++) {
            Collection<Integer> set = map.values();
            Object[] o = set.toArray();
            Arrays.sort(o);
            base = (int) o[o.length - k];
        }
        int kk = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int integer = iterator.next();
            if (map.get(integer) >= base) {
                tmp[kk] = integer;
                kk++;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().topKFrequent(nums, 2).length);
    }
}
