queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from ih_users t
    where del_flag=0 
    @//数据权限，该sql语句功能点  
    and #function("ihUsers.query")#
    @if(!isEmpty(uid)){
        and  t.uid =#uid#
    @}
    @if(!isEmpty(nick)){
        and  t.nick =#nick#
    @}
    @if(!isEmpty(realname)){
        and  t.realName =#realname#
    @}
    @if(!isEmpty(phone)){
        and  t.phone =#phone#
    @}
    
    
    

batchDelIhUsersByIds
===

* 批量逻辑删除

    update ih_users set del_flag = 1 where uid  in( #join(ids)#)
    
