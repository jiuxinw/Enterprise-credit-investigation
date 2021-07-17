package com.cn.ecig.demo.district.entity;

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
 * @since 2021-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区名字
     */
    @TableField("districtName")
    private String districtName;

    public String getAveDebts() {
        return aveDebts;
    }

    public void setAveDebts(String aveDebts) {
        this.aveDebts = aveDebts;
    }

    public String getAveCleanAssets() {
        return aveCleanAssets;
    }

    public void setAveCleanAssets(String aveCleanAssets) {
        this.aveCleanAssets = aveCleanAssets;
    }

    public String getAveAssets() {
        return aveAssets;
    }

    public void setAveAssets(String aveAssets) {
        this.aveAssets = aveAssets;
    }

    /**
     * 公司数量
     */
    @TableField("companyNum")
    private String companyNum;

    @TableField("goodNum")
    private String goodNum;

    @TableField("badNum")
    private String badNum;

    /**
     * 平均利润
     */
    @TableField("aveProfit")
    private String aveProfit;

    /**
     * 平均收入
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

    @TableId("districtId")
    private String districtId;

    @TableField("aveScore")
    private String aveScore;


}
