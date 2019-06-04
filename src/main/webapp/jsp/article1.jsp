<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#articleList").jqGrid({
            url: "${pageContext.request.contextPath}/article/getAllArticle",
            datatype: "json",
            colNames: ["id", "标题", "作者", "内容","日期", "操作"],
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {name: "author", editable: true},
                {name: "content", hidden: true},
                {name: "createdate", editable: true, edittype: "data"},
                {
                    name: "",
                    formatter:function (cellValue,opo,value) {
                            return "<a href='#'onclick=\"lookModal('"+value.id+"')\">查看详情</a>";
                    }
                }
            ],
            //pager暂时不知道什么意思
            pager: "#articlePager",
            rowNum: 5,
            rowList: [1, 3, 5],
            //显示总条数
            viewrecords: true,
            multiselect: true,
            rownumbers: true,
            height: '50%',
            styleUI: "Bootstrap",
            autowidth: true
        });
    });

    //展示添加文章模态框
    function showModal() {
        //alert(); //测试点击情况
        //id选择器调用方法
        $("#myModal").modal("show");
        //提交完成填单后，清空jquery标题类的内容
        $("#addArticleFrom")[0].reset();
        //提交完成后清空富文本框中的内容
        KindEditor.html("#editor", "");
        //加载副文本编辑器
        KindEditor.create('#editor', {
            uploadJson: "${pageContext.request.contextPath}/kindeditor/uploadImage",//图片上传请求路径
            fileManagerJson: "${pageContext.request.contextPath}/kindeditor/getAll",//接收的文件名字
            filePostName: "img", //后台以什么形式接收默认是imgFile
            allowFileManager: true,//显示文件图片空间
            resizeType: 1,
            afterBlur: function () {
                this.sync();
            }
        });

    }

    function addModal() {
        $.ajax({
            url: "${pageContext.request.contextPath}/article/edit",
            datatype: "json",
            type: "post",
            data: $("#addArticleFrom").serialize(),
            success: function () {

            }

        });
    }
    function lookModal(id) {
        var value=$("#articleList").jqGrid("getRowData",id);
        $("#myModal").modal("show");
        $("#title").val(value.title);
        $("#author").val(value.author);
        $("#content").val(value.content);
        $("#createdate").val(value.createdate);
    }
</script>
<h3>文章管理</h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#home" aria-controls="home" role="tab" data-toggle="tab"><b>文章信息</b></a></li>
        <%--添加文章弹出的的对话框在原地，不会跑到上面和下面void（0）--%>
        <li><a href="javascript:void(0)" onclick="showModal()"><b>添加文章</b></a></li>
    </ul>
</div>
<table id="articleList" class="table table-striped"></table>
<div style="height: 50px" id="articlePager"></div>
<div id="articleMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span>
    </button>
    <strong>Warning!</strong>
</div>

<%--模态框--%>
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content" style="width:750px">
            <!--模态框标题-->
            <div class="modal-header">
                <!--
                    用来关闭模态框的属性:data-dismiss="modal"
                -->
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <h4 class="modal-title">编辑用户信息</h4>
            </div>

            <!--模态框内容体-->
            <div class="modal-body">
                <form action="" class="form-horizontal" id="addArticleFrom">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">标题</label>

                        <div class="col-sm-5">
                            <input type="text" name="title" id="title" placeholder="请输入标题" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">作者</label>
                        <div class="col-sm-5">
                            <input type="text" name="author" id="author" placeholder="输入作者" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">状态</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="status" id="status">
                                <option value="展示">展示</option>
                                <option value="不展示">不展示</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea id="editor" name="content" style="width:700px;height:300px;"></textarea>
                        </div>
                    </div>
                    <input id="addInsertImg" name="insertImg" hidden>
                </form>
            </div>
            <!--模态页脚-->
            <div class="modal-footer" id="modal_footer">
                <button type="button" class="btn btn-primary" onclick="addModal()">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>