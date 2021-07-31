package com.cn.ecig.demo.finance_forecast.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.finance_forecast.entity.FinanceForecast;
import com.cn.ecig.demo.finance_forecast.mapper.FinanceForecastMapper;
import com.cn.ecig.demo.finance_forecast.service.IFinanceForecastService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-31
 */
@Service
public class FinanceForecastServiceImpl extends ServiceImpl<FinanceForecastMapper, FinanceForecast> implements IFinanceForecastService {
@Autowired
private FinanceForecastMapper financeForecastMapper;
    @Override
    public String getMax(String code,String month) {
return financeForecastMapper.getMax(code,month);
    }

    @Override
    public String getMin(String code,String month) {
        return financeForecastMapper.getMin(code, month);
    }
}
