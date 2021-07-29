package com.cn.ecig.demo.personal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Integer aid;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Personal(String phoneNumber, String headUrl, String gender, String address, String email) {
        this.phoneNumber = phoneNumber;
        this.headUrl = headUrl;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public Personal() {
    }

    public Personal(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 手机号
     */
    @TableField("phoneNumber")
    private String phoneNumber;

    /**
     * 头像url
     */
    @TableField("headUrl")
    private String headUrl;

    /**
     * 性别
     */
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;


}
