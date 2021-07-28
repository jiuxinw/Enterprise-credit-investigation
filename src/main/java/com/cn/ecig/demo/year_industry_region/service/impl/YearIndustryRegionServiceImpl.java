package com.cn.ecig.demo.year_industry_region.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.year_industry_region.entity.YearIndustryRegion;
import com.cn.ecig.demo.year_industry_region.mapper.YearIndustryRegionMapper;
import com.cn.ecig.demo.year_industry_region.service.IYearIndustryRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
@Service
public class YearIndustryRegionServiceImpl extends ServiceImpl<YearIndustryRegionMapper, YearIndustryRegion> implements IYearIndustryRegionService {
@Autowired
private YearIndustryRegionMapper yearIndustryRegionMapper;

    @Override
    public List<YearIndustryRegion> getByYearAndIndu(String from, String to, String Industry) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("industry",Industry);
        wrapper.between("year",from,to);
        List<YearIndustryRegion>list= yearIndustryRegionMapper.selectList(wrapper);
        return list;
    }
}
