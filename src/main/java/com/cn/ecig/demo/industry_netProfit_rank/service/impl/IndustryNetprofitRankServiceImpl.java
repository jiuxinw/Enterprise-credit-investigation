package com.cn.ecig.demo.industry_netProfit_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.industry_netProfit_rank.entity.IndustryNetprofitRank;
import com.cn.ecig.demo.industry_netProfit_rank.mapper.IndustryNetprofitRankMapper;
import com.cn.ecig.demo.industry_netProfit_rank.service.IIndustryNetprofitRankService;
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
public class IndustryNetprofitRankServiceImpl extends ServiceImpl<IndustryNetprofitRankMapper, IndustryNetprofitRank> implements IIndustryNetprofitRankService {
@Autowired
private IndustryNetprofitRankMapper industryNetprofitRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String  res=industryNetprofitRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
