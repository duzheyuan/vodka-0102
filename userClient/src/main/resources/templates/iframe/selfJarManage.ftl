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
                    data-url="/File/find/selfJarNews?uid=${uid}"
                    data-striped="true"
                    data-pagination="true"
                    data-page-size="5"
            >
                <thead>
                <tr>
                    <th data-field="jnID">编号</th>
                    <th data-field="jarName">Jar包名称</th>
                    <th data-field="jarUploadTime">交付时间</th>
                    <th data-field="jarVersion">版本</th>
                    <th data-field="jarSize">大小(MB)</th>
                    <th data-field="jarDowloadNumber">下载次数</th>
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
        if(row.status=="已审核"){
            var view = '<button class="btn btn-info view"><i class="glyphicon glyphicon-search"></i>  查看</button>';
            var jar = '<button class="btn btn-info jar"><i class="glyphicon glyphicon-search"></i>  修改jar</button>';
            var gua = '<button  class="btn btn-danger gua"><i class="glyphicon glyphicon-plus"></i> 修改文档</button>';
            return view + '&emsp;' + jar + '&emsp;' + gua;
        }else{
            return "无法操作";
        }
    }
    var optEvents = {
        "click .view": function (event, value, row) {
            window.location.href = "/File/lookJar?jnID=" + row.jnID;
        },

        "click .jar": function (event, value, row) {
            window.location.href = "/File/goto/iupdateJar?jnID=" + row.jnID
        },
        "click .gua": function (event, value, row) {
            window.location.href = "/File/goto/iupdateJarDocu?jnID=" + row.jnID
        }


    }


</script>

</body>
</html>