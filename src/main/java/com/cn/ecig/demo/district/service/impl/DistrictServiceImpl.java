package com.cn.ecig.demo.district.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.district.entity.District;
import com.cn.ecig.demo.district.mapper.DistrictMapper;
import com.cn.ecig.demo.district.service.IDistrictService;
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
 * @since 2021-07-17
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getRegionAssets() {
        List<District> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.orderByDesc("companyNum");
        result=districtMapper.selectList(wrapper);
        return  result;
    }
}
