package com.lakers.entity;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 2022/10/8 9:28
 *
 * @author Lakers
 */
public class Test4 {

    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?

        Map<DayWithWeek, String> enumMap = new EnumMap<>(DayWithWeek.class);

        Map<Animal, Integer> treeMap = new TreeMap<>((Comparator.comparingInt(Animal::getAge)));

        new HashSet<>();
    }

}
