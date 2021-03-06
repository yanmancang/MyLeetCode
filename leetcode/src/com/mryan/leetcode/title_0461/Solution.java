package com.mryan.leetcode.title_0461;

import java.util.Map;

public class Solution {
    // 常规思路，暴力解决
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

    // 利用API求解
    public int hammingDistance(int x, int y, boolean isApi) {
        StringBuilder newX = new StringBuilder(Integer.toBinaryString(x)).reverse();
        StringBuilder newY = new StringBuilder(Integer.toBinaryString(y)).reverse();
        int count = 0;
        int max = Math.max(newX.length(), newY.length());
        int xIn, yIn = 0;
        for (int i = 0; i < max; i++) {
            if (i >= newX.length()) {
                xIn = '0';
            } else {
                xIn = newX.charAt(i);
            }
            if (i >= newY.length()) {
                yIn = '0';
            } else {
                yIn = newY.charAt(i);
            }
            if (xIn == yIn) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    // 按照异或利用API求解
    public int hammingDistance(int x, int y, boolean isApi, boolean isOk) {
        return Integer.bitCount(x ^ y);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4, true, false));
    }
}
