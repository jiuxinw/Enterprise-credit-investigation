package com.cn.ecig.demo.regionIndustry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.cn.ecig.demo.regionIndustry.entity.RegionIndustry;
import com.cn.ecig.demo.regionIndustry.mapper.RegionIndustryMapper;
import com.cn.ecig.demo.regionIndustry.service.IRegionIndustryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-26
 */
@Service
public class RegionIndustryServiceImpl extends ServiceImpl<RegionIndustryMapper, RegionIndustry> implements IRegionIndustryService {

@Autowired
private RegionIndustryMapper regionIndustryMapper;
    @Override
    public String getProfit(String industry, String region, String year) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("year",year);
        wrapper.eq("region_name",region);
        wrapper.eq("industry_name",industry);
        String res=regionIndustryMapper.selectOne(wrapper).getAveProfit();
        return res;
    }

    @Override
    public String getScoreByThree(String industry, String region, String year) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("aveScore");
        wrapper.eq("year",year);
        wrapper.eq("region_name",region);
        wrapper.eq("industry_name",industry);
        String res=regionIndustryMapper.selectOne(wrapper).getAveScore();
        return res;
    }
}
