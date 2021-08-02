package com.cn.ecig.demo.region_listingDate_rank.service;

import com.cn.ecig.demo.region_listingDate_rank.entity.RegionListingdateRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IRegionListingdateRankService extends IService<RegionListingdateRank> {
    String getRank(String code);
}
