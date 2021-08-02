package com.cn.ecig.demo.industry_totalStockEquity_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.industry_totalStockEquity_rank.entity.IndustryTotalstockequityRank;
import com.cn.ecig.demo.industry_totalStockEquity_rank.mapper.IndustryTotalstockequityRankMapper;
import com.cn.ecig.demo.industry_totalStockEquity_rank.service.IIndustryTotalstockequityRankService;
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
public class IndustryTotalstockequityRankServiceImpl extends ServiceImpl<IndustryTotalstockequityRankMapper, IndustryTotalstockequityRank> implements IIndustryTotalstockequityRankService {
@Autowired
private IndustryTotalstockequityRankMapper industryTotalstockequityRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String res=industryTotalstockequityRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
