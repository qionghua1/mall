package com.example.mall.coupon.service;

import java.util.List;
import com.example.mall.coupon.domain.SmsHomeSubject;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】Service接口
 * 
 * @author qionghua1
 * @date 2025-01-05
 */
public interface ISmsHomeSubjectService 
{
    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * 
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    public SmsHomeSubject selectSmsHomeSubjectById(Long id);

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     * 
     * @param smsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】集合
     */
    public List<SmsHomeSubject> selectSmsHomeSubjectList(SmsHomeSubject smsHomeSubject);

    /**
     * 新增首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * 
     * @param smsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    public int insertSmsHomeSubject(SmsHomeSubject smsHomeSubject);

    /**
     * 修改首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * 
     * @param smsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    public int updateSmsHomeSubject(SmsHomeSubject smsHomeSubject);

    /**
     * 批量删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * 
     * @param ids 需要删除的首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键集合
     * @return 结果
     */
    public int deleteSmsHomeSubjectByIds(Long[] ids);

    /**
     * 删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】信息
     * 
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 结果
     */
    public int deleteSmsHomeSubjectById(Long id);
}
