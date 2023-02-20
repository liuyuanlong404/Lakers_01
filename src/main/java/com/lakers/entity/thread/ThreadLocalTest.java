package com.lakers.entity.thread;

import com.lakers.entity.User;
import com.lakers.entity.UserContext;

/**
 * Created on 2022/10/24 11:10
 *
 * @author Lakers
 */
public class ThreadLocalTest {


    public static void main(String[] args) {
        try (UserContext ignored = new UserContext(new User(1, "Lakers"))) {
            show();
            search();
            update();
        }
    }

    private static void update() {
        User user = UserContext.currentUser();
        System.out.println(user);
        System.out.println("更新数据库！！！");
    }

    private static void search() {
        User user = UserContext.currentUser();
        user.setId(2);
        user.setName("rose");
        System.out.println(user);
        System.out.println("查询数据库！！！");
    }

    private static void show() {
        User user = UserContext.currentUser();
        System.out.println(user);
    }
}
