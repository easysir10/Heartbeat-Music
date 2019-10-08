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
    <div>
    <ul class="nav nav-pills" style="background-color: #3c3c3c">
        <li style="float: left;margin-left: 150px;color: white;font-size: 20px;">
            <a href="admin_index" style="color: white;">歌曲管理</a></li>
        <li style="float: left;margin-left: 150px;font-size: 20px">
            <a href="admin_singer" style="color: white;">歌手管理</a></li>
        <li style="float: left;margin-left: 150px;color: white;font-size: 20px">
            <a href="admin_sort" style="color: white;">类别管理</a></li>
    </ul>
    </div>
    <div class="container" style="padding-top: 40px;width:1200px;margin:auto;background-color: white;
border: solid #DDDDDD;border-width: 0px thin 0px ">
        <div style="float:left;">
            <p style="font-size: 24px"><a href="#">添加歌曲</a></p>
        </div>
        <div style="float:left;">
            <hr style="padding-left: 22px;background-color: red;width:1080px;height: 2px">
        </div>

        <table class="table table-striped" style="border:1px solid  #DDDDDD">
            <thead>
            <th scope="col"></th>
            <th scope="col">操作</th>
            <th scope="col">音乐标题</th>
            <th scope="col">歌手</th>
            </thead>
            <tbody style="border:1px solid  #DDDDDD">

            <c:forEach items="${adMusicList}" var="admusiclist" varStatus="status">
                <tr >
                    <th scope="row">${requestScope.offset+status.index+1}</th>
                    <td>  <a class="glyphicon glyphicon-edit" href="recommend_list?id=${songlist.id}" style="text-decoration: none;color: #FF3300;"></a>
                        <a class="glyphicon glyphicon-trash" href="adDel?song_name=${admusiclist.song_name}&singer_name=${admusiclist.singer_name}" style="text-decoration: none;color: #4B4B4B;"></a>
                    <td>${admusiclist.song_name}</td>
                    <td><a style="text-decoration: none;color: #000000;" href="singer?singer_name=${admusiclist.singer_name}">${admusiclist.singer_name}</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
