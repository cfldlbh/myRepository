package com.lbh.cfld.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Component
@Aspect
public class JumpViewBeforeAspect{
    private static final Logger log = Logger.getLogger(JumpViewBeforeAspect.class);
    private String jsSuffix = ".js";
    private String cssSuffix = ".css";
    /**
     * 设置js.css资源路径到request域中
     */
    @AfterReturning(returning = "rvt",pointcut = "execution(* com.lbh.cfld.controller.*Jump.*(..))")
    public void setSourceUrl(String rvt){
        log.info("controller返回的："+rvt);
        if(rvt!=null){
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes rq = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = rq.getRequest();
            String tomcatpath = request.getServletContext().getRealPath("/");
            log.info("request。getServletContext。get真实路径:"+tomcatpath);
            String serverName = request.getServerName();
            log.info("项目地址："+serverName);
            int serverPort = request.getServerPort();
            log.info("项目访问端口号:"+serverPort);
            String contextPath = request.getContextPath();
            log.info("项目路径:"+contextPath);
            StringBuffer stringBuffer = new StringBuffer("http://");
            stringBuffer.append(serverName);
            if(serverPort!=80){
                stringBuffer.append(":");
                stringBuffer.append(serverPort);
            }
            stringBuffer.append(contextPath);
            String prefix = stringBuffer.toString();
            int i = rvt.lastIndexOf("/");
            String directory = rvt.substring(0, i);
            String fileName = rvt.substring(i);

            //组装文件路径
            String jsFile = structureFilePath(prefix, "/js/"+directory, fileName, jsSuffix);
            String cssFile = structureFilePath(prefix, "/css/" + directory, fileName, cssSuffix);

            //检测文件是否存在

            Boolean jsFlag = checkFileExist(tomcatpath, contextPath, "js/" + directory, fileName, jsSuffix);
            Boolean cssFlag = checkFileExist(tomcatpath, contextPath, "css/" + directory, fileName, cssSuffix);
            if(jsFlag){
                request.setAttribute("jsFilePath",jsFile);
            }
            if(cssFlag){
                request.setAttribute("cssFilePath",cssFile);
            }
        }
    }
    public JumpViewBeforeAspect(){
        log.info("SPringmvc加载AOP切面进入到容器内");
    }
    public String structureFilePath(String prefix,String directory,String fileName,String suffix){
        StringBuffer ps = new StringBuffer(prefix);
        ps.append(directory);
        ps.append(fileName);
        ps.append(suffix);
        return ps.toString();
    }
    public Boolean checkFileExist(String tomcatName,String projectName,String directory,String fileName,String suffix){
        StringBuffer stringBuffer = new StringBuffer(tomcatName);
        StringBuffer append = stringBuffer.append(directory).append(fileName).append(suffix);
        File file = new File(append.toString().replace("/","\\"));
        return file.exists();
    }
}
