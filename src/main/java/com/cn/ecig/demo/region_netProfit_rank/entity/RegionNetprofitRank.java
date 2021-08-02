package com.cn.ecig.demo.region_netProfit_rank.entity;

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
@TableName("region_netProfit_rank")
public class RegionNetprofitRank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("regionId")
    private String regionId;

    @TableField("regionName")
    private String regionName;
    @TableField("_rank")
    private String rank;

    @TableField("companyCode")
    private String companyCode;

    @TableField("companyName")
    private String companyName;

    @TableField("netProfit")
    private String netProfit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
