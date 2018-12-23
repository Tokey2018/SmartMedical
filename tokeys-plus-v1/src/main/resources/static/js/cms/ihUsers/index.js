layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var ihUsersTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),ihUsersTable)
            }
        },
        initTable:function(){
            ihUsersTable = table.render({
                elem : '#ihUsersTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/cms/ihUsers/list.json' // 数据接口
                ,page : Lib.tablePage // 开启分页
                ,limit : 10,
                cols : [ [ // 表头
                    {
                        type : 'checkbox',
                        fixed:'left',
                    },
                {

                    field : 'uid', 
                        title : '云信唯一名称',
                    fixed:'left',
                        width : 60,
                },
                {

                    field : 'nick', 
                        title : '昵称',
                },
                {

                    field : 'realname', 
                        title : '姓名',
                },
                {

                    field : 'userimg', 
                        title : '头像',
                },
                {

                    field : 'backgroupimg', 
                        title : '个人资料背景图',
                },
                {

                    field : 'password', 
                        title : 'password',
                },
                {

                    field : 'phone', 
                        title : 'phone',
                },
                {

                    field : 'salt', 
                        title : 'salt',
                },
                {

                    field : 'email', 
                        title : 'email',
                },
                {

                    field : 'birthday', 
                        title : 'birthday',
                },
                {

                    field : 'sex', 
                        title : '性别',
                },
                {

                    field : 'ismarry', 
                        title : '是否结婚',
                },
                {

                    field : 'accid', 
                        title : '网易云信Id',
                },
                {

                    field : 'wechat', 
                        title : '微信账号',
                },
                {

                    field : 'aid', 
                        title : '所属单位Id(医院)',
                },
                {

                    field : 'did', 
                        title : '所属部门Id(科室)',
                },
                {

                    field : 'office', 
                        title : '职称1:主任医师',
                },
                {

                    field : 'sickskill', 
                        title : '擅长疾病',
                },
                {

                    field : 'intro', 
                        title : '详细介绍',
                },
                {

                    field : 'token', 
                        title : '网易云信ID的密码',
                },
                {

                    field : 'openstatus', 
                        title : '启用状态',
                },
                {

                    field : 'auditstatus', 
                        title : '认证审核状态:0未审核，1审核中，5审核通过，-1审核未通过',
                },
                {

                    field : 'lasttime', 
                        title : 'lasttime',
                },
                {

                    field : 'addtime', 
                        title : 'addtime',
                },
                {

                    field : 'updatetime', 
                        title : 'updatetime',
                },

        ] ]

        });

            table.on('checkbox(ihUsersTable)', function(obj){
                var ihUsers = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),ihUsersTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/ihUsers/add.do";
                    Common.openDlg(url,"IhUsers管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"ihUsersTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/ihUsers/edit.do?uid="+data.uid;
                    Common.openDlg(url,"IhUsers管理>"+data.uid+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            ,
                exportDocument : function() {
                    layui.use([ 'ihUsersApi' ], function() {
                        var ihUsersApi = layui.ihUsersApi
                        Common.openConfirm("确认要导出这些IhUsers数据?", function() {
                            ihUsersApi.exportExcel($("#searchForm"), function(fileId) {
                                Lib.download(fileId);
                            })
                        })
                    });
                },
                importDocument:function(){
                    var uploadUrl = Common.ctxPath+"/cms/ihUsers/excel/import.do";
                    //模板,
                    var templatePath= "/cms/ihUsers/ihUsers_upload_template.xls";
                    //公共的简单上传文件处理
                    var url = "/core/file/simpleUpload.do?uploadUrl="+uploadUrl+"&templatePath="+templatePath;
                    Common.openDlg(url, "IhUsers管理>上传");
                }
        };
            $('.ext-toolbar').on('click', function() {
                var type = $(this).data('type');
                toolbar[type] ? toolbar[type].call(this) : '';
            });
        }
    }
    exports('index',view);

});