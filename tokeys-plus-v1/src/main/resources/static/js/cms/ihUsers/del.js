layui.define(['table', 'ihUsersApi'], function(exports) {
    var ihUsersApi = layui.ihUsersApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"ihUsersTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些IhUsers?",function(){
            var ids =Common.concatBatchId(data,"uid");
            ihUsersApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});