package com.police.project.system.evidence.domain;

import com.police.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物证表 sys_evidence
 *
 * @author police
 * @date 2019-03-13
 */
public class Evidence extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 物证编号
     */
    private String eviNum;
    /**
     * 物证名称
     */
    private String eviName;
    /**
     * 勘查人员
     */
    private String eviUser;
    /**
     * 案件名称
     */
    private String caseName;
    /**
     * 物证个数
     */
    private Integer eviCount;
    /**
     * 事件时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 物证描述
     */
    private String eviDesc;
    /**
     * 物证状态
     */
    private Integer eviStatus;
    /**
     * 记录员
     */
    private Integer sysUserId;

    public void setEviNum(String eviNum) {
        this.eviNum = eviNum;
    }

    public String getEviNum() {
        return eviNum;
    }

    public void setEviName(String eviName) {
        this.eviName = eviName;
    }

    public String getEviName() {
        return eviName;
    }

    public void setEviUser(String eviUser) {
        this.eviUser = eviUser;
    }

    public String getEviUser() {
        return eviUser;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setEviCount(Integer eviCount) {
        this.eviCount = eviCount;
    }

    public Integer getEviCount() {
        return eviCount;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setEviDesc(String eviDesc) {
        this.eviDesc = eviDesc;
    }

    public String getEviDesc() {
        return eviDesc;
    }

    public void setEviStatus(Integer eviStatus) {
        this.eviStatus = eviStatus;
    }

    public Integer getEviStatus() {
        return eviStatus;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "eviNum='" + eviNum + '\'' +
                ", eviName='" + eviName + '\'' +
                ", eviUser='" + eviUser + '\'' +
                ", caseName='" + caseName + '\'' +
                ", eviCount=" + eviCount +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", eviDesc='" + eviDesc + '\'' +
                ", eviStatus=" + eviStatus +
                ", sysUserId=" + sysUserId +
                '}';
    }
}
