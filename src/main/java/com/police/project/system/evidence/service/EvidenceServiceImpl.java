package com.police.project.system.evidence.service;

import com.police.common.utils.text.Convert;
import com.police.project.system.evidence.domain.Evidence;
import com.police.project.system.evidence.mapper.EvidenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物证 服务层实现
 *
 * @author police
 * @date 2019-03-13
 */
@Service
public class EvidenceServiceImpl implements IEvidenceService {
    @Autowired
    private EvidenceMapper evidenceMapper;

    /**
     * 查询物证信息
     *
     * @param eviNum 物证ID
     * @return 物证信息
     */
    @Override
    public Evidence selectEvidenceById(String eviNum) {
        return evidenceMapper.selectEvidenceById(eviNum);
    }

    /**
     * 查询物证列表
     *
     * @param evidence 物证信息
     * @return 物证集合
     */
    @Override
    public List<Evidence> selectEvidenceList(Evidence evidence) {
        return evidenceMapper.selectEvidenceList(evidence);
    }

    /**
     * 新增物证
     *
     * @param evidence 物证信息
     * @return 结果
     */
    @Override
    public int insertEvidence(Evidence evidence) {
        return evidenceMapper.insertEvidence(evidence);
    }

    /**
     * 修改物证
     *
     * @param evidence 物证信息
     * @return 结果
     */
    @Override
    public int updateEvidence(Evidence evidence) {
        return evidenceMapper.updateEvidence(evidence);
    }

    /**
     * 删除物证对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEvidenceByIds(String ids) {
        return evidenceMapper.deleteEvidenceByIds(Convert.toStrArray(ids));
    }

}
