<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap.css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="jquery/js/jquery-1.12.4.min.js"></script>
</head>
<body style="text-align: center;background-size: 100%">
<form action="/register" method="post">
    <fieldset style="width: 40%;height: 25%;margin: 10% 35%;">
        <div class="form-group col-md-9">
            <h1>注册</h1>
        </div>

        <div class="form-group mb-5 col-md-9 ">
            <input class="form-control" type="text" placeholder="UserId" id="user_id" name="user_id">
        </div>

        <div class="form-group mb-5 col-md-9 ">
            <input class="form-control" type="text" placeholder="Username"  id="user_name" name="user_name">
        </div>

        <div class="form-group mb-5 col-md-9 ">
            <input class="form-control" type="text" placeholder="Password"  id="pwd" name="pwd">
        </div>

        <div class="input-group-lg mb-5 col-md-9 " style="margin-top: 10px">
            <a href="/login"><input class="btn btn-info" value="返回上一级" style="width: 140px;height: 45px"></a>
            <input class="btn btn-danger" id="reset" type="reset" value="取消" style="margin-left:10px;width: 80px;height: 45px">
            <input class="btn btn-info" id="submit" type="submit" value="创建"style="margin-left:10px;width: 80px;height: 45px">
        </div>
    </fieldset>
</form>
</body>

</html>