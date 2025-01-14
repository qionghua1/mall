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
import com.example.mall.coupon.domain.SmsSkuLadder;
import com.example.mall.coupon.service.ISmsSkuLadderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品阶梯价格Controller
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
@RestController
@RequestMapping("/coupon/ladder")
public class SmsSkuLadderController extends BaseController
{
    @Autowired
    private ISmsSkuLadderService smsSkuLadderService;

    /**
     * 查询商品阶梯价格列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsSkuLadder smsSkuLadder)
    {
        startPage();
        List<SmsSkuLadder> list = smsSkuLadderService.selectSmsSkuLadderList(smsSkuLadder);
        return getDataTable(list);
    }

    /**
     * 导出商品阶梯价格列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:export')")
    @Log(title = "商品阶梯价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSkuLadder smsSkuLadder)
    {
        List<SmsSkuLadder> list = smsSkuLadderService.selectSmsSkuLadderList(smsSkuLadder);
        ExcelUtil<SmsSkuLadder> util = new ExcelUtil<SmsSkuLadder>(SmsSkuLadder.class);
        util.exportExcel(response, list, "商品阶梯价格数据");
    }

    /**
     * 获取商品阶梯价格详细信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSkuLadderService.selectSmsSkuLadderById(id));
    }

    /**
     * 新增商品阶梯价格
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:add')")
    @Log(title = "商品阶梯价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSkuLadder smsSkuLadder)
    {
        return toAjax(smsSkuLadderService.insertSmsSkuLadder(smsSkuLadder));
    }

    /**
     * 修改商品阶梯价格
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:edit')")
    @Log(title = "商品阶梯价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSkuLadder smsSkuLadder)
    {
        return toAjax(smsSkuLadderService.updateSmsSkuLadder(smsSkuLadder));
    }

    /**
     * 删除商品阶梯价格
     */
    @PreAuthorize("@ss.hasPermi('coupon:ladder:remove')")
    @Log(title = "商品阶梯价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSkuLadderService.deleteSmsSkuLadderByIds(ids));
    }
}
