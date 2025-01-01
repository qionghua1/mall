package com.example.mall.member.controller;

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
import com.example.mall.member.domain.UmsMemberLoginLog;
import com.example.mall.member.service.IUmsMemberLoginLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员登录记录Controller
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
@RestController
@RequestMapping("/member/loginLog")
public class UmsMemberLoginLogController extends BaseController
{
    @Autowired
    private IUmsMemberLoginLogService umsMemberLoginLogService;

    /**
     * 查询会员登录记录列表
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(UmsMemberLoginLog umsMemberLoginLog)
    {
        startPage();
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.selectUmsMemberLoginLogList(umsMemberLoginLog);
        return getDataTable(list);
    }

    /**
     * 导出会员登录记录列表
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:export')")
    @Log(title = "会员登录记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UmsMemberLoginLog umsMemberLoginLog)
    {
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.selectUmsMemberLoginLogList(umsMemberLoginLog);
        ExcelUtil<UmsMemberLoginLog> util = new ExcelUtil<UmsMemberLoginLog>(UmsMemberLoginLog.class);
        util.exportExcel(response, list, "会员登录记录数据");
    }

    /**
     * 获取会员登录记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(umsMemberLoginLogService.selectUmsMemberLoginLogById(id));
    }

    /**
     * 新增会员登录记录
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:add')")
    @Log(title = "会员登录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UmsMemberLoginLog umsMemberLoginLog)
    {
        return toAjax(umsMemberLoginLogService.insertUmsMemberLoginLog(umsMemberLoginLog));
    }

    /**
     * 修改会员登录记录
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:edit')")
    @Log(title = "会员登录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UmsMemberLoginLog umsMemberLoginLog)
    {
        return toAjax(umsMemberLoginLogService.updateUmsMemberLoginLog(umsMemberLoginLog));
    }

    /**
     * 删除会员登录记录
     */
    @PreAuthorize("@ss.hasPermi('member:loginLog:remove')")
    @Log(title = "会员登录记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(umsMemberLoginLogService.deleteUmsMemberLoginLogByIds(ids));
    }
}
