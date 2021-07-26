package com.cn.ecig.demo.follows.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.cn.ecig.demo.companyEvaluation.entity.Comp_three;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Follows implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关注id
     */
    private int aaid;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Follows(Comp_three comp_three, String  phoneNumber) {
    this.name=comp_three.getName();
    this.code= comp_three.getCode();
    this.phoneNumber=phoneNumber;
    }
    public Follows(){

    }

    /**
     * 用户
     */
    @TableField("phoneNumber")
    private String phoneNumber;

//    public String getUserName() {
//        return phoneNumber;
//    }
//
//    public void setUserName(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAid() {
        return aaid;
    }

    public void setAid(int aid) {
        this.aaid = aaid;
    }

    /**
     * 公司
     */
    private String code;

    /**
     * 公司名
     */
    private String name;


}
