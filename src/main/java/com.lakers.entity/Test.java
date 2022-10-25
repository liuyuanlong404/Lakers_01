package com.lakers.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2022/9/23 10:52
 *
 * @author Lakers
 */
public class Test {

    private final Log log = LogFactory.getLog(getClass());

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) throws Exception {
        Class<Student> stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        var getScore = stdClass.getMethod("getScore", String.class);
        int invoke = (int) getScore.invoke(new Student(), "1111");
        System.out.println(invoke);


        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName").invoke(new Student()));
        // 获取private方法getGrade，参数为int:
        Method getGrade = stdClass.getDeclaredMethod("getGrade", int.class);
        getGrade.setAccessible(true);
        System.out.println(getGrade.invoke(new Student(), 1));

        // 获取构造方法Integer(int):
        Constructor<Integer> cons1 = Integer.class.getConstructor(int.class);
        // 调用构造方法:
        Integer n1 = cons1.newInstance(123);
        System.out.println(n1);

        // 获取构造方法Integer(String)
        Constructor<Integer> cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = cons2.newInstance("456");
        System.out.println(n2);
    }
}

class Student extends Person {

    public int getScore(String type) {
        return 99 + Integer.parseInt(type);
    }

    private int getGrade(int year) {
        return 1;
    }
}

class Person {
    public String getName() {
        return "Person";
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3);
        list.add(2);
    }
}
