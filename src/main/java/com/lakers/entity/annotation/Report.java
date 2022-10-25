package com.lakers.entity.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created on 2022/9/27 11:07
 *
 * @author Lakers
 */
@Repeatable(value = Reports.class)
@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {

    int type() default 0;
    String level() default "info";
    String value() default "";
}

