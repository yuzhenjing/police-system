package com.police.project.system.evidencecategory.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.police.project.system.evidencecategory.mapper.EvidenceCategoryMapper;
import com.police.project.system.evidencecategory.domain.EvidenceCategory;
import com.police.common.utils.text.Convert;

/**
 * 分拣 服务层实现
 * 
 * @author police
 * @date 2019-03-15
 */
@Service
public class EvidenceCategoryServiceImpl implements IEvidenceCategoryService 
{
	@Autowired
	private EvidenceCategoryMapper evidenceCategoryMapper;

	/**
     * 查询分拣信息
     * 
     * @param categoryNum 分拣ID
     * @return 分拣信息
     */
    @Override
	public EvidenceCategory selectEvidenceCategoryById(String categoryNum)
	{
	    return evidenceCategoryMapper.selectEvidenceCategoryById(categoryNum);
	}
	
	/**
     * 查询分拣列表
     * 
     * @param evidenceCategory 分拣信息
     * @return 分拣集合
     */
	@Override
	public List<EvidenceCategory> selectEvidenceCategoryList(EvidenceCategory evidenceCategory)
	{
	    return evidenceCategoryMapper.selectEvidenceCategoryList(evidenceCategory);
	}
	
    /**
     * 新增分拣
     * 
     * @param evidenceCategory 分拣信息
     * @return 结果
     */
	@Override
	public int insertEvidenceCategory(EvidenceCategory evidenceCategory)
	{
	    return evidenceCategoryMapper.insertEvidenceCategory(evidenceCategory);
	}
	
	/**
     * 修改分拣
     * 
     * @param evidenceCategory 分拣信息
     * @return 结果
     */
	@Override
	public int updateEvidenceCategory(EvidenceCategory evidenceCategory)
	{
	    return evidenceCategoryMapper.updateEvidenceCategory(evidenceCategory);
	}

	/**
     * 删除分拣对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEvidenceCategoryByIds(String ids)
	{
		return evidenceCategoryMapper.deleteEvidenceCategoryByIds(Convert.toStrArray(ids));
	}
	
}
