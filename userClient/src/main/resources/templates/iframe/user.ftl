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
                    data-url="/User/find/users"
                    data-striped="true"
                    data-pagination="true"
                    data-page-size="5"
            >
                <thead>
                <tr>
                    <th data-field="uname">用户名</th>
                    <th data-field="upassword">用户密码</th>
                    <th data-field="createDate">注册时间</th>
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
        var del = '<button type="button" class="btn btn-danger del" name="del" onclick=""><i class="glyphicon glyphicon-plus"></i> 删除(谨慎使用)</button>';
        return del;
    }

    var optEvents = {
        "click .del": function (event, value, row) {
            if (confirm("Are you sure???")) {
                $.ajax({
                    url: '/User/delete?uid=' + row.uid,
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
            }
        },
    }


</script>

</body>
</html>