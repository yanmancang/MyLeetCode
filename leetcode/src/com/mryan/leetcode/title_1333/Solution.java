package com.mryan.leetcode.title_1333;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<List<Integer>> allRes = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(restaurants[i][0]); // id
            list.add(restaurants[i][1]); // rating
            if (veganFriendly == 1 && restaurants[i][2] != veganFriendly) {
                // 获取满足第一个条件的数组
                continue;
            }
            list.add(restaurants[i][2]); // veganFriendly
            if (maxPrice < restaurants[i][3]) {
                continue;
            }
            list.add(restaurants[i][3]); // price
            if (maxDistance < restaurants[i][4]) {
                continue;
            }
            list.add(restaurants[i][4]); // distance
            allRes.add(list);
        }
        List<Integer> result = new ArrayList<>();
        // 返回1代表两个数需要交换顺序 返回0，-1 代表两个数不需要交换顺序
        allRes.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o2.get(1) - o1.get(1) == 0) {
                    return o2.get(0) - o1.get(0);
                }
                return o2.get(1) - o1.get(1);
            }

        });
        for (int i = 0; i < allRes.size(); i++) {
            result.add(allRes.get(i).get(0));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        System.out.println(new Solution().filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}
