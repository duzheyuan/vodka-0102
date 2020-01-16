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
                待审查Jar包名称：${jarNew.jarName}
            </h3>
            <dl class="dl-horizontal">
                <dt>
                    版本:
                </dt>
                <dd>
                    ${jarNew.jarVersion}
                </dd>
                <dt>
                    Jar大小:
                </dt>
                <dd>
                    ${jarNew.jarSize} MB
                </dd>
                <dt>
                    提交时间:
                </dt>
                <dd>
                    ${jarNew.jarUploadTime?date}
                </dd>
            </dl>
            <div>
                <h5 align="center">Jar包介绍</h5>
                ${jarDocument.document}
                <blockquote class="pull-right">
                    <small> 贡献者:<cite> ${jarNew.uname}</cite></small>
                </blockquote>
                <blockquote class="pull-right">
                    <small><a href="/JarCrud/downJar?jnID=${jarNew.jnID}">点击下载</a></small>
                </blockquote>
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