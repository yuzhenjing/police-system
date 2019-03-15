package com.police.project.system.evidencecategory.controller;

import com.police.common.utils.poi.ExcelUtil;
import com.police.framework.aspectj.lang.annotation.Log;
import com.police.framework.aspectj.lang.enums.BusinessType;
import com.police.framework.web.controller.BaseController;
import com.police.framework.web.domain.AjaxResult;
import com.police.framework.web.page.TableDataInfo;
import com.police.project.system.evidencecategory.domain.EvidenceCategory;
import com.police.project.system.evidencecategory.service.IEvidenceCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 分拣 信息操作处理
 *
 * @author police
 * @date 2019-03-15
 */
@Controller
@RequestMapping("/system/evidenceCategory")
public class EvidenceCategoryController extends BaseController {
    private String prefix = "system/evidenceCategory";

    @Autowired
    private IEvidenceCategoryService evidenceCategoryService;

    @RequiresPermissions("system:evidenceCategory:view")
    @GetMapping()
    public String evidenceCategory() {
        return prefix + "/evidenceCategory";
    }

    /**
     * 查询分拣列表
     */
    @RequiresPermissions("system:evidenceCategory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EvidenceCategory evidenceCategory) {
        startPage();
        List<EvidenceCategory> list = evidenceCategoryService.selectEvidenceCategoryList(evidenceCategory);
        return getDataTable(list);
    }


    /**
     * 导出分拣列表
     */
    @RequiresPermissions("system:evidenceCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EvidenceCategory evidenceCategory) {
        List<EvidenceCategory> list = evidenceCategoryService.selectEvidenceCategoryList(evidenceCategory);
        ExcelUtil<EvidenceCategory> util = new ExcelUtil<EvidenceCategory>(EvidenceCategory.class);
        return util.exportExcel(list, "evidenceCategory");
    }

    /**
     * 新增分拣
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存分拣
     */
    @RequiresPermissions("system:evidenceCategory:add")
    @Log(title = "分拣", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EvidenceCategory evidenceCategory) {
        return toAjax(evidenceCategoryService.insertEvidenceCategory(evidenceCategory));
    }

    /**
     * 修改分拣
     */
    @GetMapping("/edit/{categoryNum}")
    public String edit(@PathVariable("categoryNum") String categoryNum, ModelMap mmap) {
        EvidenceCategory evidenceCategory = evidenceCategoryService.selectEvidenceCategoryById(categoryNum);
        mmap.put("evidenceCategory", evidenceCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存分拣
     */
    @RequiresPermissions("system:evidenceCategory:edit")
    @Log(title = "分拣", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EvidenceCategory evidenceCategory) {
        evidenceCategory.setUpdateTime(new Date());
        return toAjax(evidenceCategoryService.updateEvidenceCategory(evidenceCategory));
    }

    /**
     * 删除分拣
     */
    @RequiresPermissions("system:evidenceCategory:remove")
    @Log(title = "分拣", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(evidenceCategoryService.deleteEvidenceCategoryByIds(ids));
    }

}
