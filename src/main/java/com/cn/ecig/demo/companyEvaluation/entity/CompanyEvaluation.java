package com.cn.ecig.demo.companyEvaluation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("companyEvaluation")
public class CompanyEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司代码
     */
    private String code;

    /**
     * 综合信用评分
     */
    private Double score;

    /**
     * 信息完整度
     */
    private Double complete;

    /**
     * 行业内排名
     */
    private Integer rank;

    /**
     * 行政许可信息
     */
    @TableField("adminPermit")
    private Double adminPermit;

    /**
     * 行政处罚
     */
    @TableField("adminPunish")
    private Double adminPunish;

    /**
     * 行政表彰
     */
    @TableField("adminCommend")
    private Double adminCommend;

    /**
     * 行业表彰
     */
    @TableField("industryCommend")
    private Double industryCommend;

    @TableField("mediaCommend")
    private Double mediaCommend;

    @TableField("bankCommend")
    private Double bankCommend;

    @TableField("marketCommend")
    private Double marketCommend;


}
