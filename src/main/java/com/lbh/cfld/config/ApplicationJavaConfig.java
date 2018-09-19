package com.lbh.cfld.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationJavaConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final Logger logger = Logger.getLogger(ApplicationJavaConfig.class);
    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.debug("加载spring容器");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.debug("加载springmvc配置");
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
}
}
