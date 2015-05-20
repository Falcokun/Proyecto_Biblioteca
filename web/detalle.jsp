<%--
  Created by IntelliJ IDEA.
  User: Ricardo
  Date: 19/05/2015
  Time: 04:51 PM
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

<c:set var="libro" scope="session" value="${sessionScope.libro}"/>

<div class="container">
    <div class="section">
        <form action="/editarLibro" method="post">
            <div class="modal-content">
                <h4>Editar Libro</h4>

                <div class="input-field col s12">
                    <i class="mdi-device-sd-storage prefix"></i>
                    <input id="idedit" name="idedit" type="text" class="validate" required readonly value="${libro.id}">
                    <label for="idedit">ID</label>
                </div>
                <div class="input-field col s12">
                    <i class="mdi-editor-format-color-text prefix"></i>
                    <input id="tituloedit" name="tituloedit" type="text" class="validate" readonly required
                           value="${libro.titulo}">
                    <label for="tituloedit">Titulo</label>
                </div>
                <div class="input-field col s12">
                    <i class="mdi-action-account-circle prefix"></i>
                    <input id="autoredit" name="autoredit" type="text" class="validate" readonly required
                           value="${libro.autor}">
                    <label for="autoredit">Autor</label>
                </div>
                <div class="input-field col s12">
                    <i class="mdi-social-school prefix"></i>
                    <input id="carreraedit" name="carreraedit" type="text" class="validate" readonly required
                           value="${libro.carrera}">
                    <label for="carreraedit">Carrera</label>
                </div>
                <div class="input-field col s12">
                    <i class="mdi-social-domain prefix"></i>
                    <input id="edicionedit" name="edicionedit" type="text" class="validate" readonly required
                           value="${libro.edicion}">
                    <label for="edicionedit">Edicion</label>
                </div>
                <div class="input-field col s12">
                    <i class="mdi-social-plus-one prefix"></i>
                    <input id="cantidadedit" name="cantidadedit" type="number" class="validate" readonly required
                           value="${libro.cantidad}">
                    <label for="cantidadedit">Cantidad</label>
                </div>

                <div class="input-field col s12">

                    <div class="switch">
                        <label>
                            Desactivado
                            <input disabled type="checkbox" name="estadoedit" id="edit"
                                   <c:if test="${libro.activo}">checked</c:if>>
                            <span class="lever"></span>
                            Activo
                        </label>
                    </div>
                </div>
                <br><br>

                <div class="input-field col s12">
                    <i class="mdi-navigation-menu prefix"></i>
                <textarea id="descripcionedit" name="descripcionedit" readonly class="materialize-textarea validate"
                          required>${libro.descripcion}</textarea>
                    <label for="descripcionedit">Descripcion</label>
                </div>

            </div>
            <div class="section"></div>
        </form>
    </div>
</div>
<%@include file='partials/javascriptimports.jsp' %>
</body>
</html>
