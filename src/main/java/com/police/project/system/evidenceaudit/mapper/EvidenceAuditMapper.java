package com.police.project.system.evidenceaudit.mapper;

import com.police.project.system.evidenceaudit.domain.EvidenceAudit;

import java.util.List;

/**
 * 物证审核 数据层
 * 
 * @author police
 * @date 2019-03-13
 */
public interface EvidenceAuditMapper 
{
	/**
     * 查询物证审核信息
     * 
     * @param auditId 物证审核ID
     * @return 物证审核信息
     */
	public EvidenceAudit selectEvidenceAuditById(Integer auditId);
	
	/**
     * 查询物证审核列表
     * 
     * @param evidenceAudit 物证审核信息
     * @return 物证审核集合
     */
	public List<EvidenceAudit> selectEvidenceAuditList(EvidenceAudit evidenceAudit);
	
	/**
     * 新增物证审核
     * 
     * @param evidenceAudit 物证审核信息
     * @return 结果
     */
	public int insertEvidenceAudit(EvidenceAudit evidenceAudit);
	
	/**
     * 修改物证审核
     * 
     * @param evidenceAudit 物证审核信息
     * @return 结果
     */
	public int updateEvidenceAudit(EvidenceAudit evidenceAudit);
	
	/**
     * 删除物证审核
     * 
     * @param auditId 物证审核ID
     * @return 结果
     */
	public int deleteEvidenceAuditById(Integer auditId);
	
	/**
     * 批量删除物证审核
     * 
     * @param auditIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteEvidenceAuditByIds(String[] auditIds);
	
}
