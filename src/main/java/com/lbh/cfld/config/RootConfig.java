package com.lbh.cfld.config;

import com.lbh.cfld.domain.User;
import com.lbh.cfld.shiroRealm.UserRealm;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(value = "com.lbh.cfld.service",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig  {
    private static final Logger log = Logger.getLogger(RootConfig.class);
    public RootConfig(){
        log.info("ContextLoaderListener加载配置类");
    }
    @Bean
    public ComboPooledDataSource dataSource(@Value("${user}")String user,@Value("${password}") String password,@Value("${driver}") String driverClass,@Value("${url}")String url){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            log.debug("异常加载Spring应用空间中DataSource");
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        return  dataSource;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ComboPooledDataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("/sqlmapper/*.xml"));
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.lbh.cfld.dao");
        return mapperScannerConfigurer;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        HashMap<String, String> map = new HashMap<String, String>();
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/jump/user/Login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
