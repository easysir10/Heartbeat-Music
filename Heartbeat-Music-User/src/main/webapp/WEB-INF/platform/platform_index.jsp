<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv=”X-UA-Compatible” content=”IE=edge,chrome=1”>
    <meta charset="utf-8">
    <title>心随乐动</title>
    <link rel="stylesheet" media="screen" href="css/bootstrap.css">
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/platform.css" />
    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/popper.js/1.15.0/popper.min.js"></script>
</head>
<body>
<div style="background-color:#EEEEEE">
    <div>
        <nav class="navbar navbar-expand-sm bg-danger navbar-dark" style="margin-bottom: 0px">
            <p class="nav_title">心随乐动</p>


            <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
                <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="platform_index">发现音乐 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="friend" href="rank">排行榜</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">歌单</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="play_list">我的音乐</a>
                    </li>
                    <c:if test="${user.user_type == 2}">
                    <li class="nav-item">
                        <a class="nav-link" href="admin_index">管理员后台</a>
                    </li>
                    </c:if>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="search" method="get">
                    <input class="form-control mr-sm-2" type="text" placeholder="音乐/用户" aria-label="Search" name="search">
                    <button class="glyphicon glyphicon-search" type="submit" style="float: left"></button>
                </form>
                <div class="login_out"></div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        ${user.user_name}
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="login_out">注销 <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <div style="width: 910px;height: 250px;margin-left: 275px;position: relative">
        <div id="demo" class="carousel slide" data-ride="carousel"  style="width: 910px;height: 250px">

            <!-- 指示符 -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
            </ul>

            <!-- 轮播图片 -->
            <div class="carousel-inner" style="float: left">
                <div class="carousel-item active">
                    <img src="img/demo1.jpg" style="margin-left:250px;">
                </div>
                <div class="carousel-item">
                    <img src="img/demo2.jpg" style="margin-left:250px;">
                </div>
                <div class="carousel-item">
                    <img src="img/demo3.jpg" style="margin-left:250px;">
                </div>
            </div>

            <!-- 左右切换按钮 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev"  style="background-color: #8a6d3b;width: 200px;height: 335px">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <div style="float: left;padding-left:500px;">
            <a class="carousel-control-next" href="#demo" data-slide="next"
               style="background-color: #8a6d3b;width: 200px;height: 335px">
                <span class="carousel-control-next-icon"></span>
            </a></div>
        </div>
    </div>
<div style="margin-top: 85px">
    <div class="container" style="padding-top: 40px;width:1200px;margin:auto;background-color: white;
border: solid #DDDDDD;border-width: 0px thin 0px ">
        <p style="font-size: 24px">热门推荐</p>
        <div style="float:left;">
            <hr style="padding-left: 22px;background-color: red;width:1080px;height: 2px">
        </div>

        <div class="recommend-one" style="float: left">

            <ul>
                <c:forEach items="${rePlayList}" var="replaylist">
                    <li style="list-style: none;float: left;padding-left: 30px">
                        <img src="${replaylist.recommend_album}" style="width: 160px;height: 160px" alt="">
                        <a href="recommend_list?id=${replaylist.id}&recommend_name=${replaylist.recommend_name}">
                            <p style="width:160px;height: 20px;color:black">${replaylist.recommend_name}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>
</div>
</body>
</html>
