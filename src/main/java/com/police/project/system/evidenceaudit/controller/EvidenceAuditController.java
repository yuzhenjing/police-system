package com.police.project.system.evidenceaudit.controller;

import com.police.common.utils.DateUtils;
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
import com.police.project.system.evidenceauth.domain.EvidenceAuth;
import com.police.project.system.evidenceauth.service.IEvidenceAuthService;
import com.police.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 物证审核 信息操作处理
 *
 * @author police
 * @date 2019-03-13
 */
@Controller
@RequestMapping("/system/evidenceAudit")
public class EvidenceAuditController extends BaseController {
    private String prefix = "system/evidenceAudit";

    @Autowired
    private IEvidenceAuditService evidenceAuditService;

    @Autowired
    private IEvidenceAuthService evidenceAuthService;


    @RequiresPermissions("system:evidenceAudit:view")
    @GetMapping()
    public String evidenceAudit() {
        return prefix + "/evidenceAudit";
    }

    /**
     * 查询物证审核列表
     */
    @RequiresPermissions("system:evidenceAudit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EvidenceAudit evidenceAudit) {
        startPage();
        List<EvidenceAudit> list = evidenceAuditService.selectEvidenceAuditList(evidenceAudit);
        return getDataTable(list);
    }


    /**
     * 导出物证审核列表
     */
    @RequiresPermissions("system:evidenceAudit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EvidenceAudit evidenceAudit) {
        List<EvidenceAudit> list = evidenceAuditService.selectEvidenceAuditList(evidenceAudit);
        ExcelUtil<EvidenceAudit> util = new ExcelUtil<EvidenceAudit>(EvidenceAudit.class);
        return util.exportExcel(list, "evidenceAudit");
    }

    /**
     * 新增物证审核
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存物证审核
     */
    @RequiresPermissions("system:evidenceAudit:add")
    @Log(title = "物证审核", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EvidenceAudit evidenceAudit) {
        return toAjax(evidenceAuditService.insertEvidenceAudit(evidenceAudit));
    }

    /**
     * 修改物证审核
     */
    @GetMapping("/edit/{auditId}")
    public String edit(@PathVariable("auditId") Integer auditId, ModelMap mmap) {
        EvidenceAudit evidenceAudit = evidenceAuditService.selectEvidenceAuditById(auditId);
        mmap.put("evidenceAudit", evidenceAudit);
        return prefix + "/edit";
    }

    @Autowired
    private IEvidenceService evidenceService;

    /**
     * 修改保存物证审核
     */
    @RequiresPermissions("system:evidenceAudit:edit")
    @Log(title = "物证审核", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EvidenceAudit evidenceAudit) {
        User currentUser = ShiroUtils.getSysUser();
        evidenceAudit.setAuditUser(currentUser.getUserName());

        EvidenceAuth evidenceAuth = new EvidenceAuth();
        evidenceAuth.setEviNum(evidenceAudit.getEviNum());
        final List<EvidenceAuth> evidenceAuths = evidenceAuthService.selectEvidenceAuthList(evidenceAuth);

        if (CollectionUtils.isEmpty(evidenceAuths)) {
            //添加受理信息
            evidenceAuth.setAuthNum("AUTH-" + DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, new Date()));
            evidenceAuth.setEviName(evidenceAudit.getEviName());
            //2 待审批  3 审批通过   4 审批拒绝
            //添加受理状态记录
            evidenceAuth.setAuthStatus(2);
            evidenceAuthService.insertEvidenceAuth(evidenceAuth);
        } else {
            final EvidenceAuth auth = evidenceAuths.get(0);
            auth.setAuthStatus(2);
            evidenceAuthService.updateEvidenceAuth(auth);
        }
        //更改物证单状态
        final Evidence evidence = new Evidence();
        evidence.setEviStatus(2);
        evidence.setEviNum(evidenceAudit.getEviNum());
        evidenceService.updateEvidence(evidence);

        //更新物证委托状态
        evidenceAudit.setAuditStatus(2);
        return toAjax(evidenceAuditService.updateEvidenceAudit(evidenceAudit));
    }

    /**
     * 删除物证审核
     */
    @RequiresPermissions("system:evidenceAudit:remove")
    @Log(title = "物证审核", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(evidenceAuditService.deleteEvidenceAuditByIds(ids));
    }

}
