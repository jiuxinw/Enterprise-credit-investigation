package com.cn.ecig.demo.industry.service;

import com.cn.ecig.demo.industry.entity.Industry;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-17
 */
public interface IIndustryService extends IService<Industry> {
//获取指定年份的地区-行业信息
    List<Industry> getByFromAndTo(String from,String to);
    //获取对应行业的信息
    Industry getInfoByIndustry(String industry);
}
