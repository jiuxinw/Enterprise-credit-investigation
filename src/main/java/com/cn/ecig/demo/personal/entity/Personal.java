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
        this.headUrl="data:image/png;base64,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";
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
