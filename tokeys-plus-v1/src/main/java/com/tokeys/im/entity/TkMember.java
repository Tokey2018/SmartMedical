package com.tokeys.im.entity;

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
* gen by Spring Boot2 Admin 2018-12-24
*/
public class TkMember extends BaseEntity{

    //唯一id
    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Long ids ;
	
    //系统唯一登录账号

    private String codeAccount ;
	
    //真实姓名

    private String name ;
	
    //登录密码

    private String password ;
	
    //创建时间

    private Date createTime ;
	
    //患者就诊科室

    private Integer orgId ;
	
    //就诊科室名称

    private String orgName ;
	
    //用户状态 1:启用 0:停用 2：锁定

    private String state ;
	
    //用户删除标记 0:未删除 1:已删除
	/*逻辑删除标志*/
	@InsertIgnore
	@LogicDelete(value = 1)

    private Integer delFlag ;
	
    //最后修改时间

    private Date updateTime ;
	

    private String attachmentId ;
	
    //密码加盐

    private String salt ;
	
    //用户昵称

    private String nickName ;
	
    //头像

    private String headImg ;
	
    //个人资料背景图片,不上传则系统默认

    private String backgroundImg ;
	
    //血型 A，B， O ，AB

    private String bloodType ;
	
    //手机号,也可以做所谓系统登录账号

    private String phone ;
	
    //邮箱

    private String email ;
	
    //生日

    private String birthday ;
	
    //性别,0:未知,1:男,女:2

    private Integer sex ;
	
    //婚姻状态 0:保密，1:未婚,2:已婚 3,离异

    private Integer marryStatus ;
	
    //网易云信id（增加多个即时供应商，就再增加多个本字段）

    private String imWyyxId ;
	
    //网易云信ID的密码

    private String wyyxIdToken ;
	
    //微信id,可以在微信登录时获取

    private String wxOpenId ;
	
    //身份证号码

    private String uidCard ;
	
    //v2 新增字段:接诊医生

    private Long doctorId ;
	
    //v2版本新增:接诊医生姓名

    private String doctorName ;
	
    //创建人.默认当前登录用户

    private Long createUid ;
	
    //最后修改表单人，默认当前登录用户。修改了某条记录要记录到系统日志表里!!

    private Long updateUid ;
	
    //诊断结果

    private String visitResult ;
	
    public TkMember()
    {
    }

    /**唯一id
    *@return 
    */
    public Long getIds(){
	    return  ids;
    }
    /**唯一id
    *@param  ids
    */
    public void setIds(Long ids){
        this.ids = ids;
    }

    /**系统唯一登录账号
    *@return 
    */
    public String getCodeAccount(){
	    return  codeAccount;
    }
    /**系统唯一登录账号
    *@param  codeAccount
    */
    public void setCodeAccount(String codeAccount){
        this.codeAccount = codeAccount;
    }

    /**真实姓名
    *@return 
    */
    public String getName(){
	    return  name;
    }
    /**真实姓名
    *@param  name
    */
    public void setName(String name){
        this.name = name;
    }

    /**登录密码
    *@return 
    */
    public String getPassword(){
	    return  password;
    }
    /**登录密码
    *@param  password
    */
    public void setPassword(String password){
        this.password = password;
    }

    /**创建时间
    *@return 
    */
    public Date getCreateTime(){
	    return  createTime;
    }
    /**创建时间
    *@param  createTime
    */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**患者就诊科室
    *@return 
    */
    public Integer getOrgId(){
	    return  orgId;
    }
    /**患者就诊科室
    *@param  orgId
    */
    public void setOrgId(Integer orgId){
        this.orgId = orgId;
    }

    /**就诊科室名称
    *@return 
    */
    public String getOrgName(){
	    return  orgName;
    }
    /**就诊科室名称
    *@param  orgName
    */
    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    /**用户状态 1:启用 0:停用 2：锁定
    *@return 
    */
    public String getState(){
	    return  state;
    }
    /**用户状态 1:启用 0:停用 2：锁定
    *@param  state
    */
    public void setState(String state){
        this.state = state;
    }

    /**用户删除标记 0:未删除 1:已删除
    *@return 
    */
    public Integer getDelFlag(){
	    return  delFlag;
    }
    /**用户删除标记 0:未删除 1:已删除
    *@param  delFlag
    */
    public void setDelFlag(Integer delFlag){
        this.delFlag = delFlag;
    }

    /**最后修改时间
    *@return 
    */
    public Date getUpdateTime(){
	    return  updateTime;
    }
    /**最后修改时间
    *@param  updateTime
    */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public String getAttachmentId(){
	    return  attachmentId;
    }
    public void setAttachmentId(String attachmentId){
        this.attachmentId = attachmentId;
    }

    /**密码加盐
    *@return 
    */
    public String getSalt(){
	    return  salt;
    }
    /**密码加盐
    *@param  salt
    */
    public void setSalt(String salt){
        this.salt = salt;
    }

    /**用户昵称
    *@return 
    */
    public String getNickName(){
	    return  nickName;
    }
    /**用户昵称
    *@param  nickName
    */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    /**头像
    *@return 
    */
    public String getHeadImg(){
	    return  headImg;
    }
    /**头像
    *@param  headImg
    */
    public void setHeadImg(String headImg){
        this.headImg = headImg;
    }

    /**个人资料背景图片,不上传则系统默认
    *@return 
    */
    public String getBackgroundImg(){
	    return  backgroundImg;
    }
    /**个人资料背景图片,不上传则系统默认
    *@param  backgroundImg
    */
    public void setBackgroundImg(String backgroundImg){
        this.backgroundImg = backgroundImg;
    }

    /**血型 A，B， O ，AB
    *@return 
    */
    public String getBloodType(){
	    return  bloodType;
    }
    /**血型 A，B， O ，AB
    *@param  bloodType
    */
    public void setBloodType(String bloodType){
        this.bloodType = bloodType;
    }

    /**手机号,也可以做所谓系统登录账号
    *@return 
    */
    public String getPhone(){
	    return  phone;
    }
    /**手机号,也可以做所谓系统登录账号
    *@param  phone
    */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**邮箱
    *@return 
    */
    public String getEmail(){
	    return  email;
    }
    /**邮箱
    *@param  email
    */
    public void setEmail(String email){
        this.email = email;
    }

    /**生日
    *@return 
    */
    public String getBirthday(){
	    return  birthday;
    }
    /**生日
    *@param  birthday
    */
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

    /**婚姻状态 0:保密，1:未婚,2:已婚 3,离异
    *@return 
    */
    public Integer getMarryStatus(){
	    return  marryStatus;
    }
    /**婚姻状态 0:保密，1:未婚,2:已婚 3,离异
    *@param  marryStatus
    */
    public void setMarryStatus(Integer marryStatus){
        this.marryStatus = marryStatus;
    }

    /**网易云信id（增加多个即时供应商，就再增加多个本字段）
    *@return 
    */
    public String getImWyyxId(){
	    return  imWyyxId;
    }
    /**网易云信id（增加多个即时供应商，就再增加多个本字段）
    *@param  imWyyxId
    */
    public void setImWyyxId(String imWyyxId){
        this.imWyyxId = imWyyxId;
    }

    /**网易云信ID的密码
    *@return 
    */
    public String getWyyxIdToken(){
	    return  wyyxIdToken;
    }
    /**网易云信ID的密码
    *@param  wyyxIdToken
    */
    public void setWyyxIdToken(String wyyxIdToken){
        this.wyyxIdToken = wyyxIdToken;
    }

    /**微信id,可以在微信登录时获取
    *@return 
    */
    public String getWxOpenId(){
	    return  wxOpenId;
    }
    /**微信id,可以在微信登录时获取
    *@param  wxOpenId
    */
    public void setWxOpenId(String wxOpenId){
        this.wxOpenId = wxOpenId;
    }

    /**身份证号码
    *@return 
    */
    public String getUidCard(){
	    return  uidCard;
    }
    /**身份证号码
    *@param  uidCard
    */
    public void setUidCard(String uidCard){
        this.uidCard = uidCard;
    }

    /**v2 新增字段:接诊医生
    *@return 
    */
    public Long getDoctorId(){
	    return  doctorId;
    }
    /**v2 新增字段:接诊医生
    *@param  doctorId
    */
    public void setDoctorId(Long doctorId){
        this.doctorId = doctorId;
    }

    /**v2版本新增:接诊医生姓名
    *@return 
    */
    public String getDoctorName(){
	    return  doctorName;
    }
    /**v2版本新增:接诊医生姓名
    *@param  doctorName
    */
    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }

    /**创建人.默认当前登录用户
    *@return 
    */
    public Long getCreateUid(){
	    return  createUid;
    }
    /**创建人.默认当前登录用户
    *@param  createUid
    */
    public void setCreateUid(Long createUid){
        this.createUid = createUid;
    }

    /**最后修改表单人，默认当前登录用户。修改了某条记录要记录到系统日志表里!!
    *@return 
    */
    public Long getUpdateUid(){
	    return  updateUid;
    }
    /**最后修改表单人，默认当前登录用户。修改了某条记录要记录到系统日志表里!!
    *@param  updateUid
    */
    public void setUpdateUid(Long updateUid){
        this.updateUid = updateUid;
    }

    /**诊断结果
    *@return 
    */
    public String getVisitResult(){
	    return  visitResult;
    }
    /**诊断结果
    *@param  visitResult
    */
    public void setVisitResult(String visitResult){
        this.visitResult = visitResult;
    }


}
