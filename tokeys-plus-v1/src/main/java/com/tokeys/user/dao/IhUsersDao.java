package com.tokeys.user.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.tokeys.user.entity.*;

/**
 * IhUsers Dao
 */
@SqlResource("cms.ihUsers")
public interface IhUsersDao extends BaseMapper<IhUsers>{
    public PageQuery<IhUsers> queryByCondition(PageQuery query);
    public void batchDelIhUsersByIds( List<Long> ids);
}