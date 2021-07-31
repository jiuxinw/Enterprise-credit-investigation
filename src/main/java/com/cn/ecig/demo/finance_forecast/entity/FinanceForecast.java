package com.cn.ecig.demo.finance_forecast.entity;

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
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FinanceForecast implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String year;

    private String month;

    @TableField("companyCode")
    private String companyCode;

    private String maxIncomeForecast;

    private String minIncomeForecast;


}
