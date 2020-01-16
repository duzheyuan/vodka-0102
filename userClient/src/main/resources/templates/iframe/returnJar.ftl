<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                旧Jar包名称：${jarOld.jarName}
            </h3>
            <dl class="dl-horizontal">

                <dt>
                    版本:
                </dt>
                <dd>
                    ${jarOld.jarVersion}
                </dd>
                <dt>
                    Jar大小:
                </dt>
                <dd>
                    ${jarOld.jarSize} MB
                </dd>
                <dt>
                    时间:
                </dt>
                <dd>
                    ${jarOld.jarUploadTime?date}
                </dd>
                <dt>
                    下载次数:
                </dt>
                <dd>
                    ${jarOld.jarDowloadNumber}
                </dd>
            </dl>
            <div>
                <h5 align="center">Jar包介绍</h5>
                ${jarDocument.document}
                <blockquote class="pull-right">
                    <small> 贡献者:<cite> ${jarOld.uname}</cite></small>
                </blockquote>
                <blockquote class="pull-right">
                    <small><a href="/JarCrud/downJar?joID=${jarOld.joID}">点击下载</a></small>
                </blockquote>
            </div>

            <div class="panel-group" id="panel-812542">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-812542" href="#panel-element-840387">历史版本回退</a>
                    </div>

                    <div id="panel-element-840387" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ol>
                                <#list jarOlds as jarOld>
                                <li>
                                    <a href="/File/returnJar?joID=${jarOld.joID}">${jarOld.jarName}©${jarOld.jarVersion}</a>
                                </li>
                            </#list>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>