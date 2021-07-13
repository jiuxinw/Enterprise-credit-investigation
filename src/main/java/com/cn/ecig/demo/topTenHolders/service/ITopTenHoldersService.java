package com.cn.ecig.demo.topTenHolders.service;

import com.cn.ecig.demo.topTenHolders.entity.TopTenHolders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface ITopTenHoldersService extends IService<TopTenHolders> {
    //获取前十大股东信息
   List<TopTenHolders>  getShareHoldeInfoByCode(String code);
}
