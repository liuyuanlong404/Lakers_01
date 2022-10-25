package com.lakers.entity;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2022/10/8 11:58
 *
 * @author Lakers
 */
public class Test6 {

    public static Map<Long, String> map = new LinkedHashMap<>();

    static {
        map.put(0L, "0");
        map.put(1L, "1");
        map.put(2L, "2");
        map.put(3L, "3");
        map.put(4L, "4");
        map.put(5L, "5");
        map.put(6L, "6");
        map.put(7L, "7");
        map.put(8L, "8");
        map.put(9L, "9");
        map.put(10L, "A");
        map.put(11L, "B");
        map.put(12L, "C");
        map.put(13L, "D");
        map.put(14L, "E");
        map.put(15L, "F");
    }


    public static void main(String[] args) {
        DecimalType type = DecimalType.SIXTEEN;
        String result = decimalTransform(-161654654L, type);
        System.out.println(result);
        System.out.println(Long.parseLong(result, 16));
        System.out.printf("%08X%n", -161654654L);
        System.out.println(0XFFFFFFFFF65D5882L);
    }

    public static String decimalTransform(long x, DecimalType decimalType) {

        Deque<Long> stack = new LinkedList<>();
        boolean flag = false;
        if (x < 0) {
            x = Math.abs(x);
            flag = true;
        }
        while (x > 0) {
            long temp = x / decimalType.getDecimal();
            long remainder = x % decimalType.getDecimal();
            stack.push(remainder);
            x = temp;
        }

        String collect = stack.stream().map(t -> map.get(t)).collect(Collectors.joining());
        String[] strings = new String[collect.length()];
        if (flag){
            for (int i = 0; i < collect.toCharArray().length; i++) {

            }
        }
        return collect;
    }
}
