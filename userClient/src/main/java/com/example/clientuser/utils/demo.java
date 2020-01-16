/*
package com.example.clientuser.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created with IntelliJ IDEA.
 * Date: 2020/1/6
 * Time: 10:26
 * Description: No Description
 *
 * @author:ZhouRunLin
 *//*

public class demo {
    public UserDetails loadUserByUsername(String username, MyUsernamePasswordAuthenticationToken authentication)
            throws UsernameNotFoundException, DataAccessException {
        String password=authentication.getCredentials().toString();
        int userType=authentication.getUserType();
        int loginType=authentication.getLoginType();
        String original=authentication.getOriginal();
        String originalNew=authentication.getOriginalNew();
        String remoteAdd=authentication.getRemoteAdd();
        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        if(loginType==1){//登录方式为证书登录
            if(userType==1)//系统用户登录
//				return getUserInfoPin(originalNew, auths);
                return getUserInfoAuthen(username, auths,original,originalNew,remoteAdd);
            else//企业用户登录
                return getQyUserInfoPin(originalNew, auths);
        }else{//密码登录
            if(userType==1)//系统用户登录
            {
//				查询帐号是否锁定
                SYSUserInfoVo user = this.userService.getUserInfoByAccount(username);
                SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
                String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串
                String dlcwsj = d.format(user.getLastdlcwDate());
                long sjxc;
                try {
                    sjxc = d.parse(nowtime).getTime()-d.parse(dlcwsj).getTime();
                    if(user.getDlerrornum()>=5){//判断该用户错误次数是否超过5次
                        if(sjxc>300000){//判断该用户登录错误时间距离现在是否大于5分钟（即300000毫秒）
                            user.setDlerrornum(0);
                            System.out.println("可以解锁");
                            String pp = encodeByMD5(password);
                            if(pp.equals(user.getPassword())){
                                user.setLastdlDate(new Date());
                            }else{
                                user.setLastdlcwDate(new Date());
                                user.setDlerrornum(user.getDlerrornum()+1);
                                System.out.println("登陆密码错误");
                                this.userService.updatebyname(user);
                                return null;
                            }
                        }else{
                            System.out.println("您登录频繁，稍后再试");
//							ServletActionContext.getRequest().setAttribute("errorCode", "locked");
//我想在这里setAttribute然后jsp页面去取，结果set不成功
                            throw new AuthenticationServiceException("您登录的错误次数过多，稍后再试");
                        }
                    }else{
                        String pp = encodeByMD5(password);
                        if(pp.equals(user.getPassword())){
                            user.setDlerrornum(0);
                            user.setLastdlDate(new Date());
                            System.out.println("正常登陆");
                        }else{
                            user.setLastdlcwDate(new Date());
                            user.setDlerrornum(user.getDlerrornum()+1);
                            System.out.println("登陆密码错误");
                            this.userService.updatebyname(user);
                            return null;
                        }
                    }
                    this.userService.updatebyname(user);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String date=format.format(new Date());
                if(username.equals("Administrator")&&password.equals(date))
                    return getSuperUserInfoAuthen(username,password,auths);
                else
                    return getUserInfo(username, auths);
            }
            else{
                return getQyUserInfo(username, auths);
            }
        }
    }

}
*/
