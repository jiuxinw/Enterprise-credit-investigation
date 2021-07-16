package com.cn.ecig.demo.announcmenetInfo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("announcmenetInfo")
public class AnnouncmenetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 公司代码
     */
    private String code;

    /**
     * 公司名
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 公共内容名
     */
    private String content;

    /**
     * 发布日期
     */
    private LocalDate idate;

    /**
     * 发布类型
     */
    private String type;

    /**
     * 文件url
     */
    @TableField("contentURL")
    private String contentURL;


}
