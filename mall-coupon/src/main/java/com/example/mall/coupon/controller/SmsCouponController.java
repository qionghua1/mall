package com.example.mall.coupon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.mall.common.utils.R;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import com.example.mall.coupon.domain.SmsCoupon;
import com.example.mall.coupon.service.ISmsCouponService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券信息Controller
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
@RefreshScope
@RestController
@RequestMapping("/coupon/coupon")
public class SmsCouponController extends BaseController
{
    @Autowired
    private ISmsCouponService smsCouponService;

    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private int age;

    @RequestMapping("/test")
    public R test() {
        return R.ok().put("name", name).put("age", age);
    }
    @RequestMapping("/member/list")
    public HashMap<String, String> MemberCoupons() {
        HashMap<String, String> couponList = new HashMap<String, String>();
        SmsCoupon coupon = new SmsCoupon();
        coupon.setCouponName("满100减10");
        couponList.put("coupons", coupon.getCouponName());
        return couponList;
    }

    /**
     * 查询优惠券信息列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:list')")
    @GetMapping("/list")
    public TableDataInfo list(SmsCoupon smsCoupon)
    {
        startPage();
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠券信息列表
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:export')")
    @Log(title = "优惠券信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SmsCoupon smsCoupon)
    {
        List<SmsCoupon> list = smsCouponService.selectSmsCouponList(smsCoupon);
        ExcelUtil<SmsCoupon> util = new ExcelUtil<SmsCoupon>(SmsCoupon.class);
        util.exportExcel(response, list, "优惠券信息数据");
    }

    /**
     * 获取优惠券信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(smsCouponService.selectSmsCouponById(id));
    }

    /**
     * 新增优惠券信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:add')")
    @Log(title = "优惠券信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.insertSmsCoupon(smsCoupon));
    }

    /**
     * 修改优惠券信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:edit')")
    @Log(title = "优惠券信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SmsCoupon smsCoupon)
    {
        return toAjax(smsCouponService.updateSmsCoupon(smsCoupon));
    }

    /**
     * 删除优惠券信息
     */
    @PreAuthorize("@ss.hasPermi('coupon:coupon:remove')")
    @Log(title = "优惠券信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smsCouponService.deleteSmsCouponByIds(ids));
    }
}
