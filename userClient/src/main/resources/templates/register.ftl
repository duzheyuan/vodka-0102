<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="/css/fontastic.css">

    <!-- Google fonts - Poppins -->
    <!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">-->
    <link rel="stylesheet" href="/http/googleapis.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="/img/favicon.ico">
    <!--wifi链接js modify zhou -->
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <script src="/http/maxcdn-htm15shiv.js"></script>
    <script src="/http/maxcdn-respond.js"></script>
</head>
<script>
    function checkName() {
        var uname = document.getElementById("register-username").value;
        $.ajax({
            url: '/User/checkRegisterUname?uname=' + uname,
            contentType: 'application/json;charset=UTF-8',   //contentType表示媒体类型信息：application/json 表示以json格式输出。
            dataType: "json",
            type: 'get',
            success: function (data) {
                if (data.info == 'true') {
                    document.getElementById("spanCheck").style.display = 'block';
                } else {
                    document.getElementById("spanCheck").style.display = 'none';
                }
            },
        });
    }

    function checkForm() {
        if (document.getElementById("spanCheck").style.display == 'none') {
            return true;
        } else {
            return false;
        }
    }
</script>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>注册</h1>
                            </div>
                            <p>伏特加专业代码模板下载平台<</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form class="form-validate" action="/User/goto/register" method="post"
                                  onsubmit="return checkForm()">
                                <div class="form-group">
                                    <input id="register-username" type="text" name="uname" onblur="checkName()"
                                           required data-msg="注册账号不能为空！" class="input-material">
                                    <label for="register-username" class="label-material">注册账号</label>
                                    <span class="label label-default" style="color: red;display: none;"
                                          id="spanCheck">账号已经存在</span>
                                </div>
                                <!--邮箱注册，暂时不用-->
                                <!-- <div class="form-group">
                                   <input id="register-email" type="email" name="registerEmail" required data-msg="Please enter a valid email address" class="input-material">
                                   <label for="register-email" class="label-material">Email Address      </label>
                                 </div>-->
                                <div class="form-group">
                                    <input id="register-password" type="password" name="upassword" required
                                           data-msg="注册密码不能为空！" class="input-material">
                                    <label for="register-password" class="label-material">注册密码</label>
                                </div>
                                <!--条框同意按钮，暂时不用-->
                                <!--<div class="form-group terms-conditions">
                                  <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                                  <label for="register-agree">Agree the terms and policy</label>
                                </div>-->
                                <!--注册按钮，modify-->
                                <!-- <div class="form-group">
                                   <button id="regidter" type="submit" name="registerSubmit" class="btn btn-primary">Register</button>
                                 </div>-->
                                <div class="form-group">
                                    <button id="regidter" type="submit" name="registerSubmit" class="btn btn-primary">
                                        注册
                                    </button>
                                </div>
                            </form>
                            <small>已经有账号了?</small>
                            <a href="/User/login" class="signup">登录</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--<div class="copyrights text-center">
      <p>Copyright &copy; 2019.Company name All rights reserved.More Templates
        <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
        - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
    </div>-->

</div>
<!-- JavaScript files-->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/popper.js/umd/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="/vendor/chart.js/Chart.min.js"></script>
<script src="/vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="/js/front.js"></script>
</body>
</html>