package com.lakers.entity;

/**
 * Created on 2022/10/24 11:06
 *
 * @author Lakers
 */
public class UserContext implements AutoCloseable {

    static final ThreadLocal<User> USER_CONTEXT = new ThreadLocal<>();

    public UserContext(User user) {
        USER_CONTEXT.set(user);
    }

    public static User currentUser() {
        return USER_CONTEXT.get();
    }

    @Override
    public void close() {
        USER_CONTEXT.remove();
    }
}
