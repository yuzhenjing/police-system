package com.police.project.system.evidence.controller;

import com.police.common.utils.poi.ExcelUtil;
import com.police.common.utils.security.ShiroUtils;
import com.police.framework.aspectj.lang.annotation.Log;
import com.police.framework.aspectj.lang.enums.BusinessType;
import com.police.framework.web.controller.BaseController;
import com.police.framework.web.domain.AjaxResult;
import com.police.framework.web.page.TableDataInfo;
import com.police.project.system.evidence.domain.Evidence;
import com.police.project.system.evidence.service.IEvidenceService;
import com.police.project.system.evidenceaudit.domain.EvidenceAudit;
import com.police.project.system.evidenceaudit.service.IEvidenceAuditService;
import com.police.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 物证 信息操作处理
 *
 * @author police
 * @date 2019-03-13
 */
@Controller
@RequestMapping("/system/evidence")
public class EvidenceController extends BaseController {
    private String prefix = "system/evidence";

    @Autowired
    private IEvidenceService evidenceService;
    @Autowired
    private IEvidenceAuditService evidenceAuditService;

    @RequiresPermissions("system:evidence:view")
    @GetMapping()
    public String evidence() {
        return prefix + "/evidence";
    }

    /**
     * 查询物证列表
     */
    @RequiresPermissions("system:evidence:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Evidence evidence) {
        startPage();
        List<Evidence> list = evidenceService.selectEvidenceList(evidence);
        return getDataTable(list);
    }


    /**
     * 导出物证列表
     */
    @RequiresPermissions("system:evidence:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Evidence evidence) {
        List<Evidence> list = evidenceService.selectEvidenceList(evidence);
        ExcelUtil<Evidence> util = new ExcelUtil<Evidence>(Evidence.class);
        return util.exportExcel(list, "evidence");
    }

    /**
     * 新增物证
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存物证
     */
    @RequiresPermissions("system:evidence:add")
    @Log(title = "物证", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Evidence evidence) {
        evidence.setEviNum("NO-" + System.currentTimeMillis());
        //未委托 0
        evidence.setEviStatus(0);
        evidence.setModifyTime(new Date());
        User currentUser = ShiroUtils.getSysUser();
        evidence.setSysUserId(currentUser.getUserId());
        return toAjax(evidenceService.insertEvidence(evidence));
    }

    /**
     * 修改物证
     */
    @GetMapping("/edit/{eviNum}")
    public String edit(@PathVariable("eviNum") String eviNum, ModelMap mmap) {
        Evidence evidence = evidenceService.selectEvidenceById(eviNum);
        EvidenceAudit evidenceAudit = new EvidenceAudit();
        evidenceAudit.setEviNum(eviNum);
        final List<EvidenceAudit> audits = evidenceAuditService.selectEvidenceAuditList(evidenceAudit);
        if (!CollectionUtils.isEmpty(audits)) {
            final EvidenceAudit audit = audits.get(0);
            evidence.setAuditMsg(audit.getAuditMsg());
        }
        mmap.put("evidence", evidence);
        return prefix + "/edit";
    }

    /**
     * 修改保存物证
     */
    @RequiresPermissions("system:evidence:edit")
    @Log(title = "物证", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Evidence evidence) {
        evidence.setEviStatus(0);
        return toAjax(evidenceService.updateEvidence(evidence));
    }

    /**
     * 生成委托书
     *
     * @param eviNum
     * @param mmap
     * @return
     */
    @GetMapping("/applyAudit/{eviNum}")
    public String applyAudit(@PathVariable("eviNum") String eviNum, ModelMap mmap) {
        Evidence evidence = evidenceService.selectEvidenceById(eviNum);
        mmap.put("evidence", evidence);
        return prefix + "/apply_audit";
    }

    /**
     * 生成凭证
     */
    @RequiresPermissions("system:evidence:edit")
    @Log(title = "物证", businessType = BusinessType.UPDATE)
    @PostMapping("/applyAudit")
    @ResponseBody
    public AjaxResult applyAudit(Evidence evidence) {
        EvidenceAudit evidenceAudit = new EvidenceAudit();
        BeanUtils.copyProperties(evidence, evidenceAudit);
        final List<EvidenceAudit> audits = evidenceAuditService.selectEvidenceAuditList(evidenceAudit);
        evidenceAudit.setCreateTime(new Date());
        evidenceAudit.setModifyTime(new Date());

        //更新为证状态 待提审
        evidence.setEviStatus(1);
        evidenceService.updateEvidence(evidence);
        //生成委托书  待提审
        evidenceAudit.setAuditStatus(1);
        if (CollectionUtils.isEmpty(audits)) {
            return toAjax(evidenceAuditService.insertEvidenceAudit(evidenceAudit));
        }
        evidenceAudit.setAuditId(audits.get(0).getAuditId());
        return toAjax(evidenceAuditService.updateEvidenceAudit(evidenceAudit));
    }

    /**
     * 删除物证
     */
    @RequiresPermissions("system:evidence:remove")
    @Log(title = "物证", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(evidenceService.deleteEvidenceByIds(ids));
    }

}
