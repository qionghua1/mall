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
import com.example.mall.ware.domain.WmsPurchaseDetail;
import com.example.mall.ware.service.IWmsPurchaseDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购信息细节Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/ware/purchaseDetail")
public class WmsPurchaseDetailController extends BaseController
{
    @Autowired
    private IWmsPurchaseDetailService wmsPurchaseDetailService;

    /**
     * 查询采购信息细节列表
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmsPurchaseDetail wmsPurchaseDetail)
    {
        startPage();
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出采购信息细节列表
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:export')")
    @Log(title = "采购信息细节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsPurchaseDetail wmsPurchaseDetail)
    {
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        ExcelUtil<WmsPurchaseDetail> util = new ExcelUtil<WmsPurchaseDetail>(WmsPurchaseDetail.class);
        util.exportExcel(response, list, "采购信息细节数据");
    }

    /**
     * 获取采购信息细节详细信息
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsPurchaseDetailService.selectWmsPurchaseDetailById(id));
    }

    /**
     * 新增采购信息细节
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:add')")
    @Log(title = "采购信息细节", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsPurchaseDetail wmsPurchaseDetail)
    {
        return toAjax(wmsPurchaseDetailService.insertWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 修改采购信息细节
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:edit')")
    @Log(title = "采购信息细节", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsPurchaseDetail wmsPurchaseDetail)
    {
        return toAjax(wmsPurchaseDetailService.updateWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 删除采购信息细节
     */
    @PreAuthorize("@ss.hasPermi('ware:purchaseDetail:remove')")
    @Log(title = "采购信息细节", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsPurchaseDetailService.deleteWmsPurchaseDetailByIds(ids));
    }
}
