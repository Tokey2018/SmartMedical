/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateIhUsers:function(form,callback){
                Lib.submitForm("/cms/ihUsers/update.json",form,{},callback)
            },
            addIhUsers:function(form,callback){
                Lib.submitForm("/cms/ihUsers/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/ihUsers/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
            ,
            exportExcel:function(form,callback){
                var formPara = form.serializeJson();
                Common.post("/cms/ihUsers/excel/export.json", formPara, function(fileId) {
                    callback(fileId);
                })
            }
		
    };
    exports('ihUsersApi',api);
});