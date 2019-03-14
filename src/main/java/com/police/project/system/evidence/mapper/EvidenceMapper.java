package com.police.project.system.evidence.mapper;


import com.police.project.system.evidence.domain.Evidence;

import java.util.List;

/**
 * 物证 数据层
 *
 * @author police
 * @date 2019-03-13
 */
public interface EvidenceMapper {
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
     * 删除物证
     *
     * @param eviNum 物证ID
     * @return 结果
     */
    public int deleteEvidenceById(String eviNum);

    /**
     * 批量删除物证
     *
     * @param eviNums 需要删除的数据ID
     * @return 结果
     */
    public int deleteEvidenceByIds(String[] eviNums);

}
