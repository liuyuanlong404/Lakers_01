package com.lakers.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on 2022/10/8 11:41
 *
 * @author Lakers
 */
public class Test5 {

    Logger log = LoggerFactory.getLogger(Test5.class);

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // 优先队列
        queue = new PriorityQueue<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        System.out.println(deque.pollLast()); // B, 剩下A
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null

    }
}
