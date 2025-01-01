package com.example.mall.ware.controller;

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
import com.example.mall.ware.domain.WmsPurchase;
import com.example.mall.ware.service.IWmsPurchaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/ware/purchase")
public class WmsPurchaseController extends BaseController
{
    @Autowired
    private IWmsPurchaseService wmsPurchaseService;

    /**
     * 查询采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsPurchase wmsPurchase)
    {
        startPage();
        List<WmsPurchase> list = wmsPurchaseService.selectWmsPurchaseList(wmsPurchase);
        return getDataTable(list);
    }

    /**
     * 导出采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:export')")
    @Log(title = "采购信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsPurchase wmsPurchase)
    {
        List<WmsPurchase> list = wmsPurchaseService.selectWmsPurchaseList(wmsPurchase);
        ExcelUtil<WmsPurchase> util = new ExcelUtil<WmsPurchase>(WmsPurchase.class);
        util.exportExcel(response, list, "采购信息数据");
    }

    /**
     * 获取采购信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsPurchaseService.selectWmsPurchaseById(id));
    }

    /**
     * 新增采购信息
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:add')")
    @Log(title = "采购信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsPurchase wmsPurchase)
    {
        return toAjax(wmsPurchaseService.insertWmsPurchase(wmsPurchase));
    }

    /**
     * 修改采购信息
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:edit')")
    @Log(title = "采购信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsPurchase wmsPurchase)
    {
        return toAjax(wmsPurchaseService.updateWmsPurchase(wmsPurchase));
    }

    /**
     * 删除采购信息
     */
    @PreAuthorize("@ss.hasPermi('ware:purchase:remove')")
    @Log(title = "采购信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsPurchaseService.deleteWmsPurchaseByIds(ids));
    }
}
