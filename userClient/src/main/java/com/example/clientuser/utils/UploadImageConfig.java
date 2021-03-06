package com.example.clientuser.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020/1/7
 * Time: 15:27
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Configuration
public class UploadImageConfig  extends WebMvcConfigurerAdapter {
    @Value("${kindeditor.save.path}")
    private String rootPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
         * 说明：增加虚拟路径(经过本人测试：在此处配置的虚拟路径，用springboot内置的tomcat时有效，
         * 用外部的tomcat也有效;所以用到外部的tomcat时不需在tomcat/config下的相应文件配置虚拟路径了,阿里云linux也没问题)
         */
       // registry.addResourceHandler("/fileUploadPath/image/**").addResourceLocations("file:"+rootPath);
        //阿里云(映射路径去除盘符)
        registry.addResourceHandler("/fileUploadPath/image/**").addResourceLocations("file:"+rootPath);
    }
}
