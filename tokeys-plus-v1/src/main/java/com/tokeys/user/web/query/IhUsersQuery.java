package com.tokeys.user.web.query;

import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *IhUsers查询
 */
public class IhUsersQuery extends PageParam {
    @Query(name = "云信唯一名称", display = true)        
    private Integer uid;
    @Query(name = "昵称", display = true)        
    private String nick;
    @Query(name = "姓名", display = true)        
    private String realname;
    @Query(name = "phone", display = true)        
    private String phone;
    public Integer getUid(){
        return  uid;
    }
    public void setUid(Integer uid ){
        this.uid = uid;
    }
    public String getNick(){
        return  nick;
    }
    public void setNick(String nick ){
        this.nick = nick;
    }
    public String getRealname(){
        return  realname;
    }
    public void setRealname(String realname ){
        this.realname = realname;
    }
    public String getPhone(){
        return  phone;
    }
    public void setPhone(String phone ){
        this.phone = phone;
    }
 
}
