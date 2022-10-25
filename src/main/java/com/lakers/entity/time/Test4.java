package com.lakers.entity.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created on 2022/10/12 16:45
 *
 * @author Lakers
 */
public class Test4 {

    public static void main(String[] args) {
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
//        System.out.println(zbj);
//        System.out.println(zny);

        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);

    }
}
