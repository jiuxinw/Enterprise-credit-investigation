package com.cn.ecig.demo.top100Company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.top100Company.entity.Top100Company;
import com.cn.ecig.demo.top100Company.mapper.Top100CompanyMapper;
import com.cn.ecig.demo.top100Company.service.ITop100CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-24
 */
@Service
public class Top100CompanyServiceImpl extends ServiceImpl<Top100CompanyMapper, Top100Company> implements ITop100CompanyService {
@Autowired
private Top100CompanyMapper top100CompanyMapper;

    @Override
    public int getNumByProvince(String province) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("region",province);
        int res=top100CompanyMapper.selectCount(wrapper);
        return res;
    }
}
