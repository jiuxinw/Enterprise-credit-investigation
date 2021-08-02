package com.cn.ecig.demo.industry_netProfit_rank.service;

import com.cn.ecig.demo.industry_netProfit_rank.entity.IndustryNetprofitRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IIndustryNetprofitRankService extends IService<IndustryNetprofitRank> {
    String getRank(String code);
}
