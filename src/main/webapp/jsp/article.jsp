<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#articleList").jqGrid({
            url: "${pageContext.request.contextPath}/article/getAllArticle",
            datatype: "json",
            colNames: ["id", "标题", "日期", "内容", "作者", "操作"],
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {name: "createdate", editable: true, edittype: "date"},
                {name: "content", hidden: true},
                {name: "author", editable: true},
                {
                    name: "",
                    formatter: function (cellValue, opo, value) {
                        return "<a href='#' onclick=\"lookModal('" + value.id + "')\">查看详情</a>";
                    }
                }

            ],
            pager: "#articlePager",
            rowNum: 5,
            rowList: [3, 4, 7],
            viewrecords: true,
            height: '50%',
            multiselect: true,
            rownumbers: true,
            viewrecords: true,
            styleUI: "Bootstrap",
            autowidth: true
        })
    })

    function showModal() {
        $("#myModal").modal("show")
        $("#addArticleFrom")[0].reset();
        KindEditor.html("#editor", "");
        $("#modal_footer").html(
            "<button type=\"button\" class=\"btn btn-primary\" onclick=\"addModal()\">保存</button>\n" +
            "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">取消</button>")
        KindEditor.create('#editor', {
            uploadJson: "${pageContext.request.contextPath}/kindeditor/uploadImg",
            filePostName: "img",//默认是imgFile
            fileManagerJson: "${pageContext.request.contextPath}/kindeditor/getAll",
            allowFileManager: true,
            resizeType: 1,
            afterBlur: function () {
                this.sync()
            }
        });

    }

    function addModal() {
        alert();
        $.ajax({
            url: "{pageContext.request.contextPath}/article/edit",
            datatype: "json",
            type: "post",
            data: $("#addArticleFrom").serialize(),
            success: function () {

            }
        })
    }

    function lookModal(id) {
        var value = $("#articleList").jqGrid("getRowData", id);
        $("#myModal").modal("show");
        $("#title").val(value.title)
        if (value.status == '展示') {
            $("#status").val('展示')
        } else {
            $("#status").val('不展示')
        }
        $("#modal_footer").html(
            "<button type=\"button\" class=\"btn btn-primary\" onclick=\"saveModal()\">保存</button>\n" +
            "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">取消</button>")

        KindEditor.create('#editor', {
            uploadJson: "${pageContext.request.contextPath}/kindeditor/uploadImg",
            filePostName: "img",//默认是imgFile
            fileManagerJson: "${pageContext.request.contextPath}/kindeditor/getAll",
            allowFileManager: true,
            resizeType: 1,
            afterBlur: function () {
                this.sync()
            }
        });
        $("#editor").val(value.content)
        KindEditor.html("#editor",value.content);
    }

    function saveModal() {
        $.ajax({
            url:"xxxxxxx"
        })
    }
</script>
<h3>文章管理</h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#home" aria-controls="home" role="tab" data-toggle="tab"><b>文章信息</b></a></li>
        <li><a href="javascript:void(0)" onclick="showModal()"><b>添加文章</b></a></li>
    </ul>
</div>
<table id="articleList" class="table table-striped"></table>
<div style="height: 50px" id="articlePager"></div>
<div id="bannerMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span>
    </button>
    <strong>Warning!</strong>
</div>

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
                <form action="" class="form-horizontal"
                      id="addArticleFrom">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">标题</label>
                        <div class="col-sm-5">
                            <input type="text" name="title" id="title" placeholder="请输入标题" class="form-control">
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

            </div>
        </div>
    </div>
</div>
