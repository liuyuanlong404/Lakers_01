package com.lakers.entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2022/9/26 17:16
 *
 * @author Lakers
 */
public class Test2 {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        InvocationHandler handler = (proxy, method, args1) -> {
            System.out.println(method);
            if ("morning".equals(method.getName())) {
                System.out.println("Good morning " + args1[0] + ",Age:" + args1[1]);
            }
            return null;
        };
        Hello1 hello = (Hello1) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class,Hello1.class}, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob", "111");

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        Method add = list.getClass().getDeclaredMethod("add", Object.class);
        add.invoke(list, "adc");
        System.out.println(list);
    }
}



interface Hello {
    void morning(String name, String age);

    void eat(String foods);
}

interface Hello1 {
    void morning(String name, String age);

}
