package com.cn.ecig.demo.config.component.annotation;

import com.cn.ecig.demo.account.entity.Account;
import com.cn.ecig.demo.account.service.IAccountService;
import com.cn.ecig.demo.config.component.*;
import com.cn.ecig.demo.config.component.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
/**
 * @author :liguang
 * @description:
 * @date :2021/7/22
 */
//@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private IAccountService accountService;

    @Override
    public boolean supportsParameter (MethodParameter parameter) {
        // 如果参数类型是 User 并且有 CurrentUser 注解则支持
        if ((parameter.getParameterType ().isAssignableFrom (Account.class))
                && parameter.hasParameterAnnotation (CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Integer currentUserId=(Integer) webRequest.getAttribute(Constants.CURRENT_USER_ID,RequestAttributes.SCOPE_REQUEST);
        System.out.println("test"+webRequest.getAttribute(Constants.CURRENT_USER_ID,RequestAttributes.SCOPE_REQUEST));

        if (currentUserId !=null) {
            // 从数据库中查询并返回
            return accountService.getAccountById(currentUserId);
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
    }
}
