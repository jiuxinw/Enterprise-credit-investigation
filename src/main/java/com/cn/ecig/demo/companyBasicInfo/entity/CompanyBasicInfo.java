package com.cn.ecig.demo.companyBasicInfo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("companyBasicInfo")
public class CompanyBasicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司代码
     */
    @TableId("code")
    private String code;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 英文名称
     */
    @TableField("englishName")
    private String englishName;

    /**
     * 公司简称
     */
    @TableField("shortName")
    private String shortName;

    /**
     * 所在地区
     */
    private String area;

    /**
     * 曾用证券简称
     */
    private String namehis;

    /**
     * 是否具有表决权差异安排
     */
    @TableField("CYHBJQ")
    private String cyhbjq;

    /**
     * 法人代表
     */
    @TableField("legalRepresentative")
    private String legalRepresentative;

    /**
     * 公司董秘
     */
    private String secretaries;

    /**
     * 行业分类
     */
    private String industry;

    /**
     * 挂牌日趋
     */
    @TableField("listingDate")
    private String listingDate;

    /**
     * 总股本
     */
    @TableField("totalStockEquity")
    private String totalStockEquity;

    /**
     * 注册地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 公司电话
     */
    private String phone;

    /**
     * 公司传真
     */
    private String fax;

    /**
     * 公司地址
     */
    private String website;

    /**
     * 主办券商
     */
    private String broker;

    /**
     * ISIN编码
     */
    @TableField("ISIN")
    private String isin;

    /**
     * 交易方式
     */
    @TableField("transferMode")
    private String transferMode;

    /**
     * 邮箱
     */
    private String email;


}
