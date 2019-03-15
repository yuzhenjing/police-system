package com.police.project.system.evidenceresult.controller;

import com.police.common.utils.poi.ExcelUtil;
import com.police.common.utils.security.ShiroUtils;
import com.police.framework.aspectj.lang.annotation.Log;
import com.police.framework.aspectj.lang.enums.BusinessType;
import com.police.framework.web.controller.BaseController;
import com.police.framework.web.domain.AjaxResult;
import com.police.framework.web.page.TableDataInfo;
import com.police.project.system.evidenceresult.domain.EvidenceResult;
import com.police.project.system.evidenceresult.service.IEvidenceResultService;
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
@RequestMapping("/system/evidenceResult")
public class EvidenceResultController extends BaseController {
    private String prefix = "system/evidenceResult";

    @Autowired
    private IEvidenceResultService evidenceResultService;

    @RequiresPermissions("system:evidenceResult:view")
    @GetMapping()
    public String evidenceResult() {
        return prefix + "/evidenceResult";
    }

    /**
     * 查询物证鉴定列表
     */
    @RequiresPermissions("system:evidenceResult:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EvidenceResult evidenceResult) {
        startPage();
        List<EvidenceResult> list = evidenceResultService.selectEvidenceResultList(evidenceResult);
        return getDataTable(list);
    }


    /**
     * 导出物证鉴定列表
     */
    @RequiresPermissions("system:evidenceResult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EvidenceResult evidenceResult) {
        List<EvidenceResult> list = evidenceResultService.selectEvidenceResultList(evidenceResult);
        ExcelUtil<EvidenceResult> util = new ExcelUtil<EvidenceResult>(EvidenceResult.class);
        return util.exportExcel(list, "evidenceResult");
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
    @RequiresPermissions("system:evidenceResult:add")
    @Log(title = "物证鉴定", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EvidenceResult evidenceResult) {
        evidenceResult.setResultNum("R" + System.currentTimeMillis());
        final User sysUser = ShiroUtils.getSysUser();

        evidenceResult.setResultUser(sysUser.getUserName());
        evidenceResult.setCreateTime(new Date());
        evidenceResult.setUpdateTime(new Date());

        return toAjax(evidenceResultService.insertEvidenceResult(evidenceResult));
    }

    /**
     * 修改物证鉴定
     */
    @GetMapping("/edit/{resultNum}")
    public String edit(@PathVariable("resultNum") String resultNum, ModelMap mmap) {
        EvidenceResult evidenceResult = evidenceResultService.selectEvidenceResultById(resultNum);
        mmap.put("evidenceResult", evidenceResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存物证鉴定
     */
    @RequiresPermissions("system:evidenceResult:edit")
    @Log(title = "物证鉴定", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EvidenceResult evidenceResult) {
        evidenceResult.setUpdateTime(new Date());
        return toAjax(evidenceResultService.updateEvidenceResult(evidenceResult));
    }

    /**
     * 删除物证鉴定
     */
    @RequiresPermissions("system:evidenceResult:remove")
    @Log(title = "物证鉴定", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(evidenceResultService.deleteEvidenceResultByIds(ids));
    }

}
