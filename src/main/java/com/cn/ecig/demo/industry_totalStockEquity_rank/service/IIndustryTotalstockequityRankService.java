package com.cn.ecig.demo.industry_totalStockEquity_rank.service;

import com.cn.ecig.demo.industry_totalStockEquity_rank.entity.IndustryTotalstockequityRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IIndustryTotalstockequityRankService extends IService<IndustryTotalstockequityRank> {
    String getRank(String code);
}
