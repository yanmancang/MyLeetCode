package com.mryan.leetcode.title_0461;

import java.util.Map;

public class Solution {
    public int hammingDistance(int x, int y) {
        StringBuilder xStringBuilder = new StringBuilder();
        StringBuilder yStringBuilder = new StringBuilder();
        // 将10进制转为2进制
        while (true) {
            xStringBuilder.append(x % 2);
            if (x / 2 != 0) {
                x = x / 2;
            } else {
                break;
            }
        }
        // 将10进制转为2进制
        while (true) {
            yStringBuilder.append(y % 2);
            if (y / 2 != 0) {
                y = y / 2;
            } else {
                break;
            }
        }
        int count = 0;
        int max = Math.max(xStringBuilder.length(), yStringBuilder.length());
        int xIn, yIn = 0;
        for (int i = 0; i < max; i++) {
            if (i >= xStringBuilder.length()) {
                xIn = '0';
            } else {
                xIn = xStringBuilder.charAt(i);
            }
            if (i >= yStringBuilder.length()) {
                yIn = '0';
            } else {
                yIn = yStringBuilder.charAt(i);
            }
            if (xIn == yIn) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(4, 14));
    }
}
