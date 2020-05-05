package com.mryan.leetcode.title_0744;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
            if (i == letters.length - 1) {
                return letters[0];
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }
}
