package com.cn.ecig.demo.region_listingDate_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.region_listingDate_rank.entity.RegionListingdateRank;
import com.cn.ecig.demo.region_listingDate_rank.mapper.RegionListingdateRankMapper;
import com.cn.ecig.demo.region_listingDate_rank.service.IRegionListingdateRankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-08-02
 */
@Service
public class RegionListingdateRankServiceImpl extends ServiceImpl<RegionListingdateRankMapper, RegionListingdateRank> implements IRegionListingdateRankService {
@Autowired
private RegionListingdateRankMapper regionListingdateRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String  res=regionListingdateRankMapper.selectOne(wrapper).getRank();
        return  res;
    }
}
