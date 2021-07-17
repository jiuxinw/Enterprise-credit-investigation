package com.cn.ecig.demo.industry.entity;

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
public class Industry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行业代号
     */
    @TableId("industryId")
    private String industryId;

    /**
     * 企业数量
     */
    private String num;

    /**
     * 良好记录企业数量
     */
    private String goodnum;

    /**
     * 不良记录企业数量
     */
    @TableField("badNum")
    private String badNum;

    /**
     * 行业平均信用评分
     */
    private String score;

    /**
     * 行业平均利润
     */
    @TableField("aveProfit")
    private String aveProfit;

    /**
     * 行业平均应收
     */
    @TableField("aveIncome")
    private String aveIncome;

    /**
     * 行业平均资产
     */
    @TableField("aveAssets")
    private String aveAssets;

    /**
     * 行业平均负债
     */
    @TableField("aveDebts")
    private String aveDebts;

    /**
     * 行业平均净资产
     */
    @TableField("aveCleanAssets")
    private String aveCleanAssets;

    private String name;

    private String year;

    @TableField("ID")
    private String id;


}
