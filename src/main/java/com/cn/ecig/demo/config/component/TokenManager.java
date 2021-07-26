package com.cn.ecig.demo.config.component;
import com.cn.ecig.demo.config.Token;


/**
 * @author :liguang
 * @description:
 * @date :2021/7/22
 */
public interface TokenManager {
    public Token createToken(String userId);

    public boolean checkToken(Token token);

    public Token getToken(String authentication);

    public void deleteToken(String userId);
}
