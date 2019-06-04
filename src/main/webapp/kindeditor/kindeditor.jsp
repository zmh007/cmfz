<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <html>
    <head>
        <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script charset="utf-8" src="kindeditor-all-min.js"></script>
    <script charset="utf-8" src="lang/zh-CN.js"></script>
    <script>

        KindEditor.ready(function (K) {
            K.create('#editor_id',{
                //图片上传请求路径
                uploadJson: "${pageContext.request.contextPath}/kindeditor/uploadImage",
                //接收的文件名字
                fileManagerJson:"${pageContext.request.contextPath}/kindeditor/getAll",
                filePostName: "img", //后台以什么形式接收默认是imgFile
                //显示文件图片空间
                allowFileManager: true
                });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/kindeditor/addKindeditor" method="post">
<textarea name="content" id="editor_id" style="height: 70%;  width: 70%" >
    请输入文章内容
</textarea>
    <input type="submit" value="提交" >
</form>
</body>
</html>