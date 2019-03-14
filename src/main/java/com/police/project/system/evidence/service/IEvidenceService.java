package com.police.project.system.evidence.service;


import com.police.project.system.evidence.domain.Evidence;

import java.util.List;

/**
 * 物证 服务层
 *
 * @author police
 * @date 2019-03-13
 */
public interface IEvidenceService {
    /**
     * 查询物证信息
     *
     * @param eviNum 物证ID
     * @return 物证信息
     */
    public Evidence selectEvidenceById(String eviNum);

    /**
     * 查询物证列表
     *
     * @param evidence 物证信息
     * @return 物证集合
     */
    public List<Evidence> selectEvidenceList(Evidence evidence);

    /**
     * 新增物证
     *
     * @param evidence 物证信息
     * @return 结果
     */
    public int insertEvidence(Evidence evidence);

    /**
     * 修改物证
     *
     * @param evidence 物证信息
     * @return 结果
     */
    public int updateEvidence(Evidence evidence);

    /**
     * 删除物证信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEvidenceByIds(String ids);

}
