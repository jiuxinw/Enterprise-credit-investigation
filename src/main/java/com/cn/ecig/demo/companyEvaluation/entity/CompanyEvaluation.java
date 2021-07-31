package com.cn.ecig.demo.companyEvaluation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguang
 * @since 2021-07-16
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
    @TableId("code")
    private String code;
    @TableField("adviceRatio")
private String adviceRatio;
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 综合信用评分
     */
    private Double score;

    /**
     * 信用等级
     */
    private String level;

    public String getAdviceRatio() {
        return adviceRatio;
    }

    public void setAdviceRatio(String adviceRatio) {
        this.adviceRatio = adviceRatio;
    }

    public CompanyEvaluation() {
    }

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
    @TableField("feedbackNum")
    private int feedbackNum;
//    @TableField("followNum")
//    private int followNum;

    public int getFeedbackNum() {
        return feedbackNum;
    }

    public void setFeedbackNum(int feedbackNum) {
        this.feedbackNum = feedbackNum;
    }
//
//    public int getFollowNum() {
//        return followNum;
//    }
//
//    public void setFollowNum(int followNum) {
//        this.followNum = followNum;
//    }
}
