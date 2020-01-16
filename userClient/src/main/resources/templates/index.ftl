<!DOCTYPE html>
<html>
<head>
    <#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${staticServer}vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${staticServer}vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="${staticServer}css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="/http/googleapis.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${staticServer}css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${staticServer}css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${staticServer}img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="/http/maxcdn-htm15shiv.js"></script>
    <script src="/http/maxcdn-respond.js"></script><![endif]-->
</head>
<body>
<div class="page">
    <!-- Main Navbar-->
    <header class="header">
        <nav class="navbar">
            <!-- Search Box-->
            <!-- <div class="search-box">
              <button class="dismiss"><i class="icon-close"></i></button>
              <form id="searchForm" action="#" role="search">
                <input type="search" placeholder="What are you looking for..." class="form-control">
              </form>
            </div> -->
            <div class="container-fluid">
                <div class="navbar-holder d-flex align-items-center justify-content-between">
                    <!-- Navbar Header-->
                    <div class="navbar-header">
                        <!-- Navbar Brand --><a href="index.ftl" class="navbar-brand d-none d-sm-inline-block">
                        <div class="brand-text d-none d-lg-inline-block">
                            <span>操作面板</span>
                         </div>
                        <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                    </a>
                        <!-- Toggle Button--><a id="toggle-btn" href="#"
                                                class="menu-btn active"><span></span><span></span><span></span></a>
                    </div>
                    <!-- Navbar Menu -->
                    <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                        <!-- Search-->
                        <!-- <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li> -->
                        <!-- Notifications-->
                        <li class="nav-item dropdown"><a id="notifications" rel="nofollow" data-target="#" href="#"
                                                         data-toggle="dropdown" aria-haspopup="true"
                                                         aria-expanded="false" class="nav-link"><i
                                class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">
                                <li><a rel="nofollow" href="#" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-envelope bg-green"></i>You
                                            have 6 new messages
                                        </div>
                                        <div class="notification-time">
                                            <small>4 minutes ago</small>
                                        </div>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have
                                            2 followers
                                        </div>
                                        <div class="notification-time">
                                            <small>4 minutes ago</small>
                                        </div>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-upload bg-orange"></i>Server
                                            Rebooted
                                        </div>
                                        <div class="notification-time">
                                            <small>4 minutes ago</small>
                                        </div>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item">
                                    <div class="notification">
                                        <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have
                                            2 followers
                                        </div>
                                        <div class="notification-time">
                                            <small>10 minutes ago</small>
                                        </div>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center">
                                    <strong>view all notifications </strong></a></li>
                            </ul>
                        </li>
                        <!-- Messages                        -->
                        <li class="nav-item dropdown"><a id="messages" rel="nofollow" data-target="#" href="#"
                                                         data-toggle="dropdown" aria-haspopup="true"
                                                         aria-expanded="false" class="nav-link"><i
                                class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                            <ul aria-labelledby="notifications" class="dropdown-menu">
                                <li><a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"><img src="${staticServer}img/avatar-1.jpg" alt="..."
                                                                  class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5">Jason Doe</h3><span>Sent You Message</span>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"><img src="${staticServer}img/avatar-2.jpg" alt="..."
                                                                  class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5">Frank Williams</h3><span>Sent You Message</span>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item d-flex">
                                    <div class="msg-profile"><img src="${staticServer}img/avatar-3.jpg" alt="..."
                                                                  class="img-fluid rounded-circle"></div>
                                    <div class="msg-body">
                                        <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                                    </div>
                                </a></li>
                                <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center">
                                    <strong>Read all messages </strong></a></li>
                            </ul>
                        </li>
                        <!-- Languages dropdown    -->
                        <!-- <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                          <ul aria-labelledby="languages" class="dropdown-menu">
                            <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/DE.png" alt="English" class="mr-2">German</a></li>
                            <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/FR.png" alt="English" class="mr-2">French                                         </a></li>
                          </ul>
                        </li> -->
                        <!-- Logout    -->
                        <li class="nav-item"><a href="/logout" class="nav-link logout"> <span
                                class="d-none d-sm-inline">退出登录</span><i
                                class="fa fa-sign-out"></i></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="page-content d-flex align-items-stretch">
        <!-- Side Navbar -->
        <nav class="side-navbar" style="min-height: 650px">
            <!-- Sidebar Header-->
            <div class="sidebar-header d-flex align-items-center">
                <div class="avatar"><img src="${staticServer}img/avatar-1.jpg" alt="..."
                                         class="img-fluid rounded-circle"></div>
                <div class="title">
                    <h1 class="h4">${user.uname}</h1>
                    <p>${power.powerName}</p>
                </div>
            </div>
            <!-- Sidebar Navidation Menus--><span class="heading">主菜单</span>
            <ul class="list-unstyled">
                <li class="active"><a href="/User/goto/jarRepository" target="MyFrame"><i class="icon-page"></i>JAR包库 </a></li>

                <@security.authorize access="hasRole('SuperAmdin')">
                <li><a href="/User/goto/user" target="MyFrame"> <i class="icon-user"></i>用户管理 </a></li>
                </@security.authorize>

                <@security.authorize access="hasRole('NormalAdmin')">
                <li><a href="/User/goto/jarManage" target="MyFrame"> <i class="icon-page"></i>JAR包管理 </a></li>
                </@security.authorize>

                <@security.authorize access="hasRole('NormalAdmin')">
                <li><a href="/User/goto/straw" target="MyFrame"> <i class="icon-page"></i>投稿审核 </a></li>
                </@security.authorize>

                <span class="heading">个人管理</span>
                <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse">
                    <i class="icon-interface-windows"></i> 个人中心 </a>
                    <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <li><a href="/User/goto/iuploadJar?uid=${user.uid}" target="MyFrame">jar包上传</a></li>
                        <li><a href="/User/goto/selfJarManage?uid=${user.uid}" target="MyFrame">我的jar包</a></li>
                        <li><a href="/User/goto/iMy?uid=${user.uid}" target="MyFrame">个人信息</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <iframe name="MyFrame" src="/User/goto/jarRepository" class="table-responsive">

        </iframe>
    </div>
</div>
<!-- JavaScript files-->
<script src="${staticServer}vendor/jquery/jquery.min.js"></script>
<script src="${staticServer}vendor/popper.js/umd/popper.min.js"></script>
<script src="${staticServer}vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${staticServer}vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="${staticServer}vendor/chart.js/Chart.min.js"></script>
<script src="${staticServer}vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="${staticServer}js/charts-home.js"></script>
<!-- Main File-->
<script src="${staticServer}js/front.js"></script>

</body>
</html>