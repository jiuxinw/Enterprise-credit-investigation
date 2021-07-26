package com.cn.ecig.demo.regionIndustry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("regionIndustry")
public class RegionIndustry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域×行业
     */
    @TableId("region_industry_ID")
    private String regionIndustryId;

    private String year;

    private String regionIndustryName;

    private String regionName;

    private String industryName;

    public String getAveProfit() {
        return aveProfit;
    }

    public String getAveScore() {
        return aveScore;
    }

    public void setAveScore(String aveScore) {
        this.aveScore = aveScore;
    }

    public void setAveProfit(String aveProfit) {
        this.aveProfit = aveProfit;
    }

    @TableField("companyNum")
    private String companyNum;

    @TableField("goodNum")
    private String goodNum;

    @TableField("badNum")
    private String badNum;

    @TableField("aveScore")
    private String aveScore;

    /**
     * 平均利润
     */
    @TableField("aveProfit")
    private String aveProfit;

    /**
     * 平均营收
     */
    @TableField("aveIncome")
    private String aveIncome;

    /**
     * 平均资产
     */
    @TableField("aveAssets")
    private String aveAssets;

    /**
     * 平均负债
     */
    @TableField("aveDebts")
    private String aveDebts;

    /**
     * 平均净资产
     */
    @TableField("aveCleanAssets")
    private String aveCleanAssets;


}
