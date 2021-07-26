package com.cn.ecig.demo.footPrint.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.SysLog.entity.SysLog;
import com.cn.ecig.demo.SysLog.mapper.SysLogMapper;
import com.cn.ecig.demo.SysLog.service.ISysLogService;
import com.cn.ecig.demo.companyEvaluation.mapper.CompanyEvaluationMapper;
import com.cn.ecig.demo.footPrint.entity.FootPrint;
import com.cn.ecig.demo.footPrint.mapper.FootPrintMapper;
import com.cn.ecig.demo.footPrint.service.IFootPrintService;
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
 * @since 2021-07-23
 */
@Service
public class FootPrintServiceImpl extends ServiceImpl<FootPrintMapper, FootPrint> implements IFootPrintService {
    @Autowired
    private FootPrintMapper footPrintMapper;
@Autowired
private ISysLogService sysLogService;
    @Autowired
    private CompanyEvaluationMapper companyEvaluationMapper;
    @Override
    public List<FootPrint> getFootPrint(String name) {
        List<String> list=sysLogService.getParmsList(name);
           List<FootPrint> footPrintList=new ArrayList<>();
        for (int i = 0; i < list().size() ; i++) {
//        footPrintList.add( new FootPrint(companyEvaluationMapper.getBasicByCode(list.get(i))));
       footPrintMapper.insert(new FootPrint(companyEvaluationMapper.getBasicByCode(list.get(i))));
        }
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("userName",name);
        footPrintList=footPrintMapper.selectList(wrapper);
        System.out.println("footprint"+footPrintList);
        return footPrintList;
    }
}
