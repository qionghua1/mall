package com.example.mall.member.mapper;

import java.util.List;
import com.example.mall.member.domain.UmsMember;

/**
 * 会员Mapper接口
 * 
 * @author qionghua1
 * @date 2025-01-01
 */
public interface UmsMemberMapper 
{
    /**
     * 查询会员
     * 
     * @param id 会员主键
     * @return 会员
     */
    public UmsMember selectUmsMemberById(Long id);

    /**
     * 查询会员列表
     * 
     * @param umsMember 会员
     * @return 会员集合
     */
    public List<UmsMember> selectUmsMemberList(UmsMember umsMember);

    /**
     * 新增会员
     * 
     * @param umsMember 会员
     * @return 结果
     */
    public int insertUmsMember(UmsMember umsMember);

    /**
     * 修改会员
     * 
     * @param umsMember 会员
     * @return 结果
     */
    public int updateUmsMember(UmsMember umsMember);

    /**
     * 删除会员
     * 
     * @param id 会员主键
     * @return 结果
     */
    public int deleteUmsMemberById(Long id);

    /**
     * 批量删除会员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberByIds(Long[] ids);
}
