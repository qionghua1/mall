package com.example.mall.coupon.controller;

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
import com.example.mall.coupon.domain.SmsSkuFullReduction;
import com.example.mall.coupon.service.ISmsSkuFullReductionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品满减信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
@RestController
@RequestMapping("/coupon/fullReduction")
public class SmsSkuFullReductionController extends BaseController
{
    @Autowired
    private ISmsSkuFullReductionService smsSkuFullReductionService;

    /**
     * 查询商品满减信息列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsSkuFullReduction smsSkuFullReduction)
    {
        startPage();
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.selectSmsSkuFullReductionList(smsSkuFullReduction);
        return getDataTable(list);
    }

    /**
     * 导出商品满减信息列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:export')")
    @Log(title = "商品满减信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSkuFullReduction smsSkuFullReduction)
    {
        List<SmsSkuFullReduction> list = smsSkuFullReductionService.selectSmsSkuFullReductionList(smsSkuFullReduction);
        ExcelUtil<SmsSkuFullReduction> util = new ExcelUtil<SmsSkuFullReduction>(SmsSkuFullReduction.class);
        util.exportExcel(response, list, "商品满减信息数据");
    }

    /**
     * 获取商品满减信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSkuFullReductionService.selectSmsSkuFullReductionById(id));
    }

    /**
     * 新增商品满减信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:add')")
    @Log(title = "商品满减信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSkuFullReduction smsSkuFullReduction)
    {
        return toAjax(smsSkuFullReductionService.insertSmsSkuFullReduction(smsSkuFullReduction));
    }

    /**
     * 修改商品满减信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:edit')")
    @Log(title = "商品满减信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSkuFullReduction smsSkuFullReduction)
    {
        return toAjax(smsSkuFullReductionService.updateSmsSkuFullReduction(smsSkuFullReduction));
    }

    /**
     * 删除商品满减信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:fullReduction:remove')")
    @Log(title = "商品满减信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSkuFullReductionService.deleteSmsSkuFullReductionByIds(ids));
    }
}
