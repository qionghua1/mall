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
import com.example.mall.product.domain.Brand;
import com.example.mall.product.service.IBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/product/brand")
public class BrandController extends BaseController
{
    @Autowired
    private IBrandService brandService;

    /**
     * 查询品牌列表
     */
    @PreAuthorize("@ss.hasPermi('product:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(Brand brand)
    {
        startPage();
        List<Brand> list = brandService.selectBrandList(brand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @PreAuthorize("@ss.hasPermi('product:brand:export')")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Brand brand)
    {
        List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:brand:query')")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId)
    {
        return success(brandService.selectBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @PreAuthorize("@ss.hasPermi('product:brand:add')")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Brand brand)
    {
        return toAjax(brandService.insertBrand(brand));
    }

    /**
     * 修改品牌
     */
    @PreAuthorize("@ss.hasPermi('product:brand:edit')")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Brand brand)
    {
        return toAjax(brandService.updateBrand(brand));
    }

    /**
     * 删除品牌
     */
    @PreAuthorize("@ss.hasPermi('product:brand:remove')")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds)
    {
        return toAjax(brandService.deleteBrandByBrandIds(brandIds));
    }
}
