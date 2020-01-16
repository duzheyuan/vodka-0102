<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script src="/webjars/js/jquery-1.12.4.js"></script>
<script src="/webjars/js/bootstrap.js"></script>
<script src="/webjars/js/bootstrap-table.js"></script>
<script src="/webjars/js/bootstrap-table-zh-CN.js"></script>
<script src="/webjars/js/sweetalert2.min.js"></script>
<script src="/webjars/js/sweetalert2.js"></script>
<script src="/webjars/js/toastr.js"></script>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table
                    id="id"
                    data-toggle="table"
                    data-url="/File/find/auditingJarNews"
                    data-striped="true"
                    data-pagination="true"
                    data-page-size="5"
            >
                <thead>
                <tr>
                    <th data-field="jarName">Jar包名称</th>
                    <th data-field="jarUploadTime">提交时间</th>
                    <th data-field="jarVersion">版本</th>
                    <th data-field="jarSize">大小(MB)</th>
                    <th data-field="jarDowloadNumber">下载次数</th>
                    <th data-field="uname">贡献者</th>
                    <th data-field="status">状态</th>
                    <th data-formatter="optFormatter" data-events="optEvents">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
<script>
    /*  <#--data-formatter的方法按钮let 值对应每个optEvents  取值用row.属性-->*/
    //value代表当前单元格的值 row代表这条记录 对象 index代表编号
    function optFormatter(value, row, index) {
        var view = '<button class="btn btn-info view"><i class="glyphicon glyphicon-search"></i>  查看</button>';
        var agr = '<button class="btn btn-info agr"><i class="glyphicon glyphicon-search"></i>  批准</button>';
        return view + '&emsp;' + agr;
    }

    var optEvents = {
        "click .view": function (event, value, row) {
            window.location.href = "/File/checkView?jnID=" + row.jnID;
        },
        "click .agr": function (event, value, row) {
            $.ajax({
                url: '/File/straw?jnID=' + row.jnID,
                contentType: 'application/json;charset=UTF-8',   //contentType表示媒体类型信息：application/json 表示以json格式输出。
                dataType: "json",
                type: 'post',
                success: function (data) {   //成功后回调
                    alert(data.info);
                    location.reload();
                },
                error: function (error) {    //失败后回调
                    alert(error);
                }
            });
        },
    }


</script>

</body>
</html>