<%--
  Created by IntelliJ IDEA.
  User: Ricardo
  Date: 28/04/2015
  Time: 07:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Screen</title>
    <%@include file='partials/cssimports.jsp' %>
</head>
<body>
<%@include file='partials/navigation.jsp' %>

<div class="container">

    <div class="section">
        <div class="row">
            <div class="valign-wrapper">
                <div class="valign">
                    <form class="col s8 m6  offset-s4 offset-m2">
                        <div class="input-field col s12">
                            <i class="mdi-action-account-circle prefix"></i>
                            <input id="user" name="user" type="text" class="validate" required>
                            <label for="user">Usuario</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="mdi-notification-vpn-lock prefix"></i>
                            <input id="password" name="password" type="password" class="validate" required>
                            <label for="password">Contraseña</label>
                        </div>
                        <div class="input-field col s4 offset-4">
                            <button class="btn waves-effect waves-light" type="submit" name="action" formmethod="post"
                                    formaction="login">
                                Login<i class="mdi-content-send right"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file='partials/javascriptimports.jsp' %>
</body>
</html>
