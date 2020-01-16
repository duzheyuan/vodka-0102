<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="${staticServer}utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${staticServer}utf8-jsp/third-party/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${staticServer}utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${staticServer}utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="${staticServer}utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${staticServer}utf8-jsp/third-party/template.min.js"></script>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Jar包更新
                    <small>Thanks for your help</small>
                </h1>
            </div>


            <form role="form" action="/JarCrud/jarUpdate" method="post" enctype="multipart/form-data">
                <!--Jar包修改-->
                <div class="form-group">
                    <label for="jarName">jar包名</label>

                    <!-- <div class="col-sm-10"> -->
                    <input type="text" class="form-control " name="jarName"  id="jarName" value="${jarNew.jarName}" readonly="readonly"/>

                    <!-- </div> -->
                    <button class="btn btn-primary" type="button" onclick="readOnle()"><span id="update">修改</span>
                    </button>
                </div>
                <!--Jar包上传人-->
                <div class="form-group">
                    <label for="uname">上传人</label>
                    <input type="text" class="form-control"
                           value="${jarNew.uname}"
                           name="uname"
                           id="uname"
                           readonly="readonly"/>
                    <input type="text" value="${jarNew.jnID}" name="jnID" style="display: none;">
                </div>

                <!--Jar包上传文件-->
                <div class="form-group">
                    <label for="fileUpload">新Jar包</label>
                    <input type="file" id="fileUpload" name="fileUpload"
                           class="btn btn-primary"/>
                    <p class="help-block" style="color:red">
                        请上传压缩包格式的文件
                    </p>
                </div>
                <!-- 模态框代码 -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <p class="modal-title" id="myModalLabel">
                                    IF YES OR NO!!!请确认信息！
                                </p>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                </button>
                                <button type="submit" class="btn btn-primary">确认提交</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </form>
            <div class="checkbox" style="left:75%; top: 30px;">
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    提交
                </button>
            </div>
        </div>
    </div>
</div>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
<script>
    var a = 0;
    // 第三种 通过方法响应点击事件
    function readOnle() {
        if (a == 0) {
            $("#jarName").removeAttr("readonly");
            a = 1;

        } else if (a == 1) {
            $("#jarName").attr("readOnly", "true");
            a = 0;
        }
    }
</script>

