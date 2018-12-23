package com.tokeys.user.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;

import org.beetl.sql.core.annotatoin.InsertIgnore;
import org.beetl.sql.core.annotatoin.Version;
import org.beetl.sql.core.annotatoin.LogicDelete;


/* 
* 
* gen by Spring Boot2 Admin 2018-11-09
*/
public class IhUsers extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Integer uid ;
	

    private String nick ;
	
    //姓名

    private String realname ;
	
    //头像

    private String userimg ;
	
    //个人资料背景图

    private String backgroupimg ;
	

    private String password ;
	

    private String phone ;
	

    private String salt ;
	

    private String email ;
	

    private String birthday ;
	
    //性别,0:未知,1:男,女:2

    private Integer sex ;
	
    //是否结婚,0:未知，1:已婚,2:未婚

    private Integer ismarry ;
	
    //网易云信Id

    private String accid ;
	
    //微信账号

    private String wechat ;
	
    //所属单位Id(医院)

    private Integer aid ;
	
    //所属部门Id(科室)

    private Integer did ;
	
    //职称
   //1:主任医师,2:主任中医师3:副主任医师4:副主任中医师,5:主治医师6:医师7:中医师8:其他

    private String office ;
	
    //擅长疾病

    private String sickskill ;
	
    //详细介绍

    private String intro ;
	
    //网易云信ID的密码

    private String token ;
	
    //启用状态,0: 启用,1:停用

    private Integer openstatus ;
	
    //认证审核状态:0未审核，1审核中，5审核通过，-1审核未通过

    private Integer auditstatus ;
	

    private Integer lasttime ;
	

    private Integer addtime ;
	

    private Integer updatetime ;
	
	/*逻辑删除标志*/
	@InsertIgnore
	@LogicDelete(value = 1)

    private Integer delFlag ;
	
    public IhUsers()
    {
    }

    public Integer getUid(){
	    return  uid;
    }
    public void setUid(Integer uid){
        this.uid = uid;
    }

    public String getNick(){
	    return  nick;
    }
    public void setNick(String nick){
        this.nick = nick;
    }

    /**姓名
    *@return 
    */
    public String getRealname(){
	    return  realname;
    }
    /**姓名
    *@param  realname
    */
    public void setRealname(String realname){
        this.realname = realname;
    }

    /**头像
    *@return 
    */
    public String getUserimg(){
	    return  userimg;
    }
    /**头像
    *@param  userimg
    */
    public void setUserimg(String userimg){
        this.userimg = userimg;
    }

    /**个人资料背景图
    *@return 
    */
    public String getBackgroupimg(){
	    return  backgroupimg;
    }
    /**个人资料背景图
    *@param  backgroupimg
    */
    public void setBackgroupimg(String backgroupimg){
        this.backgroupimg = backgroupimg;
    }

    public String getPassword(){
	    return  password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPhone(){
	    return  phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getSalt(){
	    return  salt;
    }
    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getEmail(){
	    return  email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getBirthday(){
	    return  birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    /**性别,0:未知,1:男,女:2
    *@return 
    */
    public Integer getSex(){
	    return  sex;
    }
    /**性别,0:未知,1:男,女:2
    *@param  sex
    */
    public void setSex(Integer sex){
        this.sex = sex;
    }

    /**是否结婚,0:未知，1:已婚,2:未婚
    *@return 
    */
    public Integer getIsmarry(){
	    return  ismarry;
    }
    /**是否结婚,0:未知，1:已婚,2:未婚
    *@param  ismarry
    */
    public void setIsmarry(Integer ismarry){
        this.ismarry = ismarry;
    }

    /**网易云信Id
    *@return 
    */
    public String getAccid(){
	    return  accid;
    }
    /**网易云信Id
    *@param  accid
    */
    public void setAccid(String accid){
        this.accid = accid;
    }

    /**微信账号
    *@return 
    */
    public String getWechat(){
	    return  wechat;
    }
    /**微信账号
    *@param  wechat
    */
    public void setWechat(String wechat){
        this.wechat = wechat;
    }

    /**所属单位Id(医院)
    *@return 
    */
    public Integer getAid(){
	    return  aid;
    }
    /**所属单位Id(医院)
    *@param  aid
    */
    public void setAid(Integer aid){
        this.aid = aid;
    }

    /**所属部门Id(科室)
    *@return 
    */
    public Integer getDid(){
	    return  did;
    }
    /**所属部门Id(科室)
    *@param  did
    */
    public void setDid(Integer did){
        this.did = did;
    }

    /**职称
1:主任医师,2:主任中医师3:副主任医师4:副主任中医师,5:主治医师6:医师7:中医师8:其他
    *@return 
    */
    public String getOffice(){
	    return  office;
    }
    /**职称
1:主任医师,2:主任中医师3:副主任医师4:副主任中医师,5:主治医师6:医师7:中医师8:其他
    *@param  office
    */
    public void setOffice(String office){
        this.office = office;
    }

    /**擅长疾病
    *@return 
    */
    public String getSickskill(){
	    return  sickskill;
    }
    /**擅长疾病
    *@param  sickskill
    */
    public void setSickskill(String sickskill){
        this.sickskill = sickskill;
    }

    /**详细介绍
    *@return 
    */
    public String getIntro(){
	    return  intro;
    }
    /**详细介绍
    *@param  intro
    */
    public void setIntro(String intro){
        this.intro = intro;
    }

    /**网易云信ID的密码
    *@return 
    */
    public String getToken(){
	    return  token;
    }
    /**网易云信ID的密码
    *@param  token
    */
    public void setToken(String token){
        this.token = token;
    }

    /**启用状态,0: 启用,1:停用
    *@return 
    */
    public Integer getOpenstatus(){
	    return  openstatus;
    }
    /**启用状态,0: 启用,1:停用
    *@param  openstatus
    */
    public void setOpenstatus(Integer openstatus){
        this.openstatus = openstatus;
    }

    /**认证审核状态:0未审核，1审核中，5审核通过，-1审核未通过
    *@return 
    */
    public Integer getAuditstatus(){
	    return  auditstatus;
    }
    /**认证审核状态:0未审核，1审核中，5审核通过，-1审核未通过
    *@param  auditstatus
    */
    public void setAuditstatus(Integer auditstatus){
        this.auditstatus = auditstatus;
    }

    public Integer getLasttime(){
	    return  lasttime;
    }
    public void setLasttime(Integer lasttime){
        this.lasttime = lasttime;
    }

    public Integer getAddtime(){
	    return  addtime;
    }
    public void setAddtime(Integer addtime){
        this.addtime = addtime;
    }

    public Integer getUpdatetime(){
	    return  updatetime;
    }
    public void setUpdatetime(Integer updatetime){
        this.updatetime = updatetime;
    }

    public Integer getDelFlag(){
	    return  delFlag;
    }
    public void setDelFlag(Integer delFlag){
        this.delFlag = delFlag;
    }


}
