<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/platform.css" />
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="jquery/js/jquery-1.12.4.min.js"></script>



    <script type="text/javascript">
        $(function(){
            //点击图片切换验证码
            $("#vcodeImg").click(function(){
                this.src="get_cpacha?vl=4&w=160&h=40&t="+new Date().getTime();
            });


        })
    </script>
</head>
<body style="text-align: center;background-size: 100%">
<form action="/login" method="post">
<fieldset style="width: 30%;height: 25%;margin: 10% 35%;">

    <div class="form-group col-md-9">
        <h1>登陆心随乐动</h1>
    </div>

    <div class="form-group-lg mb-5 col-md-9 ">
        <input type="text" class="form-control" placeholder="用户ID" id="user_id" name="user_id">
    </div>

    <div class="form-group-lg mb-5 col-md-9" style="margin-top: 20px">
        <input type="text" class="form-control" placeholder="密码" id="pwd" name="pwd"  >
    </div>

    <div class="form-group mb-5 " style="margin-left: 15px">
        <div style="float: left">
        <input type="text" class="form-control"  placeholder="验证码" name="vcode" style="margin-top: 20px"></div>
        <div style="float: left;margin-left: 20px;margin-top: 20px"><img title="点击图片切换验证码" id="vcodeImg" src="get_cpacha" ></div>
    </div>

    <div class="input-group-lg mb-5 col-md-9" style="margin-top: 10px">
        <input class="btn btn-info" id="submitBtn" type="submit" value="登陆" style="width: 80px;height: 45px">
        <a href="/register"><input class="btn btn-info" value="注册" style="margin-left:10px;width: 80px;height: 45px"></a>
    </div>
</fieldset>
</form>
</body>

</html>