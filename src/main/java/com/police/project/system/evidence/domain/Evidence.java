package com.police.project.system.evidence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.police.framework.web.domain.BaseEntity;
import lombok.Data;


import java.util.Date;

/**
 * 物证表 sys_evidence
 *
 * @author police
 * @date 2019-03-13
 */
@Data
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    private Long sysUserId;

    private String auditMsg;
}
