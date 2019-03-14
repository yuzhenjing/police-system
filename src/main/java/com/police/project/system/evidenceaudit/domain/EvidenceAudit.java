package com.police.project.system.evidenceaudit.domain;

import com.police.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物证审核表 sys_evidence_audit
 *
 * @author police
 * @date 2019-03-13
 */
public class EvidenceAudit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 审核编号
     */
    private Integer auditId;
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
     * 审核状态
     */
    private Integer auditStatus;
    /**
     * 审核员
     */
    private String auditUser;
    /**
     * 审核信息
     */
    private String auditMsg;

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getAuditId() {
        return auditId;
    }

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

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg;
    }

    public String getAuditMsg() {
        return auditMsg;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("auditId", getAuditId())
                .append("eviNum", getEviNum())
                .append("eviName", getEviName())
                .append("eviUser", getEviUser())
                .append("caseName", getCaseName())
                .append("eviCount", getEviCount())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .append("eviDesc", getEviDesc())
                .append("auditStatus", getAuditStatus())
                .append("auditUser", getAuditUser())
                .append("auditMsg", getAuditMsg())
                .toString();
    }
}
