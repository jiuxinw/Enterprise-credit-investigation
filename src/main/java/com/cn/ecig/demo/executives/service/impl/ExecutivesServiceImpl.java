package com.cn.ecig.demo.executives.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.executives.entity.Executives;
import com.cn.ecig.demo.executives.mapper.ExecutivesMapper;
import com.cn.ecig.demo.executives.service.IExecutivesService;
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
public class ExecutivesServiceImpl extends ServiceImpl<ExecutivesMapper, Executives> implements IExecutivesService {
    @Autowired
    private ExecutivesMapper executivesMapper;

    @Override
    public List<Executives> queryExecLsitByCode(String code) {
   List<Executives>result=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("code",code);
        result=executivesMapper.selectList(wrapper);
        return result;
    }
}
