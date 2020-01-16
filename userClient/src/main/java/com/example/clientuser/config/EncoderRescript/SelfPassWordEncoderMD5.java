package com.example.clientuser.config.EncoderRescript;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/4
 * Time: 17:08
 * Description: No Description
 *
 * @author:ZhouRunLin
 */

/**
 * 重写本地MD5加密
 */
public class SelfPassWordEncoderMD5 implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        //charSequence ：用户输入的密码 == 原始密码 ：123456   charSequence:char数列
        return MD5Utils.encode((String) charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        /**
         * s-->之前加密后的密码  ， charSequence：原始密码
         */
        return s.equals(MD5Utils.encode((String) charSequence));
    }
}
