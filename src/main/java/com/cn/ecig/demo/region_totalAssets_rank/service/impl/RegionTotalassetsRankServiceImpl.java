package com.cn.ecig.demo.region_totalAssets_rank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.region_totalAssets_rank.entity.RegionTotalassetsRank;
import com.cn.ecig.demo.region_totalAssets_rank.mapper.RegionTotalassetsRankMapper;
import com.cn.ecig.demo.region_totalAssets_rank.service.IRegionTotalassetsRankService;
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
public class RegionTotalassetsRankServiceImpl extends ServiceImpl<RegionTotalassetsRankMapper, RegionTotalassetsRank> implements IRegionTotalassetsRankService {
@Autowired
private RegionTotalassetsRankMapper regionTotalassetsRankMapper;
    @Override
    public String getRank(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.select("_rank");
        wrapper.eq("companyCode",code);
        String res=regionTotalassetsRankMapper.selectOne(wrapper).getRank();
        return res;
    }
}
