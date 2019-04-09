package com.example.demo.com.gyx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 封装了四个级别的日志打印方法
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/9
 */

public class LoggerUtil {
    /**
     *
     * @param logclazz 日志对应的类
     * @param message 消息，可以是含参，也可以不含参数
     * @param parmeter 对于你message中通配符{}
     */
    public static void info(Class<?> logclazz, String message,String... parmeter){
        Logger logger = LoggerFactory.getLogger(logclazz);
        if(StringUtils.isEmpty(parmeter)){
            logger.info(message);
        }else{
            logger.info(message,parmeter);
        }
    }

    public static void debug(Class<?> logclazz, String message,String... parmeter){
        Logger logger = LoggerFactory.getLogger(logclazz);
        if(StringUtils.isEmpty(parmeter)){
            logger.debug(message);
        }else{
            logger.debug(message,parmeter);
        }
    }

    public static void error(Class<?> logclazz, String message,String... parmeter){
        Logger logger = LoggerFactory.getLogger(logclazz);
        if(StringUtils.isEmpty(parmeter)){
            logger.error(message);
        }else{
            logger.error(message,parmeter);
        }
    }

    public static void warn(Class<?> logclazz, String message,String... parmeter){
        Logger logger = LoggerFactory.getLogger(logclazz);
        if(StringUtils.isEmpty(parmeter)){
            logger.warn(message);
        }else{
            logger.warn(message,parmeter);
        }
    }
}
