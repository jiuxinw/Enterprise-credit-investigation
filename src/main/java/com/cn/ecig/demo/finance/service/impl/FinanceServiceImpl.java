package com.cn.ecig.demo.finance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.entity.Finance;
import com.cn.ecig.demo.finance.mapper.FinanceMapper;
import com.cn.ecig.demo.finance.service.IFinanceService;
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
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance> implements IFinanceService {
@Autowired
private FinanceMapper financeMapper;
    @Override
    public List<Finance> getFinanceInfoByCode(String code) {
        List<Finance> result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
       result=financeMapper.selectList(wrapper);
      return result;
    }
}
