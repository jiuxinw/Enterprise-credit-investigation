package com.cn.ecig.demo.executives.entity;

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
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Executives implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 高管id
     */
    private String id;

    /**
     * 公司代码
     */
    private String code;

    /**
     * 性别
     */
    private String gender;

    /**
     * 高管名称
     */
    private String name;

    /**
     * 职位
     */
    private String job;

    /**
     * 年龄
     */
    private String age;

    /**
     * 教育经历
     */
    private String education;

    /**
     * 薪水
     */
    private String salary;

    @TableField("companyName")
    private String companyName;


}
