package com.cn.ecig.demo.finance_forecast.service;

import com.cn.ecig.demo.finance_forecast.entity.FinanceForecast;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-31
 */
public interface IFinanceForecastService extends IService<FinanceForecast> {

    //
    String getMax(String code,String month);
    String getMin(String code,String month);
}
