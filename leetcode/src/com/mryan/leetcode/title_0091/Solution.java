package com.mryan.leetcode.title_0091;

import java.util.HashMap;
import java.util.Map;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> mapCount = new HashMap<>();

    Solution() {
        for (int i = 1; i <= 26; i++) {
            map.put(i + "", i);
        }
    }

    public int numDecodings(String s) {
        if (mapCount.get(s) != null) {
            return mapCount.get(s);
        }
        if (s.startsWith("0")) {
            mapCount.put(s, 0);
            return 0;
        }
        if (s.contains("0") && (!s.contains("10") && !s.contains("20"))) {
            mapCount.put(s, 0);
            return 0;
        }
        if (s.isEmpty() || s.length() == 1) {
            mapCount.put(s, 1);
            return 1;
        }

        int leftCount = 0;
        String left = s.substring(0, 1);
        int l = map.getOrDefault(left, 0);
        if (l >= 1 && l <= 26) {
            leftCount = numDecodings(s.substring(1));
        } else {
            mapCount.put(s, leftCount);
            return leftCount;
        }
        int rightCount = 0;

        String right = s.substring(0, 2);
        int tmp = map.getOrDefault(right, 0);
        if (tmp >= 1 && tmp <= 26) {
            if (s.length() == 2) {
                rightCount = 1;
            } else {
                rightCount = numDecodings(s.substring(2));
            }
        }
        mapCount.put(s, leftCount + rightCount);
        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        String s = "19963";
        System.out.println(new Solution().numDecodings(s));
    }
}
