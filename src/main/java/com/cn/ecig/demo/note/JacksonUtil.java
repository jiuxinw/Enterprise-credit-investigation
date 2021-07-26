/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: JacksonUtil
 * Author:   liyou
 * Date:     2021/7/22 19:50
 * Description: json工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈json工具类〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈json工具类〉
 *
 * @author liyou
 * @create 2021/7/22
 * @since 1.0.0
 */
package com.cn.ecig.demo.note;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JacksonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private JacksonUtil() {

    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * javaBean、列表数组转换为json字符串
     */
    public static String obj2json(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * json 转JavaBean
     */

    public static <T> T json2pojo(String jsonString, Class<T> clazz) throws Exception {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.readValue(jsonString, clazz);
    }

    /**
     * json字符串转换为map
     */
    public static <T> Map<String, Object> json2map(String jsonString) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, Map.class);
    }
}
