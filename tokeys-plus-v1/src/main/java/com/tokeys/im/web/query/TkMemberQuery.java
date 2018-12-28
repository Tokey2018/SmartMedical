package com.tokeys.im.web.query;

import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *普通会员查询
 */
public class TkMemberQuery extends PageParam {
    @Query(name = "真实姓名", display = true)        
    private String name;
    @Query(name = "创建时间", display = true)        
    private Date createTime;
    @Query(name = "用户昵称", display = true)        
    private String nickName;
    @Query(name = "手机号", display = true)        
    private String phone;
    @Query(name = "邮箱", display = true)        
    private String email;
    public String getName(){
        return  name;
    }
    public void setName(String name ){
        this.name = name;
    }
    public Date getCreateTime(){
        return  createTime;
    }
    public void setCreateTime(Date createTime ){
        this.createTime = createTime;
    }
    public String getNickName(){
        return  nickName;
    }
    public void setNickName(String nickName ){
        this.nickName = nickName;
    }
    public String getPhone(){
        return  phone;
    }
    public void setPhone(String phone ){
        this.phone = phone;
    }
    public String getEmail(){
        return  email;
    }
    public void setEmail(String email ){
        this.email = email;
    }
 
}
