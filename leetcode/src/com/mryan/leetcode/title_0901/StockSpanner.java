package com.mryan.leetcode.title_0901;

import java.util.*;

public class StockSpanner {
    List<Integer> list = new ArrayList<>();
    int last = 1;

    public StockSpanner() {

    }

    public int next(int price) {
        // 去除特殊形况，当前一个数比这次的大，直接返回count=1；
        if (list.size() == 0 || list.get(list.size() - 1) > price) {
            list.add(price);
            last = 1;
            return last;
        }
        // 当相邻两个数相同,则直接返回上一个数的count+1；
        if (list.get(list.size() - 1) == price) {
            last = last + 1;
            list.add(price);
            return last;
        }
        int count = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > price) {
                break;
            } else {
                count++;
            }
        }
        list.add(price);
        last = count;
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(90));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(68));
    }
}
