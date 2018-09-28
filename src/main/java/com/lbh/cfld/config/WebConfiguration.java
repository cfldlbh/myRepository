package com.lbh.cfld.config;

import com.lbh.cfld.shiroRealm.UserRealm;
import org.apache.log4j.Logger;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"com.lbh.cfld.controller","com.lbh.cfld.aop"})
public class WebConfiguration extends WebMvcConfigurerAdapter{
    private static final Logger log = Logger.getLogger(WebConfiguration.class);
    public WebConfiguration(){
        log.info("DispatcherServlet加载");
    }
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }


}
