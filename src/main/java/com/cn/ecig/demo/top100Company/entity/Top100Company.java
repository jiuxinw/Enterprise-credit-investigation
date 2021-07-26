package com.cn.ecig.demo.top100Company.entity;

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
 * @since 2021-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("top100Company")
public class Top100Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("companyCode")
    private String companyCode;

    @TableField("companyName")
    private String companyName;

    private String region;

    @TableField("totalStockEquity")
    private String totalStockEquity;


}
