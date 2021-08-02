package com.cn.ecig.demo.region_netProfit_rank.service;

import com.cn.ecig.demo.region_netProfit_rank.entity.RegionNetprofitRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IRegionNetprofitRankService extends IService<RegionNetprofitRank> {
    String getRank(String code);
}
