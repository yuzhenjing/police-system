package com.police.project.system.evidencecategory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.police.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 分拣表 sys_evidence_category
 * 
 * @author police
 * @date 2019-03-15
 */
public class EvidenceCategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类别编号 */
	private String categoryNum;
	/** 物证编号 */
	private String eviNum;
	/** 凶器 */
	private String lethalWeapon;
	/** 药物 */
	private String toxicant;
	/** 掌纹 */
	private String palmPrint;
	/** 信件 */
	private String letters;
	/** 物证名称 */
	private String otherEvi;
	/** 鉴定时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public void setCategoryNum(String categoryNum) 
	{
		this.categoryNum = categoryNum;
	}

	public String getCategoryNum() 
	{
		return categoryNum;
	}
	public void setEviNum(String eviNum) 
	{
		this.eviNum = eviNum;
	}

	public String getEviNum() 
	{
		return eviNum;
	}
	public void setLethalWeapon(String lethalWeapon) 
	{
		this.lethalWeapon = lethalWeapon;
	}

	public String getLethalWeapon() 
	{
		return lethalWeapon;
	}
	public void setToxicant(String toxicant) 
	{
		this.toxicant = toxicant;
	}

	public String getToxicant() 
	{
		return toxicant;
	}
	public void setPalmPrint(String palmPrint) 
	{
		this.palmPrint = palmPrint;
	}

	public String getPalmPrint() 
	{
		return palmPrint;
	}
	public void setLetters(String letters) 
	{
		this.letters = letters;
	}

	public String getLetters() 
	{
		return letters;
	}
	public void setOtherEvi(String otherEvi) 
	{
		this.otherEvi = otherEvi;
	}

	public String getOtherEvi() 
	{
		return otherEvi;
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
            .append("categoryNum", getCategoryNum())
            .append("eviNum", getEviNum())
            .append("lethalWeapon", getLethalWeapon())
            .append("toxicant", getToxicant())
            .append("palmPrint", getPalmPrint())
            .append("letters", getLetters())
            .append("otherEvi", getOtherEvi())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
