package com.cn.ecig.demo.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("account")
@ApiModel("用户")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    public Account(Long phoneNumber, String userName, String password) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }
    public Account(){

    }
    /**
     * 手机号
     */
    @TableField("phoneNumber")
    @ApiModelProperty("手机号")
    private Long phoneNumber;

    /**
     * 用户昵称
     */
    @TableField("userName")
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    @ApiModelProperty("密码")
    private String password;

    @TableId(value = "aid", type = IdType.AUTO)
    @ApiModelProperty("用户id")
    private Integer aid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
