package com.example.mall.product.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.example.mall.product.domain.AttrGroup;
import com.example.mall.product.service.IAttrGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 属性分组Controller
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/product/arrtGroup")
public class AttrGroupController extends BaseController
{
    @Autowired
    private IAttrGroupService attrGroupService;

    /**
     * 查询属性分组列表
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:list')")
    @GetMapping("/list")
    public TableDataInfo list(AttrGroup attrGroup)
    {
        startPage();
        List<AttrGroup> list = attrGroupService.selectAttrGroupList(attrGroup);
        return getDataTable(list);
    }

    /**
     * 导出属性分组列表
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:export')")
    @Log(title = "属性分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AttrGroup attrGroup)
    {
        List<AttrGroup> list = attrGroupService.selectAttrGroupList(attrGroup);
        ExcelUtil<AttrGroup> util = new ExcelUtil<AttrGroup>(AttrGroup.class);
        util.exportExcel(response, list, "属性分组数据");
    }

    /**
     * 获取属性分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:query')")
    @GetMapping(value = "/{attrGroupId}")
    public AjaxResult getInfo(@PathVariable("attrGroupId") Long attrGroupId)
    {
        return success(attrGroupService.selectAttrGroupByAttrGroupId(attrGroupId));
    }

    /**
     * 新增属性分组
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:add')")
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AttrGroup attrGroup)
    {
        return toAjax(attrGroupService.insertAttrGroup(attrGroup));
    }

    /**
     * 修改属性分组
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:edit')")
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AttrGroup attrGroup)
    {
        return toAjax(attrGroupService.updateAttrGroup(attrGroup));
    }

    /**
     * 删除属性分组
     */
    @PreAuthorize("@ss.hasPermi('product:arrtGroup:remove')")
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attrGroupIds}")
    public AjaxResult remove(@PathVariable Long[] attrGroupIds)
    {
        return toAjax(attrGroupService.deleteAttrGroupByAttrGroupIds(attrGroupIds));
    }
}
