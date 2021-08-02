package com.cn.ecig.demo.industry_listingDate_rank.service;

import com.cn.ecig.demo.industry_listingDate_rank.entity.I2;
import com.cn.ecig.demo.industry_listingDate_rank.entity.IndustryListingdateRank;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
public interface IIndustryListingdateRankService extends IService<IndustryListingdateRank> {
String getRank(String code);
String getIndustry(String code);
//List<IndustryListingdateRank> getIndL(String industry);
int getAmmount(String industry);
}
