/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Company
 * Author:   liyou
 * Date:     2021/7/20 9:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/20
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/20
 * @since 1.0.0
 */
package com.cn.ecig.demo.companyBasicInfo.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class Company{
    private String code;

    public Company(CompanyBasicInfo companyBasicInfo){
        this.name=companyBasicInfo.getName();
        this.legalRepresentative=companyBasicInfo.getLegalRepresentative();
        this.industry=companyBasicInfo.getIndustry();
        this.code=companyBasicInfo.getCode();
        this.area=companyBasicInfo.getArea();
        this.transferMode=companyBasicInfo.getTransferMode();
    }
    private String name;
    /**
     * 所在地区
     */
    private String area;

    public String getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    /**
     * 法人代表
     */
    private String legalRepresentative;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 行业分类
     */
    private String industry;

    /**
     * 交易方式
     */
    @TableField("transferMode")
    private String transferMode;
}
