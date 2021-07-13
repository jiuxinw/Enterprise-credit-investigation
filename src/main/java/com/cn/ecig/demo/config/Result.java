/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Reult
 * Author:   liyou
 * Date:     2021/7/13 9:54
 * Description: 返回结果封装累
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈返回结果封装累〉
 *
 * @author liyou
 * @create 2021/7/13
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈返回结果封装累〉
 *
 * @author liyou
 * @create 2021/7/13
 * @since 1.0.0
 */
package com.cn.ecig.demo.config;

public class Result<T> {
    //返回信息
    private String msg;
    //数据是正常请求
    private  boolean success;
    //具体返回的数据
    private  T datail;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatail() {
        return datail;
    }

    public void setDatail(T datail) {
        this.datail = datail;
    }
}
