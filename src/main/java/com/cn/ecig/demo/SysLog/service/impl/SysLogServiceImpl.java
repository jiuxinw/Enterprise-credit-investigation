package com.cn.ecig.demo.SysLog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.SysLog.entity.SysLog;
import com.cn.ecig.demo.SysLog.mapper.SysLogMapper;
import com.cn.ecig.demo.SysLog.service.ISysLogService;
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
 * @since 2021-07-22
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }

    @Override
    public List<String> getParmsList(String name) {
        List<String > list=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",name);
     List<SysLog> sysLogs =sysLogMapper.selectList(wrapper);
        for (SysLog s:sysLogs
             ) {
            if(s.getParams().length()==10) {
                list.add(s.getParams().substring(1,7));
            }
        }
        System.out.println(list);
        return list;


    }
}
