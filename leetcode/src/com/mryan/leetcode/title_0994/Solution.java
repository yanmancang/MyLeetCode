package com.mryan.leetcode.title_0994;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> lists = new LinkedList<>();
        int H = grid.length;
        int L = grid[0].length;
        int count = 0;
        int round = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        int n = lists.size();
        while (count != 0 && n != 0) {
            round++;
            n = lists.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = lists.poll();
                if (list == null) {
                    break;
                }
                if (list.get(0) >= 1 && grid[list.get(0) - 1][list.get(1)] == 1) {
                    count--;
                    grid[list.get(0) - 1][list.get(1)] = 2;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(0) - 1);
                    tmp.add(list.get(1));
                    lists.add(tmp);
                }
                if (list.get(0) < H - 1 && grid[list.get(0) + 1][list.get(1)] == 1) {
                    count--;
                    grid[list.get(0) + 1][list.get(1)] = 2;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(0) + 1);
                    tmp.add(list.get(1));
                    lists.add(tmp);
                }
                if (list.get(1) >= 1 && grid[list.get(0)][list.get(1) - 1] == 1) {
                    count--;
                    grid[list.get(0)][list.get(1) - 1] = 2;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(0));
                    tmp.add(list.get(1) - 1);
                    lists.add(tmp);
                }
                if (list.get(1) < L - 1 && grid[list.get(0)][list.get(1) + 1] == 1) {
                    count--;
                    grid[list.get(0)][list.get(1) + 1] = 2;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(0));
                    tmp.add(list.get(1) + 1);
                    lists.add(tmp);
                }
            }

        }
        if (count == 0) {
            return round;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] range = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(new Solution().orangesRotting(range));
    }
}
