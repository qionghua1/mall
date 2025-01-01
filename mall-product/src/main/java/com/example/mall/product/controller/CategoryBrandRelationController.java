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
import com.example.mall.product.domain.CategoryBrandRelation;
import com.example.mall.product.service.ICategoryBrandRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌分类关联Controller
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/product/brandRelation")
public class CategoryBrandRelationController extends BaseController
{
    @Autowired
    private ICategoryBrandRelationService categoryBrandRelationService;

    /**
     * 查询品牌分类关联列表
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:list')")
    @GetMapping("/list")
    public TableDataInfo list(CategoryBrandRelation categoryBrandRelation)
    {
        startPage();
        List<CategoryBrandRelation> list = categoryBrandRelationService.selectCategoryBrandRelationList(categoryBrandRelation);
        return getDataTable(list);
    }

    /**
     * 导出品牌分类关联列表
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:export')")
    @Log(title = "品牌分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CategoryBrandRelation categoryBrandRelation)
    {
        List<CategoryBrandRelation> list = categoryBrandRelationService.selectCategoryBrandRelationList(categoryBrandRelation);
        ExcelUtil<CategoryBrandRelation> util = new ExcelUtil<CategoryBrandRelation>(CategoryBrandRelation.class);
        util.exportExcel(response, list, "品牌分类关联数据");
    }

    /**
     * 获取品牌分类关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(categoryBrandRelationService.selectCategoryBrandRelationById(id));
    }

    /**
     * 新增品牌分类关联
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:add')")
    @Log(title = "品牌分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CategoryBrandRelation categoryBrandRelation)
    {
        return toAjax(categoryBrandRelationService.insertCategoryBrandRelation(categoryBrandRelation));
    }

    /**
     * 修改品牌分类关联
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:edit')")
    @Log(title = "品牌分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CategoryBrandRelation categoryBrandRelation)
    {
        return toAjax(categoryBrandRelationService.updateCategoryBrandRelation(categoryBrandRelation));
    }

    /**
     * 删除品牌分类关联
     */
    @PreAuthorize("@ss.hasPermi('product:brandRelation:remove')")
    @Log(title = "品牌分类关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(categoryBrandRelationService.deleteCategoryBrandRelationByIds(ids));
    }
}
