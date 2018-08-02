package ua.com.infopulse.demo.util;

import ua.com.infopulse.demo.entity.User;

public class Utils {
    public static User.Status get(String value) {
        try {
            return User.Status.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
