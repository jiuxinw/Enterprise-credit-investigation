package com.cn.ecig.demo.region_netProfit_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.region_netProfit_rank.entity.RegionNetprofitRank;
import com.cn.ecig.demo.region_netProfit_rank.mapper.RegionNetprofitRankMapper;
import com.cn.ecig.demo.region_netProfit_rank.service.IRegionNetprofitRankService;
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
public class RegionNetprofitRankServiceImpl extends ServiceImpl<RegionNetprofitRankMapper, RegionNetprofitRank> implements IRegionNetprofitRankService {
@Autowired
private RegionNetprofitRankMapper regionNetprofitRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String  res=regionNetprofitRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
