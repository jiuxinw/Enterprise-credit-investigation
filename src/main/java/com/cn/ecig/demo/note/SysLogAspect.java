/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: SysLogAspect
 * Author:   liyou
 * Date:     2021/7/22 19:51
 * Description: 系统日志：切面处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈系统日志：切面处理类〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈系统日志：切面处理类〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
package com.cn.ecig.demo.note;

import com.cn.ecig.demo.SysLog.entity.SysLog;
import com.cn.ecig.demo.SysLog.service.ISysLogService;
import com.cn.ecig.demo.account.mapper.AccountMapper;
import com.cn.ecig.demo.account.service.IAccountService;
import com.cn.ecig.demo.account.service.impl.AccountServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.aop.*;
import javax.servlet.http.HttpServletRequest;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.lang.reflect.Method;
import java.util.Date;
import com.cn.ecig.demo.note.Operation;
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private AccountServiceImpl accountService;
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.cn.ecig.demo.note.Operation)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();


        //获取操作
        Operation operation = method.getAnnotation(Operation.class);
        if (operation != null) {
            String value = operation.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();

        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = null;
        try {
            params = JacksonUtil.obj2json(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sysLog.setParams(params);

//        //请求的时间
//        sysLog.setDate(new Date());
//
//        //获取用户名
//        Neo4jProperties.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            sysLog.setUsername(authentication.getName());
//        }
        if(accountService.N!=null&&accountService.N.length()!=0){
        sysLog.setUsername(accountService.N);
        }
//
//        //获取用户ip地址
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getRequest();
//        sysLog.setIp(IpAdrressUtil.getIpAdrress(request));

        //调用service保存SysLog实体类到数据库
        sysLogService.saveLog(sysLog);
    }
}
