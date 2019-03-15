package com.police.project.system.evidenceauth.controller;

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
import com.police.project.system.evidencecategory.domain.EvidenceCategory;
import com.police.project.system.evidencecategory.service.IEvidenceCategoryService;
import com.police.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 物证鉴定 信息操作处理
 *
 * @author police
 * @date 2019-03-15
 */
@Controller
@RequestMapping("/system/evidenceAuth")
public class EvidenceAuthController extends BaseController {
    private String prefix = "system/evidenceAuth";

    @Autowired
    private IEvidenceAuthService evidenceAuthService;

    @RequiresPermissions("system:evidenceAuth:view")
    @GetMapping()
    public String evidenceAuth() {
        return prefix + "/evidenceAuth";
    }

    /**
     * 查询物证鉴定列表
     */
    @RequiresPermissions("system:evidenceAuth:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EvidenceAuth evidenceAuth) {
        startPage();
        List<EvidenceAuth> list = evidenceAuthService.selectEvidenceAuthList(evidenceAuth);
        return getDataTable(list);
    }


    /**
     * 导出物证鉴定列表
     */
    @RequiresPermissions("system:evidenceAuth:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EvidenceAuth evidenceAuth) {
        List<EvidenceAuth> list = evidenceAuthService.selectEvidenceAuthList(evidenceAuth);
        ExcelUtil<EvidenceAuth> util = new ExcelUtil<EvidenceAuth>(EvidenceAuth.class);
        return util.exportExcel(list, "evidenceAuth");
    }

    /**
     * 新增物证鉴定
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存物证鉴定
     */
    @RequiresPermissions("system:evidenceAuth:add")
    @Log(title = "物证鉴定", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EvidenceAuth evidenceAuth) {
        return toAjax(evidenceAuthService.insertEvidenceAuth(evidenceAuth));
    }

    /**
     * 修改物证鉴定
     */
    @GetMapping("/edit/{authNum}")
    public String edit(@PathVariable("authNum") String authNum, ModelMap mmap) {
        EvidenceAuth evidenceAuth = evidenceAuthService.selectEvidenceAuthById(authNum);
        mmap.put("evidenceAuth", evidenceAuth);
        return prefix + "/edit";
    }

    @Autowired
    private IEvidenceService evidenceService;
    @Autowired
    private IEvidenceAuditService evidenceAuditService;

    @Autowired
    private IEvidenceCategoryService evidenceCategoryService;

    /**
     * 修改保存物证鉴定
     */
    @RequiresPermissions("system:evidenceAuth:edit")
    @Log(title = "物证鉴定", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EvidenceAuth evidenceAuth) {

        User currentUser = ShiroUtils.getSysUser();
        evidenceAuth.setAuthUser(currentUser.getUserName());
        evidenceAuth.setCreateTime(new Date());
        evidenceAuth.setUpdateTime(new Date());


        EvidenceAudit evidenceAudit = new EvidenceAudit();
        //更新物证委托状态
        evidenceAudit.setAuditStatus(evidenceAuth.getAuthStatus());
        evidenceAudit.setEviNum(evidenceAuth.getEviNum());
        evidenceAudit.setModifyTime(new Date());
        evidenceAuditService.updateEvidenceAudit(evidenceAudit);
        //更改物证单状态
        final Evidence evidence = new Evidence();
        evidence.setEviStatus(evidenceAuth.getAuthStatus());
        evidence.setEviNum(evidenceAuth.getEviNum());
        evidence.setModifyTime(new Date());
        evidenceService.updateEvidence(evidence);

        //生成分拣条目
        EvidenceCategory evidenceCategory = new EvidenceCategory();
        evidenceCategory.setEviNum(evidence.getEviNum());
        evidenceCategory.setCategoryNum("CA-" + System.currentTimeMillis());
        evidenceCategoryService.insertEvidenceCategory(evidenceCategory);

        return toAjax(evidenceAuthService.updateEvidenceAuth(evidenceAuth));
    }

    /**
     * 删除物证鉴定
     */
    @RequiresPermissions("system:evidenceAuth:remove")
    @Log(title = "物证鉴定", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(evidenceAuthService.deleteEvidenceAuthByIds(ids));
    }

}
