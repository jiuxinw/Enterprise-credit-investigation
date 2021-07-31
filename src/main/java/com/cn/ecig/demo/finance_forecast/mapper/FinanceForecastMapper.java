package com.cn.ecig.demo.finance_forecast.mapper;

import com.cn.ecig.demo.finance_forecast.entity.FinanceForecast;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguang
 * @since 2021-07-31
 */
public interface FinanceForecastMapper extends BaseMapper<FinanceForecast> {
    String getMax(String code,String month);
    String getMin(String code,String month);
}
