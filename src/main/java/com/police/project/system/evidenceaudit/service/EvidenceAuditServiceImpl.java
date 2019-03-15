package com.police.project.system.evidenceaudit.service;

import com.police.common.utils.text.Convert;
import com.police.project.system.evidenceaudit.domain.EvidenceAudit;
import com.police.project.system.evidenceaudit.mapper.EvidenceAuditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物证审核 服务层实现
 *
 * @author police
 * @date 2019-03-13
 */
@Service
public class EvidenceAuditServiceImpl implements IEvidenceAuditService {
    @Autowired
    private EvidenceAuditMapper evidenceAuditMapper;

    /**
     * 查询物证审核信息
     *
     * @param auditId 物证审核ID
     * @return 物证审核信息
     */
    @Override
    public EvidenceAudit selectEvidenceAuditById(Integer auditId) {
        return evidenceAuditMapper.selectEvidenceAuditById(auditId);
    }

    /**
     * 查询物证审核列表
     *
     * @param evidenceAudit 物证审核信息
     * @return 物证审核集合
     */
    @Override
    public List<EvidenceAudit> selectEvidenceAuditList(EvidenceAudit evidenceAudit) {
        return evidenceAuditMapper.selectEvidenceAuditList(evidenceAudit);
    }

    /**
     * 新增物证审核
     *
     * @param evidenceAudit 物证审核信息
     * @return 结果
     */
    @Override
    public int insertEvidenceAudit(EvidenceAudit evidenceAudit) {
        return evidenceAuditMapper.insertEvidenceAudit(evidenceAudit);
    }

    /**
     * 修改物证审核
     *
     * @param evidenceAudit 物证审核信息
     * @return 结果
     */
    @Override
    public int updateEvidenceAudit(EvidenceAudit evidenceAudit) {
        return evidenceAuditMapper.updateEvidenceAudit(evidenceAudit);
    }

    /**
     * 删除物证审核对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEvidenceAuditByIds(String ids) {
        return evidenceAuditMapper.deleteEvidenceAuditByIds(Convert.toStrArray(ids));
    }

}
