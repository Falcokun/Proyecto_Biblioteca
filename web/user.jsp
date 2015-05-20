<%--
  Created by IntelliJ IDEA.
  User: Ricardo
  Date: 13/05/2015
  Time: 08:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Biblioteca</title>
    <%@include file='partials/cssimports.jsp' %>
</head>
<body>
<%@include file='partials/navigation.jsp' %>

<c:set var="libros" scope="session" value="${sessionScope.libros}"/>

<div class="container">
    <div class="section">

        <div class="section">
            <table class="responsive-table centered striped">
                <thead>
                <tr>
                    <th data-field="id">Codigo Interno</th>
                    <th data-field="titulo">Titulo</th>
                    <th data-field="autor">Autor</th>
                    <th data-field="carrera">Carrera</th>
                    <th data-field="edicion">Edicion</th>
                    <th data-field="cantidad">Cantidad</th>
                    <th data-field="solicitar">Solicitar</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="i" items="${libros}">
                    <tr>
                        <td><a href="./detalleLibro?id=${i.id}"><c:out value="${i.id}"/></a></td>
                        <td><c:out value="${i.titulo}"/></td>
                        <td><c:out value="${i.autor}"/></td>
                        <td><c:out value="${i.carrera}"/></td>
                        <td><c:out value="${i.edicion}"/></td>
                        <td><c:out value="${i.cantidad}"/></td>
                        <td><a class="waves-effect waves-light btn-flat"><i class="mdi-navigation-check green-text"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file='partials/javascriptimports.jsp' %>
</body>
</html>
