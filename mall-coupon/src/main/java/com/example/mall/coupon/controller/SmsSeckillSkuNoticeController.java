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
import com.example.mall.coupon.domain.SmsSeckillSkuNotice;
import com.example.mall.coupon.service.ISmsSeckillSkuNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 秒杀商品通知订阅Controller
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
@RestController
@RequestMapping("/coupon/notice")
public class SmsSeckillSkuNoticeController extends BaseController
{
    @Autowired
    private ISmsSeckillSkuNoticeService smsSeckillSkuNoticeService;

    /**
     * 查询秒杀商品通知订阅列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        startPage();
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeList(smsSeckillSkuNotice);
        return getDataTable(list);
    }

    /**
     * 导出秒杀商品通知订阅列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:export')")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        List<SmsSeckillSkuNotice> list = smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeList(smsSeckillSkuNotice);
        ExcelUtil<SmsSeckillSkuNotice> util = new ExcelUtil<SmsSeckillSkuNotice>(SmsSeckillSkuNotice.class);
        util.exportExcel(response, list, "秒杀商品通知订阅数据");
    }

    /**
     * 获取秒杀商品通知订阅详细信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsSeckillSkuNoticeService.selectSmsSeckillSkuNoticeById(id));
    }

    /**
     * 新增秒杀商品通知订阅
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:add')")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return toAjax(smsSeckillSkuNoticeService.insertSmsSeckillSkuNotice(smsSeckillSkuNotice));
    }

    /**
     * 修改秒杀商品通知订阅
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:edit')")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsSeckillSkuNotice smsSeckillSkuNotice)
    {
        return toAjax(smsSeckillSkuNoticeService.updateSmsSeckillSkuNotice(smsSeckillSkuNotice));
    }

    /**
     * 删除秒杀商品通知订阅
     */
    @PreAuthorize("@ss.hasPermi('coupon:notice:remove')")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsSeckillSkuNoticeService.deleteSmsSeckillSkuNoticeByIds(ids));
    }
}
