package com.cn.ecig.demo.config.component;

import com.cn.ecig.demo.config.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
/**
 * @author :liguang
 * @description:
 * @date :2021/7/22
 */
@Component
public class RedisTokenManager implements TokenManager {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate  redis;

    @Autowired
    public void setRedis(@Qualifier("redisTemplate") RedisTemplate redis){
        this.redis=redis;
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public Token createToken(String userId) {
        String token= UUID.randomUUID().toString().replace("-","");
        Token model=new Token(userId,token);
        redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    @Override
    public boolean checkToken(Token model) {
        if(model==null)
            return false;
        ///
        Object token= redis.boundValueOps(model.getUserId()).get();
        if(token==null||!token.equals(model.getToken())){
            return false;
        }
        //校验成功后，延长token的过期时间
        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    @Override
    public Token getToken(String authentication) {
       if(authentication==null||authentication.length()==0){
           return null;
       }
       String[] params=authentication.split("_");
       if(params.length!=2){
           return null;
       }
       String userId=params[0];
       String token=params[1];
       return new Token(userId,token);
    }

    @Override
    public void deleteToken(String userId) {
        redis.delete(userId);
    }
}
