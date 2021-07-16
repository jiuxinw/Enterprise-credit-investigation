package com.cn.ecig.demo.finance.entity;

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
public class Finance implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 序号
     */
    private String id;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 年份
     */
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 公司代码
     */
    private String code;

    /**
     * 营业收入（元）
     */
    private String income;

    /**
     * 营业利润
     */
    private String profit;

    /**
     * 净利润
     */
    @TableField("netProfit")
    private String netProfit;

    /**
     * 未分配利润
     */
    @TableField("nonDistributeProfit")
    private String nonDistributeProfit;

    /**
     * 总资产
     */
    @TableField("totalAssets")
    private String totalAssets;

    /**
     * 净资产
     */
    @TableField("totalLiability")
    private String totalLiability;

    /**
     * 每股收益
     */
    @TableField("earningsPerShare")
    private String earningsPerShare;

    /**
     * 每股净资产
     */
    @TableField("netAssetsPerShare")
    private String netAssetsPerShare;

    /**
     * 净资产收益率
     */
    @TableField("netAssetsYield")
    private String netAssetsYield;

    @TableField("companyName")
    private String companyName;

    @TableField("netAssets")
    private String netAssets;


}
