package com.cn.ecig.demo.topTenHolders.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.topTenHolders.entity.TopTenHolders;
import com.cn.ecig.demo.topTenHolders.mapper.TopTenHoldersMapper;
import com.cn.ecig.demo.topTenHolders.service.ITopTenHoldersService;
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
 * @since 2021-07-13
 */
@Service
public class TopTenHoldersServiceImpl extends ServiceImpl<TopTenHoldersMapper, TopTenHolders> implements ITopTenHoldersService {
    @Autowired
    private TopTenHoldersMapper topTenHoldersMapper;

    @Override
    public List<TopTenHolders> getShareHoldeInfoByCode(String code) {
        List<TopTenHolders> result=new ArrayList<>();
        result=topTenHoldersMapper.selectList(new QueryWrapper<TopTenHolders>()
        .eq("code",code)
        .orderByDesc("ratio"));
        return result;
    }
}
