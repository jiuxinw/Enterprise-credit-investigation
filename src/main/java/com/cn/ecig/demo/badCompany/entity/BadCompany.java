package com.cn.ecig.demo.badCompany.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("badCompany")
public class BadCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司代码
     */
    private String code;

    /**
     * 公司名称
     */
    @TableField("caseName")
    private String caseName;

    /**
     * 所属行业
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 所属地区
     */
    @TableField("caseDate")
    private String caseDate;

    /**
     * 信用评分
     */
    @TableField("caseURL")
    private String caseURL;

    @TableField("caseId")
    private Integer caseId;


}
