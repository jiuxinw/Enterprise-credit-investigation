package com.cn.ecig.demo.follows.service;

import com.cn.ecig.demo.follows.entity.Follows;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-21
 */
public interface IFollowsService extends IService<Follows> {
    //添加用户关注
    Follows insetOne(String code,String userName);

    //获取用户关注列表
    List<Follows> getComm(String userName);
}
