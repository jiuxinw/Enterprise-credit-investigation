/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Cfinal
 * Author:   liyou
 * Date:     2021/7/30 16:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/30
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/30
 * @since 1.0.0
 */
package com.cn.ecig.demo.companyBasicInfo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cn.ecig.demo.comment.service.ICommentService;
import com.cn.ecig.demo.companyEvaluation.entity.CompanyEvaluation;
import com.cn.ecig.demo.companyEvaluation.service.ICompanyEvaluationService;
import com.cn.ecig.demo.follows.service.IFollowsService;
import org.springframework.beans.factory.annotation.Autowired;

public class Cfinal {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IFollowsService followsService;
    @Autowired
    private ICompanyEvaluationService companyEvaluationService;
    private String code;
    private String shortName;
    public Cfinal(CompanyBasicInfo companyBasicInfo
//            , int feedbackNum,int followNum
    ){
        this.shortName=companyBasicInfo.getShortName();
        this.name=companyBasicInfo.getName();
        this.legalRepresentative=companyBasicInfo.getLegalRepresentative();
        this.industry=companyBasicInfo.getIndustry();
        this.code=companyBasicInfo.getCode();
        this.area=companyBasicInfo.getArea();
        this.transferMode=companyBasicInfo.getTransferMode();
//this.feedbackNum=feedbackNum;
//this.followNum=followNum;
;
    }
    private String name;
    /**
     * 所在地区
     */
    private String area;

    public int getFeedbackNum() {
        return feedbackNum;
    }

    public void setFeedbackNum(int feedbackNum) {
        this.feedbackNum = feedbackNum;
    }

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public String getShortName() {
        return shortName;
    }
    private int feedbackNum;
    private int followNum;
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    private int commentNum;
    private int followsNum;
    public String getTransferMode() {
        return transferMode;
    }

    public int getHotPo() {
        return hotPo;
    }

    public void setHotPo(int hotPo) {
        this.hotPo = hotPo;
    }

    public int getSearchedNum() {
        return searchedNum;
    }

    public void setSearchedNum(int searchedNum) {
        this.searchedNum = searchedNum;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getFollowsNum() {
        return followsNum;
    }

    public void setFollowsNum(int followsNum) {
        this.followsNum = followsNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    /**
     * 法人代表
     */
    private String legalRepresentative;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 行业分类
     */
    private String industry;
private int hotPo;
private int searchedNum;
private double score;
    /**
     * 交易方式
     */
    @TableField("transferMode")
    private String transferMode;
}
