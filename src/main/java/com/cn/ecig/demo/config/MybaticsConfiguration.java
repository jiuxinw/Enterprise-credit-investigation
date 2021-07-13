/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MybaticsConfiguration
 * Author:   liyou
 * Date:     2021/6/30 9:29
 * Description: 配置文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈配置文件〉
 *
 * @author liyou
 * @create 2021/6/30
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈配置文件〉
 *
 * @author liyou
 * @create 2021/6/30
 * @since 1.0.0
 */
package com.cn.ecig.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cn.ecig.demo.*.mapper")
public class MybaticsConfiguration {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
