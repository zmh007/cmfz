<%@page contentType="text/html; utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#userList").jqGrid({
            url: "${pageContext.request.contextPath}/user/getUserByPager",
            datatype: "json",
            colNames: ["id", "法名", "真名", "密码", "性别", "省份", "电话号", "状态", "创建时间", "签名", "头像"],
            colModel: [
                {name: "id"},
                {name: "dharma", editable: true},
                {name: "name", editable: true},
                {name: "password", editable: true},
                {name: "sex", editable: true},
                {name: "province", editable: true},
                {name: "phoneNum", editable: true},
                {name: "status", editable: true},
                {name: "createDate", editable: true, edittype: "date"},
                {name: "sign", editable: true},
                {
                    name: "headPic", editable: true, edittype: "file",
                    formatter: function (cellValue) {
                        return "<img style='height: 50px;width: 50px' src='${pageContext.request.contextPath}/upload/img/" + cellValue + "'/>"
                    }
                }
            ],
            pager: "#userPager",
            rowNum: 1,
            rowList: [1, 4, 7],
            viewrecords: true,
            height: '50%',
            multiselect: true,
            rownumbers: true,
            styleUI: "Bootstrap",
            autowidth: true
        });
    });
    function outUserMsg() {
        location.href = "${pageContext.request.contextPath}/user/easyPoiOut"
    }
</script>
<h3>用户管理</h3>
<div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">用户信息</a></li>
        <li><a href="#" onclick="outUserMsg()">导出用户信息</a></li>
    </ul>
</div>
<table id="userList" class="table table-striped">

</table>
<div style="height: 50px" id="userPager"></div>

