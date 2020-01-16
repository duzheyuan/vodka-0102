<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成功页面</title>
</head>
<body>
<script src="/vendor/jquery/jquery.min.js"></script>
<script>
    $(function () {
        setInterval(returnLogin,1000)
    });
    var ms = 5;// 定义全局变量,几秒之后自动跳转
    // 跳转函数
    function returnLogin(){
        if(ms>0){

            document.getElementById("return_area").innerHTML="<span style='color: red'>恭喜注册成功！ <strong>"+ms+"</strong>秒后将自动跳转至登录界面...</span><a href='/User/goto/login' style='color: blue'>直接跳转</a>";
        }else{
            window.location.href="/User/goto/login";
        }
        ms--;// 每调用一次减减
    }


</script>
<div id="return_area"><!-- 注册成功后,该部分将会被替换成跳转提示 -->
    <!--嵌套内容-->
</div>
</body>
</html>