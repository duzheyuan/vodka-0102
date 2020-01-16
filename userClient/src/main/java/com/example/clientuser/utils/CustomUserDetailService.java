package com.example.clientuser.utils;

import com.example.clientuser.service.UserService;
import com.example.common.entity.Power;
import com.example.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 11:30
 * Description: No Description
 *
 * @author:ZhouRunLin
 */

/**
 * 登录用户的所以角色权限
 */
@Component
public class CustomUserDetailService implements UserDetailsService  {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @param s
     * @return
     * @throws UsernameNotFoundException 根据登录账号初始化SecurityUser(当账号存在时)
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        User user = userService.getUserByUname(s);
        if(user==null){
            throw  new UsernameNotFoundException("not found UserName!!Come on!");
        }
        org.springframework.security.core.userdetails.User securityUser = null;
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Power power : user.getPowers()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + power.getPowerName()));
        }
        /**
         * 三个参数： 账号，解码后的密码，权限角色 构成securityUser
         */
        securityUser = new org.springframework.security.core.userdetails.User
                (user.getUname(), passwordEncoder.encode(user.getUpassword()), authorities);
        return securityUser;
    }
}
