/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AuthToken
 * Author:   liyou
 * Date:     2021/7/16 19:10
 * Description: 自定义注解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈自定义注解〉
 *
 * @author liyou
 * @create 2021/7/16
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义注解〉
 *
 * @author liyou
 * @create 2021/7/16
 * @since 1.0.0
 */
package com.cn.ecig.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthToken {
}
