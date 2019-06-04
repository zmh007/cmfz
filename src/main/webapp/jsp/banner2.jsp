<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#bannerLIst").jqGrid({
            url: "${pageContext.request.contextPath}/banner/queryByPager",
            datatype: "json",
            colNames: ["id", "标题", "状态", "日期", "描述", "图片"],
            colModel: [
                {name: "id"},
                {name: "title"},
                {name: "status"},
                {name: "createdate"},
                {name: "descriptioin"},
                {name: "imgpic"}
            ],
            pager: "bannerPager",
            rowNum: 5,
            rowList: [1, 3, 7],
            viewrecords: true,
            heitht: '50%',
            multiselect:true,
            rownumbers:true,
            styleUI: "Bootstrap",
            autowidth: true
        }).jqGrid("navGid")
    });


</script>
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