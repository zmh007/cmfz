<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        $("#bannerList").jqGrid({
            url:"${pageContext.request.contextPath}/json/banner.json",
            datatype:"json",
            colNames:["编号","标题","状态","描述","上传时间","图片"],
            colModel:[
                {name:"id"},
                {name:"title"},
                {name:"status"},
                {name:"description"},
                {name:"createDate"},
                {name:"url"}
            ],
            styleUI:"Bootstrap",
            pager:"#bannerPager",
            rowNum:3,
            rowList:[3,5,8],
            viewrecords:true,
            height:'60%',
            multiselect:true,
            rownumbers:true,
            viewrecords:true,
            autowidth: true
        });
    });

</script>
<div>
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" style="font-weight: bold">轮播图信息</a></li>
    </ul>
</div>
<div class="panel panel-default">
    <table id="bannerList"></table>
    <div id="bannerPager" style="height: 50px;width: auto"></div>
</div>