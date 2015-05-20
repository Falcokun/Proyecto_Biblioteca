<%--
  Created by IntelliJ IDEA.
  User: Ricardo
  Date: 13/05/2015
  Time: 08:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Ricardo
  Date: 28/04/2015
  Time: 07:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Administracion</title>
    <%@include file='partials/cssimports.jsp' %>
</head>
<body>
<%@include file='partials/navigation.jsp' %>

<c:set var="libros" scope="session" value="${sessionScope.libros}"/>

<div class="container">
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
                <th data-field="estado">Visible</th>
                <th data-field="modificar">Modificar</th>
                <th data-field="eliminar">Eliminar</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="i" items="${libros}">
                <tr>
                    <td><c:out value="${i.id}"/></td>
                    <td><c:out value="${i.titulo}"/></td>
                    <td><c:out value="${i.autor}"/></td>
                    <td><c:out value="${i.carrera}"/></td>
                    <td><c:out value="${i.edicion}"/></td>
                    <td><c:out value="${i.cantidad}"/></td>
                    <td><c:if test="${i.activo}">Activo</c:if><c:if test="${!i.activo}">No Activo</c:if></td>
                    <td><a class="waves-effect waves-light btn-flat" href="./editarLibro?id=${i.id}"><i
                            class="mdi-editor-mode-edit green-text"></i></a></td>
                    <td><a class="waves-effect waves-light btn-flat" onclick="eliminarLibro('${i.id}')"><i
                            class="mdi-content-clear red-text"></i></a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light red right modal-trigger" href="#modaladd"><i
                    class="mdi-content-add"></i></a>
        </div>
    </div>
</div>

<div id="modaladd" class="modal">
    <form action="/registrarLibro" method="post">
        <div class="modal-content">
            <h4>Agregar Libro</h4>

            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <input id="titulo" name="titulo" type="text" class="validate" required>
                <label for="titulo">Titulo</label>
            </div>
            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <input id="autor" name="autor" type="text" class="validate" required>
                <label for="autor">Autor</label>
            </div>
            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <input id="carrera" name="carrera" type="text" class="validate" required>
                <label for="carrera">Carrera</label>
            </div>
            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <input id="edicion" name="edicion" type="text" class="validate" required>
                <label for="edicion">Edicion</label>
            </div>
            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <input id="cantidad" name="cantidad" type="number" class="validate" required>
                <label for="cantidad">Cantidad</label>
            </div>

            <div class="input-field col s12">
                <div class="switch">
                    <label>
                        Desactivado
                        <input type="checkbox" name="estado" id="edit">
                        <span class="lever"></span>
                        Activo
                    </label>
                </div>
            </div>
            <br><br>

            <div class="input-field col s12">
                <i class="mdi-action-account-circle prefix"></i>
                <textarea id="descripcion" name="descripcion" class="materialize-textarea validate" required></textarea>
                <label for="descripcion">Descripcion</label>
            </div>


        </div>
        <div class="modal-footer">
            <button class="btn waves-effect waves-light" type="submit" name="action">Aceptar
                <i class="mdi-content-send right"></i>
            </button>
        </div>
    </form>
</div>


<%@include file='partials/javascriptimports.jsp' %>
</body>
</html>
