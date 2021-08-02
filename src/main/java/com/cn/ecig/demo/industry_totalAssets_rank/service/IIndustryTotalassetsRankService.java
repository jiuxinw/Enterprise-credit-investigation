package com.cn.ecig.demo.industry_totalAssets_rank.service;

import com.cn.ecig.demo.industry_totalAssets_rank.entity.IndustryTotalassetsRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IIndustryTotalassetsRankService extends IService<IndustryTotalassetsRank> {
    String getRank(String code);
}
