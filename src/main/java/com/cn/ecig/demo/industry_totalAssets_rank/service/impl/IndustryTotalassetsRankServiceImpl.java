package com.cn.ecig.demo.industry_totalAssets_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.industry_totalAssets_rank.entity.IndustryTotalassetsRank;
import com.cn.ecig.demo.industry_totalAssets_rank.mapper.IndustryTotalassetsRankMapper;
import com.cn.ecig.demo.industry_totalAssets_rank.service.IIndustryTotalassetsRankService;
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
public class IndustryTotalassetsRankServiceImpl extends ServiceImpl<IndustryTotalassetsRankMapper, IndustryTotalassetsRank> implements IIndustryTotalassetsRankService {
@Autowired
private IndustryTotalassetsRankMapper industryTotalassetsRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String res=industryTotalassetsRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
