package com.example.clientuser.utils;

import com.example.clientuser.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 18:16
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class AuthService {
    @Autowired
    private PermissionService permissionService;

    private Map<String, Collection<ConfigAttribute>> permissionMap;

    /**
     * securityUser进行对比
     */
    public Boolean canAccess(HttpServletRequest request, Authentication authentication) {
        /**
         * 显示登陆用户的所有权限 System.out.println("///"+authentication.getAuthorities());
         */
        Boolean b = false;
        /**
         * 1/未登录的情况下
         * 因为是每个地址请求都会走一遍canAccess，所以未登录的情况下需要直接判断并返回false
         * principal 指整个securityUser
         */
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)) {
            return b;
        }

        /**
         * 3/  通过request对象的url获得权限信息
         */
        //获得数据库的权限信息集合
        if (permissionMap == null || permissionMap.size() == 0) {
            permissionMap = permissionService.getPermissionMap();
        }

        String urlPermission;
        AntPathRequestMatcher antPathRequestMatcher;
        Collection<ConfigAttribute> configAttributes = null;
        for (Iterator<String> it = permissionMap.keySet().iterator(); it.hasNext(); ) {
            urlPermission = it.next();
            antPathRequestMatcher = new AntPathRequestMatcher(urlPermission);
            //匹配URL
            if (antPathRequestMatcher.matches(request)) {
                configAttributes = permissionMap.get(urlPermission);
                break;
            }
        }
        //Map里面没有此request权限信息-->configAttributes（对应request地址的所有权限用户信息）为null
        if (configAttributes == null || configAttributes.size() == 0) {
            return b;
        }
        /**
         * 4/将获取到的权限信息和当前的登录账号的权限 信息进行比对
         */
        for (Iterator<ConfigAttribute> it = configAttributes.iterator(); it.hasNext(); ) {
            //configAttributes集合的每一个ConfigAttribute对象
            ConfigAttribute cfa = it.next();

            String role = cfa.getAttribute();
            //两边都是对象集合只要匹配一个就可以了，就表示此用户可以通过
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (role.equals(authority.getAuthority())) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
}
