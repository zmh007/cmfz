<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<script>
    $(function () {
        $("#albumList").jqGrid({
            url: "${pageContext.request.contextPath}/album/getAlbumByPager",
            editurl: "${pageContext.request.contextPath}/album/editAlbum",
            datatype: "json",
            colNames: ["id", "名称", "分数", "作者", "播音员", "集数", "简介", "状态", "上传时间", "插图"],
            colModel: [
                {name: "id", hidden: true},
                {name: "title", editable: true},
                {name: "score", editable: true},
                {name: "author", editable: true},
                {name: "broadcast", editable: true},
                {name: "count", editable: true},
                {name: "brief", editable: true},
                {
                    name: "status", editable: true, edittype: "select",
                    editoptions: {value: "展示:展示;不展示:不展示"}
                },
                {name: "createdate"},
                {name: "insertImg", editable: true, edittype: "file"}
            ],
            pager: "#albumPager",
            rowNum: 5,
            rowList: [1, 3, 5],
            viewrecords: true,
            height: '500px',
            multiselect: true,
            rownumbers: true,
            viewrecords: true,
            styleUI: "Bootstrap",
            autowidth: true, //自适应宽度
            subGrid: true,   //1.开启子表
            subGridRowExpanded: function (subGirdId, albumId) {
                addSubGrid(subGirdId, albumId);
            }
        }).jqGrid("navGrid", "#albumPager", {},
            {//edit
                afterSubmit: function (response) {
                    var ok = response.responseJSON.albumId;
                    if (ok != '') {
                        $.ajaxFileUpload({
                            url: "${pageContext.request.contextPath}/album/upload",
                            type: "post",
                            fileElementId: "insertImg",
                            data: {albumId: ok},
                            success: function () {

                            }
                        })
                    }

                    return response;
                }
            }
        );


    });

    function addSubGrid(subGirdId, albumId) {
        var subGridTableId = subGirdId + "table";
        var subGridPagerId = subGirdId + "pager";
        $("#" + subGirdId).html(
            "<table id='" + subGridTableId + "' class=\"table table-striped\"></table>" +
            "<div id='" + subGridPagerId + "' style=\"height: 100px\"></div>")
        $("#" + subGridTableId).jqGrid({
            url: "${pageContext.request.contextPath}/chapter/getChapterByPager?albumId=" + albumId,
            editurl: "${pageContext.request.contextPath}/chapter/editChapter?albumId=" + albumId,
            datatype: "json",
            colNames: ["id", "albumId", "标题", "大小", "时长", "操作"],
            colModel: [
                {name: "id"},
                {name: "albumId"},
                {name: "title", editable: true},
                {name: "size"},
                {name: "duration"},
                {
                    name: "path", editable: true, edittype: "file",
                    formatter: function (cellvalue) {
                        return "<a href='#' onclick=\"playAudio('"+cellvalue+"')\"><span class='glyphicon glyphicon-play-circle'></span></a>&nbsp;&nbsp;&nbsp;" +
                            "<a href='#' onclick=\"downLoadAudio('"+cellvalue+"')\"><span class='glyphicon glyphicon-download'></span></a> "
                    }
                },
            ],
            pager: "#" + subGridPagerId,
            rowNum: 5,
            rowList: [3, 4, 7],
            viewrecords: true,
            height: '100px',
            multiselect: true,
            rownumbers: true,
            viewrecords: true,
            styleUI: "Bootstrap",
            autowidth: true
        }).jqGrid("navGrid", "#" + subGridPagerId, {},
            {},
            {   closeAfterAdd:true,
                afterSubmit: function (response) {
                    var chapterId = response.responseJSON.chapterId
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/chapter/upload",
                        type: "post",
                        fileElementId: "path",
                        data: {chapterId: chapterId},
                        success: function () {

                        }
                    })

                    return response;
                }
            }
        )
    }

    function playAudio(cellvalue) {
        $("#playAudio").modal("show")
        $("#audioId").attr("src","${pageContext.request.contextPath}/upload/audio/"+cellvalue);
    }
    function downLoadAudio(cellvalue) {
        location.href="${pageContext.request.contextPath}/chapter/downLoadAudio?audioName="+cellvalue;
    }
</script>

<div id="playAudio" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <audio id="audioId" src="" controls></audio>
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<table id="albumList" class="table table-striped"></table>
<div id="albumPager" style="height: 50px"></div>
