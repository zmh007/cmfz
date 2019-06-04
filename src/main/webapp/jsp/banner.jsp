<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#bannerList").jqGrid({
            url: "${pageContext.request.contextPath}/banner/queryByPager",
            editurl: "${pageContext.request.contextPath}/banner/edit",
            datatype: "json",
            colNames: ["id", "标题", "状态", "日期", "描述", "图片"],
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {
                    name: "status", editable: true, edittype: "select",
                    editoptions: {value: "展示:展示;不展示:不展示"}
                },
                {name: "createdate",editable:true,edittype:"date"},
                {name: "description", editable: true},
                {name: "imgpic", editable: true, edittype: "file",
                    formatter:function (cellValue) {
                        return "<img style='height: 50px;width: 50px' src='${pageContext.request.contextPath}/upload/img/"+cellValue+"'/>"
                    }
                }
            ],
            pager: "#bannerPager",
            rowNum: 5,
            rowList: [1, 3, 5],
            viewrecords: true,
            height: '50%',
            multiselect: true,
            rownumbers: true,
            viewrecords: true,
            styleUI: "Bootstrap",
            autowidth: true
        }).jqGrid("navGrid", "#bannerPager",
            {addtext: "添加", edittext: "编辑", deltext: "删除", search: false},
            {//修改
                afterSubmit: function (response) {
                    if(response.responseJSON.id!=''){
                        var bannerId = response.responseJSON.id;
                        $.ajaxFileUpload({
                            url: "${pageContext.request.contextPath}/banner/upload",
                            type: "post",
                            fileElementId: "imgpic",
                            data:{bannerId:bannerId},
                            success:function () {

                            }
                        });
                    }
                    return response;
                }
            }, {//添加
                closeAfterAdd:true,
                afterSubmit: function (response) {
                    var bannerId = response.responseJSON.bannerId;
                    var msg = response.responseJSON.msg;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/banner/upload",
                        type: "post",
                        fileElementId: "imgpic",
                        data:{bannerId:bannerId},
                        success:function () {
                            $("#bannerList").trigger("reloadGrid");
                            $("#bannerMsgId").show().html(msg);
                            setTimeout(function(){
                                $("#bannerMsgId").hide()
                                }, 3000);
                        }
                    });
                    return response;
                }
            },{//删除
                afterComplete: function(response){
                    var msg = response.responseJSON.msg;
                    $("#bannerMsgId").show().html(msg);
                    setTimeout(function(){
                        $("#bannerMsgId").hide()
                    }, 3000);
                }
            }
        );
    })
</script>
<h3>轮播图管理</h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">轮播图信息</a></li>

    </ul>
</div>
<table id="bannerList" class="table table-striped"></table>
<div style="height: 50px" id="bannerPager"></div>
<div id="bannerMsgId" class="alert alert-warning alert-dismissible" role="alert" style="display:none">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>Warning!</strong>
</div>
