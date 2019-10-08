<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
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
        <nav class="navbar navbar-expand-sm bg-danger navbar-dark" style="margin-bottom: 0px">
            <p class="nav_title">心随乐动</p>


    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="platform_index">发现音乐 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="friend" href="#">朋友</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">商城</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="play_list">我的音乐</a>
            </li>

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

    <div class="container" style="padding-top: 40px;width:1200px;margin:auto;background-color: white;
border: solid #DDDDDD;border-width: 0px thin 0px ">
<%--    <div class="album">--%>
<%--        <h1>播放列表</h1>--%>
<%--        <form action="${pageContext.request.contextPath}/upload"--%>
<%--              method="post" enctype="multipart/form-data">--%>
<%--            选择文件:<input type="file" name="file" width="120px"> <input--%>
<%--                type="submit" value="上传">--%>
<%--        </form>--%>
<%--        <hr>--%>
<%--        <form action="${pageContext.request.contextPath}/down"--%>
<%--              method="get">--%>
<%--            <input type="submit" value="下载">--%>
<%--        </form>--%>
<%--    </div>--%>
        <div style="float: left">
            <img src="${userMsg.user_profile}" style="width: 200px;height: 200px;" alt="">
        </div>
        <div style="float: left">
            <p style="font-size: 24px;padding-left: 20px;">歌单：${userMsg.user_name}的歌曲</p>
            <p style="font-size: 17px;padding-left: 20px;">共${totalSong}首歌</p>
            <p style="font-size: 24px;padding-left: 20px;padding-top: 75px">歌曲列表</p>
        </div>

        <div style="float:left;">
            <hr style="padding-left: 22px;background-color: red;width:1080px;height: 2px">
        </div>

        <table class="table table-striped" style="font-size: 20px;border:1px solid  #DDDDDD">
            <thead>
            <th scope="col"></th>
            <th scope="col">操作</th>
            <th scope="col">音乐标题</th>
            <th scope="col">歌手</th>
            </thead>
            <tbody style="border:1px solid  #DDDDDD">

            <c:forEach items="${Songlist}" var="songlist" varStatus="status">
                <tr>
                    <th scope="row">${requestScope.offset+status.index+1}</th>

                    <td>
                        <a class="glyphicon glyphicon-play" href="recommend_list?id=${songlist.id}" style="text-decoration: none;color: #FF3300;"></a>
                        <a class="glyphicon glyphicon-save" href="recommend_list?id=${songlist.id}" style="text-decoration: none;color: #4B4B4B;"></a>
                        <a class="glyphicon glyphicon-trash" href="delete?id=${songlist.id}" style="text-decoration: none;color: #4B4B4B;"></a>
                    </td>

                    <td>${songlist.song}</td>
                    <td>${songlist.singer}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</div>
<div style="margin-top:730px;position: fixed">
    <%--    <img src="img/nav.jpg" alt=""/>--%>
    <%--    <audio id="my"  controls="controls" loop="loop">--%>
    <%--        <source src="${song_src.src}" type="audio/mp3">Your browser does not support the audio element.--%>
    <%--    </audio>--%>
    <%--    <input type="button" οnclick="document.getElementById('my').play()" value='play'/>   <!-- 开始 -->--%>
    <%--    <input type="button" οnclick="document.getElementById('my').pause()" value='pause'/>  <!-- 暂停 -->--%>
    <%--    <input type="button" οnclick="document.getElementById('my').currentTime = 0.0" value='stop'/> <!-- 归零 -->--%>
    <audio id="audio" src="${music.song_src}"  loop="loop" autoplay="autoplay" ></audio>
    <!--audio End-->

    <!--播放控制按钮start-->
    <button id="control" class="">loading</button>
    <!--播放控制按钮end-->

    <!--时间进度条块儿start-->
    <section class="progressBar">
        <div class="progressBac"></div>
        <div class="speed" id="speed"></div>
        <div class="drag" id="drag"></div>
    </section>
    <!--时间进度条块儿end-->

    <!--播放时间start-->
    <div id="time"><div class="tiemDetail"><span class="currentTime" id="currentTime">00:00</span>/<span class="allTime" id="allTime">00:00</span></div></div>
    <!--播放时间end-->
    <!--歌曲信息start-->
    <div id="songInfo">没时间-Leinov<div class="shareImg"><img src="img/html5audio.jpg" alt=""></div></div>
    <!--歌曲信息end-->
</div>
</body>

</html>