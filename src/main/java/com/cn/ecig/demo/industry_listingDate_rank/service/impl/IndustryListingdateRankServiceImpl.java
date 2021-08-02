package com.cn.ecig.demo.industry_listingDate_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.industry_listingDate_rank.entity.I2;
import com.cn.ecig.demo.industry_listingDate_rank.entity.IndustryListingdateRank;
import com.cn.ecig.demo.industry_listingDate_rank.mapper.IndustryListingdateRankMapper;
import com.cn.ecig.demo.industry_listingDate_rank.service.IIndustryListingdateRankService;
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
 * @since 2021-08-02
 */
@Service
public class IndustryListingdateRankServiceImpl extends ServiceImpl<IndustryListingdateRankMapper, IndustryListingdateRank> implements IIndustryListingdateRankService {
@Autowired
private IndustryListingdateRankMapper industryListingdateRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String res=industryListingdateRankMapper.selectOne(wrapper).getRank();
        return res;
    }

    @Override
    public String getIndustry(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("industryName");
        wrapper.eq("companyCode",code);
        String res=industryListingdateRankMapper.selectOne(wrapper).getIndustryName();
        return res;
    }

    @Override
    public int getAmmount(String industry) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("industryName",industry);
        int res=industryListingdateRankMapper.selectCount(wrapper);
        return res;
    }

//    @Override
//    public List<IndustryListingdateRank> getIndL(String industry) {
//QueryWrapper wrapper=new QueryWrapper();
//wrapper.eq("")
//    }
}
