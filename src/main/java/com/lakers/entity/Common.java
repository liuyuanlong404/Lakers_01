package com.lakers.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2022/10/13 9:57
 *
 * @author Lakers
 */
public class Common {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }
    }
}
