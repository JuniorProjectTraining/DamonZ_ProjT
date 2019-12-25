<%--
  Created by IntelliJ IDEA.
  Date: 2019/5/22
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<html>
<head>
    <title>用户注册</title>
    <title>页面布局</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            font-family: "微软雅黑";
        }

        .box {
            border: 2px solid #CCCCFF;
            border-radius: 10px;
            width: 30vw;
            height: 60vh;
            background: gainsboro;
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
        }

        .container {
            padding: 0;
            margin: 0;
            height: 100vh;
        }

        .header {
            width: 100vw;
            height: 60px;
            background: orange;
        }

        .content {
            position: relative;
            width: 80vw;
            margin: 0 auto;
        }

        .content_footer {
            position: fixed;
            height: 30px;
            background: orangered;
            width: 100vw;
            bottom: 0;
        }

        .left {
            height: 100%;
            width: 50vw;
            float: left;
            background: orchid;
        }

        .right {
            height: 100%;
            width: 30vw;
            float: right;
            background: none;
            position: relative;
        }


        ul {
            list-style: none;
            overflow: hidden;
        }

        #nav {
            width: 100%;
            height: 8vh;
            text-align: center;
            font-size: 3vh;
            color: #8cc5e6;
            line-height: 8vh;
            background: #f4f5ff;
            cursor: pointer;
        }

        #nav li {
            width: 50%;
            height: 8vh;
            float: left;
            border: 1px;
        }

        #nav li.active {
            background: #c5faff;
            color: black;
        }

        #content {
            width: 100%;
            height: 30vw;
            position: relative;
            border: 1px;
            border-top: none;
        }

        #content li {
            width: 100%;
            height: 100%;
            position: absolute;
            display: none
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <label style="align:center">This is a HEADER.</label>
    </div>
    <div class="content">
        <div class="left">
            <img src="../image/eva12.jpg" style="width:50vw;height:100%"/>
        </div>
        <div class="right">
            <div class="box">
                <ul id="nav">
                    <li style="float:left" class="active">登录</li>
                    <li>注册</li>
                </ul>

                <ul id="content">
                    <li style="display: block">
                        <div>
                            <form name="userLoginForm" method="post" action="LogInServlet">
                                <table style="height: 39vh;width:100%;border-collapse: separate;border-spacing: 0 6vh"
                                       border="0">
                                    <tr style="height: 16vh">
                                        <td>
                                            <table style="height:16vh;width: 100%;border-collapse:separate; border-spacing:0 2vh"
                                                   border="0" align="right" cellpadding="10" cellspacing="5">
                                                <tr>
                                                    <td align="center" valign="bottom">
                                                        <input name="uname" type="text" id="uname"
                                                               style="width: 24vw;height: 7vh;font-size:2.5vh"
                                                               maxlength="50"
                                                               required placeholder="请输入用户名">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="center" valign="bottom">
                                                        <input name="pwd" type="password" id="pwd"
                                                               style="width: 24vw;height: 7vh;font-size:2.5vh"
                                                               maxlength="50"
                                                               required pattern="^\d{6}$"
                                                               oninvalid="setCustomValidity('请输入6位数字')"
                                                               placeholder="请输入密码">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center">
                                            <input type="submit"
                                                   style="width: 24vw;height: 7vh;font-size:3vh;background: dodgerblue ;color: white;cursor: pointer"
                                                   name="Submit" value="提交">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </li>
                    <li>
                        <div>
                            <form name="userRegisterForm" method="post" action="Register">
                                <table style="height: 39vh;width:100%;border-collapse: separate;border-spacing: 0 6vh"
                                       border="0">
                                    <tr style="height: 26vh">
                                        <td>
                                            <table style="height:16vh;width: 100%;border-collapse:separate; border-spacing:0 2vh"
                                                   border="0" align="right" cellpadding="5" cellspacing="5">
                                                <tr>
                                                    <td align="center" valign="bottom">
                                                        <input name="uid" type="text" id="uid"
                                                               style="width: 24vw;height: 7vh;font-size:2.5vh"
                                                               maxlength="50"
                                                               required placeholder="请输入用户名">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="center" valign="bottom">
                                                        <input name="password" type="password" id="password"
                                                               style="width: 24vw;height: 7vh;font-size:2.5vh"
                                                               maxlength="50"
                                                               required pattern="^\d{6}$"
                                                               oninvalid="setCustomValidity('请输入6位数字')"
                                                               placeholder="请输入密码">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align="center" valign="bottom">
                                                        <input name="confirmPassword" type="password"
                                                               id="confirmPassword"
                                                               style="width: 24vw;height: 7vh;font-size:2.5vh"
                                                               maxlength="50"
                                                               required pattern="^\d{6}$"
                                                               oninvalid="setCustomValidity('请输入6位数字')"
                                                               placeholder="请确认密码">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center">
                                            <input type="submit"
                                                   style="width: 24vw;height: 7vh;font-size:3vh;background: dodgerblue ;color: white;cursor: pointer"
                                                   name="Submit" value="提交">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="content_footer">
        <a href="http://localhost:8080/ServeletDemo_war_exploded2/main.jsp">test</a>
    </div>
</div>

</body>
</html>

<script language="javascript">
    function checkForm(form) {
        /*if(form.password.value!=form.confirmPassword.value){
            alert("请保持前后一致！")
            form.confirmPassword.focus();
            return false;
        }
        return true;
*/
    }

    var nav = document.getElementById("nav");
    var navlist = nav.children;
    var con = document.getElementById("content");
    var conlist = con.children;
    for (var i = 0; i < navlist.length; i++) {
        navlist[i].index = i;
        navlist[i].onclick = function () {
            for (var m = 0; m < conlist.length; m++) {
                navlist[m].className = "";
                conlist[m].style.display = "none";
            }
            this.className = "active";
            conlist[this.index].style.display = "block";
        }
    }

</script>

