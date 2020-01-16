package com.example.clientuser.utils;

import freemarker.ext.jsp.TaglibFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/12/31
 * Time: 13:55
 * Description: No Description
 * FreemarkerConfigurer 进行加载
 *
 * @author:ZhouRunLin
 */

/**
 * springSecurity标签的tld文件加载类
 */
@Configuration
public class ClassPathTldsLoader extends WebMvcConfigurerAdapter {
    @Autowired
    private FreeMarkerConfigurer configurer;
    @PostConstruct
    public void freeMarkerConfigurer() {
        List<String> tlds = new ArrayList<String>();
        tlds.add("/static/tags/security.tld");
        TaglibFactory taglibFactory = configurer.getTaglibFactory();
        taglibFactory.setClasspathTlds(tlds);
        if (taglibFactory.getObjectWrapper() == null) {
            taglibFactory.setObjectWrapper(configurer.getConfiguration().getObjectWrapper());
        }
    }

}
