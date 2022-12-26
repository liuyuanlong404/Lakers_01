package com.lakers.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/11/19 15:14
 *
 * @author lakers
 */
public class Foo {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Cloneable cloneable = hashMap;
        Map map = hashMap;

        Foo foo = new Foo();
        foo.print(map);
        foo.print(cloneable);
        foo.print((Cloneable) hashMap);

    }

    public void print(Cloneable cloneable) {
        System.out.println("cloneable");
    }

    public void print(Map map) {
        System.out.println("map");
    }
}
