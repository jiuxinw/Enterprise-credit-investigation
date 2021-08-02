package com.cn.ecig.demo.industry_totalStockEquity_rank.entity;

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
 * @since 2021-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("industry_totalStockEquity_rank")
public class IndustryTotalstockequityRank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("industryId")
    private String industryId;

    @TableField("industryName")
    private String industryName;
    @TableField("_rank")
    private String rank;

    @TableField("companyCode")
    private String companyCode;

    @TableField("companyName")
    private String companyName;

    @TableField("totalStockEquity")
    private String totalStockEquity;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
