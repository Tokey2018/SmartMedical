package com.tokeys.im.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.tokeys.im.entity.*;

/**
 * 普通会员 Dao
 */
@SqlResource("im.member")
public interface TkMemberDao extends BaseMapper<TkMember>{
    public PageQuery<TkMember> queryByCondition(PageQuery query);
    public void batchDelTkMemberByIds( List<Long> ids);
}