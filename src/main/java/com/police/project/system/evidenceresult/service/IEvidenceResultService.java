package com.police.project.system.evidenceresult.service;


import com.police.project.system.evidenceresult.domain.EvidenceResult;

import java.util.List;

/**
 * 物证鉴定 服务层
 * 
 * @author police
 * @date 2019-03-15
 */
public interface IEvidenceResultService 
{
	/**
     * 查询物证鉴定信息
     * 
     * @param resultNum 物证鉴定ID
     * @return 物证鉴定信息
     */
	public EvidenceResult selectEvidenceResultById(String resultNum);
	
	/**
     * 查询物证鉴定列表
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 物证鉴定集合
     */
	public List<EvidenceResult> selectEvidenceResultList(EvidenceResult evidenceResult);
	
	/**
     * 新增物证鉴定
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 结果
     */
	public int insertEvidenceResult(EvidenceResult evidenceResult);
	
	/**
     * 修改物证鉴定
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 结果
     */
	public int updateEvidenceResult(EvidenceResult evidenceResult);
		
	/**
     * 删除物证鉴定信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEvidenceResultByIds(String ids);
	
}
