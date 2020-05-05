package com.mryan.leetcode.title_0205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char s_tmp = s.charAt(i);
            char t_tmp = t.charAt(i);
            if (map.containsKey(s_tmp)) {
                if (map.get(s_tmp) != t_tmp) {
                    return false;
                }
            } else if (map.containsValue(t_tmp)) {
                return false;
            } else {
                map.put(s_tmp, t_tmp);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(new Solution().isIsomorphic(s, t));
    }
}
