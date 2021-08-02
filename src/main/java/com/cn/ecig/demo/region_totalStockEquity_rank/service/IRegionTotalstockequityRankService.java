package com.cn.ecig.demo.region_totalStockEquity_rank.service;

import com.cn.ecig.demo.region_totalStockEquity_rank.entity.RegionTotalstockequityRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IRegionTotalstockequityRankService extends IService<RegionTotalstockequityRank> {
    String getRank(String code);
}
