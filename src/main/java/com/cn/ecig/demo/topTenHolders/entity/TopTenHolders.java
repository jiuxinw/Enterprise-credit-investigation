package com.cn.ecig.demo.topTenHolders.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("topTenHolders")
public class TopTenHolders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司代码
     */
    private String code;

    /**
     * 股东名称
     */
    private String name;

    /**
     * 截至日期
     */
    private String date;

    /**
     * 持股数
     */
    private String quantity;

    /**
     * 股东id
     */
    private String id;

    /**
     * 持股比例
     */
    private String ratio;


}
