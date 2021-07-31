package com.cn.ecig.demo.SysLog.service;

import com.cn.ecig.demo.SysLog.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-22
 */
public interface ISysLogService extends IService<SysLog> {
    void saveLog(SysLog sysLog);
    List<String> getParmsList(String name);
    Map<String,Integer> getHot();
    int getCount(String code);
}
