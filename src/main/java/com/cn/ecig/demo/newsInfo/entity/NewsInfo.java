package com.cn.ecig.demo.newsInfo.entity;

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
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("newsInfo")
public class NewsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 关联公司代码
     */
    private String code;

    /**
     * 公司名
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 公司标题
     */
    private String title;

    /**
     * 发布日期
     */
    private LocalDate idate;

    /**
     * 新闻来源
     */
    private String source;

    /**
     * 新闻url
     */
    @TableField("linkURL")
    private String linkURL;

    /**
     * 图片链接
     */
    private String pic;
@TableField("regionName")
private String regionName;
    @TableField("keyword")
private String keyword;
}
