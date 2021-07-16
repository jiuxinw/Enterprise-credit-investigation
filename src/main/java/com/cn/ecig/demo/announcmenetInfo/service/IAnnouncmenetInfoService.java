package com.cn.ecig.demo.announcmenetInfo.service;

import com.cn.ecig.demo.announcmenetInfo.entity.AnnouncmenetInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
public interface IAnnouncmenetInfoService extends IService<AnnouncmenetInfo> {

    //13.获取企业详细信息
    List<AnnouncmenetInfo> getAnnounceByCode(String code);
}
