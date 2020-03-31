package vn.tmt.springboot_web_casestudy.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrypPasswordUtils {
    public static String EncrypPasswordUtils(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println("pass 123 ma hoa thanh : " + EncrypPasswordUtils("123"));
    }
}