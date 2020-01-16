<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                用户个人信息表
            </h3>
            <img alt="140x140" src="${staticServer}img/avatar-1.jpg" class="img-circle"/>

            <a id="modal-626053" href="#modal-container-626053" role="button" class="btn" data-toggle="modal">修改密码</a>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="form-group">
                        <label for="uname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="true" class="form-control" id="uname" value="${user.uname}"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" readonly="true" class="form-control" id="pwd"
                                   value="***********"/>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="form-group">
                        <label for="timeCre" class="col-sm-2 control-label">注册时间</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="true" class="form-control" id="timeCre"
                                   value="${user.createDate?date}"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="modal-container-626053" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                修改密码
                            </h4>
                        </div>
                        <div class="modal-body">
                            原密码： <input type="password" class="form-control" id="oldPWD"/>
                            新密码： <input type="password" class="form-control" id="newPWD"/>
                            确认密码：<input type="password" class="form-control" id="AgainNewPWD"/>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" onclick="changePWD(${user.uid})">保存</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    function changePWD(uid) {
        var oldPWD=document.getElementById("oldPWD").value;
        var newPWD=document.getElementById("newPWD").value;
        var AgainNewPWD=document.getElementById("AgainNewPWD").value;
        $.ajax({
            url: '/User/changePWD?oldPWD=' + oldPWD+'&newPWD='+newPWD+'&AgainNewPWD='+AgainNewPWD+'&uid='+uid,
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

</script><!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>