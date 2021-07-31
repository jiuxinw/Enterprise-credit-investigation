/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Cth
 * Author:   liyou
 * Date:     2021/7/31 11:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/31
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/31
 * @since 1.0.0
 */
package com.cn.ecig.demo.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class Cth {
    /**
     * 序号
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户名
     */
    @TableField("phoneNumber")
    private String phoneNumber;
private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Cth(Comment comment,String  companyName) {
        this.phoneNumber =comment.getPhoneNumber();
        this.companyName = companyName;
        this.rate = comment.getRate();
        this.context = comment.getContext();
        this.companyCode = comment.getCompanyCode();
        this.udate = comment.getUdate();
        this.status = comment.getStatus();
    }


    public Cth() {
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    /**
     * 打分（0-5）
     */
    private int rate;

    /**
     * 内容
     */
    private String context;

    /**
     * 公司代码
     */
    @TableField("companyCode")
    private String companyCode;

    @TableField("udate")
    private String udate;
    @TableField("status")
    private String status;

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
