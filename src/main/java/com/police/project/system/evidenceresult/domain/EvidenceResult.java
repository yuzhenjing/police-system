package com.police.project.system.evidenceresult.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.police.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 物证鉴定表 sys_evidence_result
 * 
 * @author police
 * @date 2019-03-15
 */
public class EvidenceResult extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 鉴定编号 */
	private String resultNum;
	/** 物证编号 */
	private String eviNum;
	/** 结果信息 */
	private String resultMsg;
	/** 鉴定人 */
	private String resultUser;
	/** 掌纹 */
	private String palmPrint;
	/** 鉴定时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public void setResultNum(String resultNum) 
	{
		this.resultNum = resultNum;
	}

	public String getResultNum() 
	{
		return resultNum;
	}
	public void setEviNum(String eviNum) 
	{
		this.eviNum = eviNum;
	}

	public String getEviNum() 
	{
		return eviNum;
	}
	public void setResultMsg(String resultMsg) 
	{
		this.resultMsg = resultMsg;
	}

	public String getResultMsg() 
	{
		return resultMsg;
	}
	public void setResultUser(String resultUser) 
	{
		this.resultUser = resultUser;
	}

	public String getResultUser() 
	{
		return resultUser;
	}
	public void setPalmPrint(String palmPrint) 
	{
		this.palmPrint = palmPrint;
	}

	public String getPalmPrint() 
	{
		return palmPrint;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resultNum", getResultNum())
            .append("eviNum", getEviNum())
            .append("resultMsg", getResultMsg())
            .append("resultUser", getResultUser())
            .append("palmPrint", getPalmPrint())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
