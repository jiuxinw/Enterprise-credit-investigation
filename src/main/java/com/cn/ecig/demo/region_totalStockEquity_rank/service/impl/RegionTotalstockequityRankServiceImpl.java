package com.cn.ecig.demo.region_totalStockEquity_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.region_totalStockEquity_rank.entity.RegionTotalstockequityRank;
import com.cn.ecig.demo.region_totalStockEquity_rank.mapper.RegionTotalstockequityRankMapper;
import com.cn.ecig.demo.region_totalStockEquity_rank.service.IRegionTotalstockequityRankService;
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
public class RegionTotalstockequityRankServiceImpl extends ServiceImpl<RegionTotalstockequityRankMapper, RegionTotalstockequityRank> implements IRegionTotalstockequityRankService {
@Autowired
private RegionTotalstockequityRankMapper regionTotalstockequityRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String res=regionTotalstockequityRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
