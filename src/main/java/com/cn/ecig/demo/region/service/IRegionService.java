package com.cn.ecig.demo.region.service;

import com.cn.ecig.demo.region.entity.Region;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
 */
public interface IRegionService extends IService<Region> {

    //获取地区平均利润和平均营收信息
    List<Region> getRegionList();
}
