package com.police.project.system.evidenceauth.domain;

import com.police.framework.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物证鉴定表 sys_evidence_auth
 *
 * @author police
 * @date 2019-03-15
 */
@Data
public class EvidenceAuth extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 鉴定编号
     */
    private String authNum;
    /**
     * 物证编号
     */
    private String eviNum;
    /**
     * 鉴定信息
     */
    private String authMsg;
    /**
     * 鉴定人
     */
    private String authUser;
    /**
     * 鉴定时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 物证名称
     */
    private String eviName;
    /**
     * 受理状态
     */
    private Integer authStatus;
    
}
