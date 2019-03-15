package com.police.project.system.evidenceauth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.police.project.system.evidenceauth.mapper.EvidenceAuthMapper;
import com.police.project.system.evidenceauth.domain.EvidenceAuth;
import com.police.common.utils.text.Convert;

/**
 * 物证鉴定 服务层实现
 * 
 * @author police
 * @date 2019-03-15
 */
@Service
public class EvidenceAuthServiceImpl implements IEvidenceAuthService 
{
	@Autowired
	private EvidenceAuthMapper evidenceAuthMapper;

	/**
     * 查询物证鉴定信息
     * 
     * @param authNum 物证鉴定ID
     * @return 物证鉴定信息
     */
    @Override
	public EvidenceAuth selectEvidenceAuthById(String authNum)
	{
	    return evidenceAuthMapper.selectEvidenceAuthById(authNum);
	}
	
	/**
     * 查询物证鉴定列表
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 物证鉴定集合
     */
	@Override
	public List<EvidenceAuth> selectEvidenceAuthList(EvidenceAuth evidenceAuth)
	{
	    return evidenceAuthMapper.selectEvidenceAuthList(evidenceAuth);
	}
	
    /**
     * 新增物证鉴定
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 结果
     */
	@Override
	public int insertEvidenceAuth(EvidenceAuth evidenceAuth)
	{
	    return evidenceAuthMapper.insertEvidenceAuth(evidenceAuth);
	}
	
	/**
     * 修改物证鉴定
     * 
     * @param evidenceAuth 物证鉴定信息
     * @return 结果
     */
	@Override
	public int updateEvidenceAuth(EvidenceAuth evidenceAuth)
	{
	    return evidenceAuthMapper.updateEvidenceAuth(evidenceAuth);
	}

	/**
     * 删除物证鉴定对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEvidenceAuthByIds(String ids)
	{
		return evidenceAuthMapper.deleteEvidenceAuthByIds(Convert.toStrArray(ids));
	}
	
}
