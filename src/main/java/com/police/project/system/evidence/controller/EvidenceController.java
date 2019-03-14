package com.police.project.system.evidence.controller;

import com.police.common.utils.poi.ExcelUtil;
import com.police.framework.aspectj.lang.annotation.Log;
import com.police.framework.aspectj.lang.enums.BusinessType;
import com.police.framework.web.controller.BaseController;
import com.police.framework.web.domain.AjaxResult;
import com.police.framework.web.page.TableDataInfo;
import com.police.project.system.evidence.domain.Evidence;
import com.police.project.system.evidence.service.IEvidenceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        evidence.setEviStatus(1);
        evidence.setModifyTime(new Date());

        return toAjax(evidenceService.insertEvidence(evidence));
    }

    /**
     * 修改物证
     */
    @GetMapping("/edit/{eviNum}")
    public String edit(@PathVariable("eviNum") String eviNum, ModelMap mmap) {
        Evidence evidence = evidenceService.selectEvidenceById(eviNum);
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
        return toAjax(evidenceService.updateEvidence(evidence));
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
