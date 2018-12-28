package com.tokeys.im.service;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibeetl.admin.core.util.PlatformException;

import com.tokeys.im.dao.TkMemberDao;
import com.tokeys.im.entity.TkMember;
import com.ibeetl.admin.core.service.BaseService;

/**
 * 普通会员 Service
 */

@Service
@Transactional
public class TkMemberService extends BaseService<TkMember>{

    @Autowired private TkMemberDao memberDao;

    public PageQuery<TkMember>queryByCondition(PageQuery query){
        PageQuery ret =  memberDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelTkMember(List<Long> ids){
        try {

           // System.out.println("99999999" );
            System.out.println("ids=="+ids.get(1));

            memberDao.batchDelTkMemberByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除普通会员失败", e);
        }
    }
}