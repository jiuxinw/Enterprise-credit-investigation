package com.cn.ecig.demo.regionIndustry.service;

import com.cn.ecig.demo.regionIndustry.entity.RegionIndustry;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-26
 */
public interface IRegionIndustryService extends IService<RegionIndustry> {
    String getProfit(String industry,String region,String year);
    String  getScoreByThree(String industry,String region,String year);
}
