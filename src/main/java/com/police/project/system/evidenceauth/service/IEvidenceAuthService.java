package com.police.project.system.evidenceauth.service;

import com.police.project.system.evidenceauth.domain.EvidenceAuth;
import java.util.List;

/**
 * 物证鉴定 服务层
 * 
 * @author police
 * @date 2019-03-15
 */
public interface IEvidenceAuthService 
{
	/**
     * 查询物证鉴定信息
     * 
     * @param authNum 物证鉴定ID
     * @return 物证鉴定信息
     */
	public EvidenceAuth selectEvidenceAuthById(String authNum);
	
	/**
     * 查询物证鉴定列表
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 物证鉴定集合
     */
	public List<EvidenceAuth> selectEvidenceAuthList(EvidenceAuth evidenceAuth);
	
	/**
     * 新增物证鉴定
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 结果
     */
	public int insertEvidenceAuth(EvidenceAuth evidenceAuth);
	
	/**
     * 修改物证鉴定
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 结果
     */
	public int updateEvidenceAuth(EvidenceAuth evidenceAuth);
		
	/**
     * 删除物证鉴定信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEvidenceAuthByIds(String ids);
	
}
