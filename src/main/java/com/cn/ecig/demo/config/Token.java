/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Token
 * Author:   liyou
 * Date:     2021/7/22 18:53
 * Description: token
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈token〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈token〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
package com.cn.ecig.demo.config;

public class Token {
    private String userId;
    private String token;

    public Token(String userId, String token) {
        this.userId=userId;
        this.token=token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
