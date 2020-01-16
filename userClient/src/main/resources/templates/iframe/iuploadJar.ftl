<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="${staticServer}utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${staticServer}utf8-jsp/third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServer}utf8-jsp/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServer}utf8-jsp/umeditor.min.js"></script>
    <script type="text/javascript" src="${staticServer}utf8-jsp/lang/zh-cn/zh-cn.js"></script>


    <script type="text/javascript" src="${staticServer}utf8-jsp/third-party/template.min.js"></script>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    jar包上传
                    <small>你是最棒的</small>
                </h1>
            </div>


            <form role="form" method="post" action="/File/jar/jarUploadJar" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="jarName">jar包名</label><input type="text" name="jarName" class="form-control"
                                                             id="jarName"/>
                </div>
                <div class="form-group">
                    <label for="uname">上传人</label><input type="text" value="${uname}" name="uname" class="form-control"
                                                         readonly="readonly"
                                                         id="uname"/>
                    <input type="text" value="${uid}" name="uid" style="display: none;">
                </div>
                <div class="form-group">
                    <label for="fileUpload">File input</label>
                    <input type="file" name="fileUpload" id="fileUpload"
                           class="btn btn-primary"/>
                    <p class="help-block" style="color:red">
                        请上传压缩包格式的文件
                    </p>
                </div>
                <h3>
                    Jar包描述
                </h3>

                  <script type="text/plain" id="myEditor" name="content" style="width:1000px;height:240px;">
                      <p>这里我可以写一些输入提示</p>
                  </script>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <p class="modal-title" id="myModalLabel">
                                    If Yes Or No！请确认好信息！
                                </p>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                </button>
                                <button  class="btn btn-primary" >
                                    确认上传
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <div class="checkbox" style="left:75%; top: 30px;" >
                <button class="btn btn-primary " data-toggle="modal" data-target="#myModal">
                    上传
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
    window.UMEDITOR_HOME_URL = "";
    /** "相对于网站根目录的相对路径"**/
    var um = UM.getEditor('myEditor', {
        //这里配置后台图片的接收路径，用来接收图片
        imageUrl: '/File/fileUpload/',
        //图片修正地址，有时候我们调用图片时，如配置了tomcat虚拟路径要调整时使用，如果没有，建议为空(图片回显地址)
        //"http://localhost:8080/fileUploadPath/image/" 图片名称没有写出，所以security 白名单使用/fileUploadPath/**
        imagePath: '/fileUploadPath/image/',
        //云服务器回显地址
       // imagePath: 'http://111.229.111.27:8080/fileUploadPath/image/',
        //后台接收的参数名称，默认是upfile,和后台需要对应，不然会出错
        imageFieldName: "upfile",
        focus: true
    });
</script>
</body>
</html>
