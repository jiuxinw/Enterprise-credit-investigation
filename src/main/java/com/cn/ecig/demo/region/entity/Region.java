package com.cn.ecig.demo.region.entity;

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
 * @since 2021-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域代号
     */
    @TableId("areaId")
    private String areaId;

    public String getAveIncome() {
        return aveIncome;
    }

    public void setAveIncome(String aveIncome) {
        this.aveIncome = aveIncome;
    }

    public String getAveProfit() {
        return aveProfit;
    }

    public void setAveProfit(String aveProfit) {
        this.aveProfit = aveProfit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    /**
     * 企业数量
     */
    private String num;

    /**
     * 良好记录企业数量
     */
    @TableField("goodNum")
    private String goodNum;

    /**
     * 不良记录企业数量
     */
    @TableField("badNum")
    private String badNum;

    /**
     * 区域平均信用评分
     */
    private String score;

    /**
     * 区域平均利润
     */
    @TableField("aveProfit")
    private String aveProfit;

    /**
     * 区域平均营收
     */
    @TableField("aveIncome")
    private String aveIncome;

    /**
     * 区域平均资产
     */
    @TableField("aveAssets")
    private String aveAssets;

    /**
     * 区域平均负债
     */
    @TableField("aveDebts")
    private String aveDebts;

    /**
     * 区域平均净资产
     */
    @TableField("aveCleanAssets")
    private String aveCleanAssets;


}
