package com.police.project.system.evidenceresult.service;

import java.util.List;

import com.police.project.system.evidenceresult.domain.EvidenceResult;
import com.police.project.system.evidenceresult.mapper.EvidenceResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.police.common.utils.text.Convert;

/**
 * 物证鉴定 服务层实现
 * 
 * @author police
 * @date 2019-03-15
 */
@Service
public class EvidenceResultServiceImpl implements IEvidenceResultService 
{
	@Autowired
	private EvidenceResultMapper evidenceResultMapper;

	/**
     * 查询物证鉴定信息
     * 
     * @param resultNum 物证鉴定ID
     * @return 物证鉴定信息
     */
    @Override
	public EvidenceResult selectEvidenceResultById(String resultNum)
	{
	    return evidenceResultMapper.selectEvidenceResultById(resultNum);
	}
	
	/**
     * 查询物证鉴定列表
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 物证鉴定集合
     */
	@Override
	public List<EvidenceResult> selectEvidenceResultList(EvidenceResult evidenceResult)
	{
	    return evidenceResultMapper.selectEvidenceResultList(evidenceResult);
	}
	
    /**
     * 新增物证鉴定
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 结果
     */
	@Override
	public int insertEvidenceResult(EvidenceResult evidenceResult)
	{
	    return evidenceResultMapper.insertEvidenceResult(evidenceResult);
	}
	
	/**
     * 修改物证鉴定
     * 
     * @param evidenceResult 物证鉴定信息
     * @return 结果
     */
	@Override
	public int updateEvidenceResult(EvidenceResult evidenceResult)
	{
	    return evidenceResultMapper.updateEvidenceResult(evidenceResult);
	}

	/**
     * 删除物证鉴定对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEvidenceResultByIds(String ids)
	{
		return evidenceResultMapper.deleteEvidenceResultByIds(Convert.toStrArray(ids));
	}
	
}
