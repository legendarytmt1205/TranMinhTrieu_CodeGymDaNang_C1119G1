package vn.tmt.springboot_web_casestudy.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String userName);
}
