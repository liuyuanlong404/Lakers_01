package com.lakers.entity;

import java.util.Arrays;

/**
 * Created on 2022/9/29 11:21
 *
 * @author Lakers
 */
public class Test3 {
    public static void main(String[] args) {
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));

        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));

    }

    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2, k3);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
}