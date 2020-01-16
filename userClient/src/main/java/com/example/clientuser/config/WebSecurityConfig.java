package com.example.clientuser.config;

import com.example.clientuser.config.EncoderRescript.SelfPassWordEncoderFactories;
import com.example.clientuser.utils.MyAuthenctiationFailureHandler;
import com.example.clientuser.utils.MyAuthenctiationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/4
 * Time: 17:28
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
//静态资源也会访问Access的问题
@Configuration
@EnableWebSecurity  //开启SpringSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * security 权限设置
     *
     * @param http
     * @throws Exception
     */
    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
    @Autowired
    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/User/login")
                .successHandler(myAuthenctiationSuccessHandler)
                .failureHandler(myAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/User/login").permitAll()//允许所有人访问登录页面
                .antMatchers("/vendor/**", "/img/**", "/http/**", "/css/**", "/js/**", "/https/", "/utf8-jsp/**",
                        "/fileUploadPath/image/**", "/File/**", "/fileUploadPath/**", "/webjars/**", "/fonts/**", "/User/register", "/User/toRegister/success", "/User/toRegister/error", "/User/goto/register",
                        "/User/toLogin/error","/User/checkRegisterUname",
                        "http://www.springframework.org/security/tags"
                ).permitAll()
                //所有请求（点击）都要执行access()方法
                .anyRequest().access("@authService.canAccess(request,authentication)")
        ;
        /**
         * Spring Security 4.0之后，引入了CSRF，默认状态为开启。CSRF和RESTful技术有冲突。
         * CSRF默认支持的方法： GET|HEAD|TRACE|OPTIONS，不支持POST。CSRF（Cross-site request
         * forgery跨站请求伪造，也被称为“One Click Attack” 或者Session Riding，攻击方通过伪造用户请求访问受信任站点。
         */
        http.csrf().disable(); //取消安全认证：防止跨站提交攻 击
        http.headers().frameOptions().sameOrigin();  //security 4以上，会默认吧ifame进行设置成‘DENY',禁止任何跨域：因此，稍加一行代码就可以把这个功能去掉了：

        /**
         * 注销配置
         * logoutUrl触发注销操作的URL
         * /logout  默认退出地址
         */
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/User/goto/login");
    }

    /**
     * @Bean 明确地指示了一种方法，什么方法呢——>产生一个bean的方法，并且把产生的Bean交给Spring容器管理
     * 加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return SelfPassWordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
