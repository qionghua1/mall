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
import com.example.mall.product.domain.CommentReplay;
import com.example.mall.product.service.ICommentReplayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品评价回复关系Controller
 * 
 * @author qionghua1
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/product/commentReplay")
public class CommentReplayController extends BaseController
{
    @Autowired
    private ICommentReplayService commentReplayService;

    /**
     * 查询商品评价回复关系列表
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:list')")
    @GetMapping("/list")
    public TableDataInfo list(CommentReplay commentReplay)
    {
        startPage();
        List<CommentReplay> list = commentReplayService.selectCommentReplayList(commentReplay);
        return getDataTable(list);
    }

    /**
     * 导出商品评价回复关系列表
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:export')")
    @Log(title = "商品评价回复关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CommentReplay commentReplay)
    {
        List<CommentReplay> list = commentReplayService.selectCommentReplayList(commentReplay);
        ExcelUtil<CommentReplay> util = new ExcelUtil<CommentReplay>(CommentReplay.class);
        util.exportExcel(response, list, "商品评价回复关系数据");
    }

    /**
     * 获取商品评价回复关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(commentReplayService.selectCommentReplayById(id));
    }

    /**
     * 新增商品评价回复关系
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:add')")
    @Log(title = "商品评价回复关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CommentReplay commentReplay)
    {
        return toAjax(commentReplayService.insertCommentReplay(commentReplay));
    }

    /**
     * 修改商品评价回复关系
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:edit')")
    @Log(title = "商品评价回复关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CommentReplay commentReplay)
    {
        return toAjax(commentReplayService.updateCommentReplay(commentReplay));
    }

    /**
     * 删除商品评价回复关系
     */
    @PreAuthorize("@ss.hasPermi('product:commentReplay:remove')")
    @Log(title = "商品评价回复关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(commentReplayService.deleteCommentReplayByIds(ids));
    }
}
