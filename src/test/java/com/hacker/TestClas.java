package com.hacker;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author: Zero
 * @Date: 2022/7/9 22:22
 * @Description:
 */
public class TestClas {

    @Test
    public void testPriorityQueue() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            //往尾部添加元素
            list.add(i);
        }

        //反转list里面的元素
        int size = list.size();
        for (int i = 0; i < size; i++) {
            //检索并删除该列表的头(第一个元素)
            Integer poll = list.poll();
            //往尾部添加元素
            list.offer(poll);
        }

    }
}
