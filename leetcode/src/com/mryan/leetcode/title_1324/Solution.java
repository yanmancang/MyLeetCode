package com.mryan.leetcode.title_1324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        String[] all_string = s.split(" ");
        List<String> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < all_string.length; i++) {
            if (max < all_string[i].length()) {
                max = all_string[i].length();
            }
        }

        for (int i = 0; i < max; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < all_string.length; j++) {
                if (all_string[j].length() <= i) {
                    builder.append(" ");
                } else {
                    builder.append(all_string[j].charAt(i));
                }
            }
            String target = "*" + builder.toString();
            list.add(target.trim().replace("*", ""));
        }


        return list;
    }

    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        System.out.println(new Solution().printVertically(s).toString());
    }
}