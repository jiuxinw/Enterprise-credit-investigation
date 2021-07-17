package com.cn.ecig.demo.region.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.region.entity.Region;
import com.cn.ecig.demo.region.mapper.RegionMapper;
import com.cn.ecig.demo.region.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> getRegionList() {
        List<Region> res=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
wrapper.select("name","aveProfit","aveIncome").orderByDesc("num");
wrapper.last("limit 5");
res=regionMapper.selectList(wrapper);
        return  res;
    }
}
