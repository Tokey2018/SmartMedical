package com.tokeys.user.service;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.util.PlatformException;

import com.tokeys.user.dao.IhUsersDao;
import com.tokeys.user.entity.IhUsers;
import com.ibeetl.admin.core.service.BaseService;

/**
 * IhUsers Service
 */

@Service
@Transactional
public class IhUsersService extends BaseService<IhUsers>{

    @Autowired private IhUsersDao ihUsersDao;

    public PageQuery<IhUsers>queryByCondition(PageQuery query){
        PageQuery ret =  ihUsersDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelIhUsers(List<Long> ids){
        try {
            ihUsersDao.batchDelIhUsersByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除IhUsers失败", e);
        }
    }
}