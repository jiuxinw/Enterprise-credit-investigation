package com.cn.ecig.demo.region_totalAssets_rank.service;

import com.cn.ecig.demo.region_totalAssets_rank.entity.RegionTotalassetsRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IRegionTotalassetsRankService extends IService<RegionTotalassetsRank> {
    String getRank(String code);
}
