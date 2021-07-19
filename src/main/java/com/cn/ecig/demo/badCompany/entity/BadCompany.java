package com.cn.ecig.demo.badCompany.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.Api;
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
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("badCompany")
@ApiModel("失信企业排名信息")
public class BadCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司代码
     */
    @ApiModelProperty("公司代码")
    private String code;

    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    @TableField("caseName")
    private String caseName;

    /**
     * 所属行业
     */
    @ApiModelProperty("所属行业")
    @TableField("companyName")
    private String companyName;

    /**
     * 所属地区
     */
    @ApiModelProperty("所属地区")
    @TableField("caseDate")
    private String caseDate;

    public String getCaseURL() {
        return caseURL;
    }

    public void setCaseURL(String caseURL) {
        this.caseURL = caseURL;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 信用评分
     */
    @ApiModelProperty("信用评分")
    @TableField("caseURL")
    private String caseURL;

    @ApiModelProperty("序号")
    @TableField("caseId")
    private Integer caseId;


}
