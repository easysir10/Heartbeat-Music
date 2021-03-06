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
                <a class="nav-link" id="friend" href="play_list.jsp">排行榜</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">歌单</a>
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
</div>
<div class="container" style="padding-top: 40px;width:1200px;margin:auto;background-color: white;
border: solid #DDDDDD;border-width: 0px thin 0px ">
    <div style="float: left">
    <img src="${recommendPlayList.recommend_album}"  alt="">
    </div>
    <div style="float: left">
        <p style="font-size: 24px;padding-left: 20px;">歌单：${recommendPlayList.recommend_name}</p>
        <p style="font-size: 17px;padding-left: 20px;">创建时间：${recommendPlayList.recommend_start}</p>
        <p style="font-size: 17px;padding-left: 20px;">共${totalRecommend}首歌</p>
        <p style="font-size: 24px;padding-left: 20px;padding-top: 35px">歌曲列表</p>
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

        <c:forEach items="${musicList}" var="musiclist" varStatus="status">
            <tr >
                <th scope="row">${requestScope.offset+status.index+1}</th>
                <td>  <a class="glyphicon glyphicon-play" href="recommend_list?id=${songlist.id}" style="text-decoration: none;color: #FF3300;"></a>
                    <a class="glyphicon glyphicon-save" href="recommend_list?id=${songlist.id}" style="text-decoration: none;color: #4B4B4B;"></a>
                <td>${musiclist.song_name}</td>
                <td><a style="text-decoration: none;color: #000000;" href="singer?singer_name=${musiclist.singer_name}">${musiclist.singer_name}</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="comment">
        <div>
            <p style="font-size: 24px;padding-top:20px;">评论</p>

        </div>
        <div style="float: left">
            <img src="/img/demo3.jpg" style="width: 50px;height: 50px" alt="">
        </div>

        <div style="float: left;padding-left: 10px">
            <textarea id="comment_content" class="form-control" rows="4" style="width: 1000px;padding-left: 10px" name="comment"></textarea>
            <div style="float: right;padding-right: 50px;padding-top: 10px">
                <button type="button" class="btn btn-info" id="comment_btn">评论</button>
            </div>
        </div>
<script>
        $("#comment_btn").click(function(){
            var c = $('#comment_content').val();
            if(c.length>0){
                $.post("/InsertComment",
                    {
                        comment: c
                    },function(){
                        alert("评论成功");
                    });
            }
            parent.location.reload();
            window.location.reload();
        })
</script>
        <div style="float: left;">
            <p style="font-size: 18px;padding-top: 35px">最新评论 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(共${totalRecommendComment}条评论)</p>
            <hr style="padding-left: 22px;background-color: #3c3c3c;width:1080px;height: 1px">


            <c:forEach items="${musicComments}" var="musiccomments">

                    <div style="float: left">
                        <img src="${musiccomments.user_profile}"  style="width: 50px;height: 50px" alt="">
                    </div>
                    <div>
                        <p style="font-size: 20px;padding-left: 60px;">${musiccomments.user_name}&nbsp;:&nbsp;${musiccomments.user_comment}</p>

                        <p style="font-size: 14px;padding-left: 60px;">${musiccomments.user_comment_time}</p>
                    </div>
                <hr style="padding-left: 22px;background-color: #dddddd;width:1080px;height: 1px">
            </c:forEach>


        </div>

    </div>


</div>
</div>
</body>
</html>
