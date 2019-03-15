package com.police.project.system.evidencecategory.service;

import com.police.project.system.evidencecategory.domain.EvidenceCategory;
import java.util.List;

/**
 * 分拣 服务层
 * 
 * @author police
 * @date 2019-03-15
 */
public interface IEvidenceCategoryService 
{
	/**
     * 查询分拣信息
     * 
     * @param categoryNum 分拣ID
     * @return 分拣信息
     */
	public EvidenceCategory selectEvidenceCategoryById(String categoryNum);
	
	/**
     * 查询分拣列表
     * 
     * @param evidenceCategory 分拣信息
     * @return 分拣集合
     */
	public List<EvidenceCategory> selectEvidenceCategoryList(EvidenceCategory evidenceCategory);
	
	/**
     * 新增分拣
     * 
     * @param evidenceCategory 分拣信息
     * @return 结果
     */
	public int insertEvidenceCategory(EvidenceCategory evidenceCategory);
	
	/**
     * 修改分拣
     * 
     * @param evidenceCategory 分拣信息
     * @return 结果
     */
	public int updateEvidenceCategory(EvidenceCategory evidenceCategory);
		
	/**
     * 删除分拣信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEvidenceCategoryByIds(String ids);
	
}
