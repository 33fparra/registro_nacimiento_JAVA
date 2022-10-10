<%-- 
    Document   : index
    Created on : 30-ago-2016, 21:22:10
    Author     : yayi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Botillería</title>
    </head>
    <body>
        <c:import url="opciones.jsp" />
        <c:url var="urlForm" value="/agregarProductoServlet"/>
        <form action="${urlForm}" method="post">
            Código: <input type="text" name="codigo"/></br>
            Descripción <input type="text" name="descripcion"/></br>
            Categoría: <select name="categoria">
                <option value="Seleccione">Seleccione</option>
                <option value="Pisco">Pisco</option>
                <option value="Vino">Vino</option>
                <option value="Ron">Ron</option>
                <option value="Vodka">Vodka</option>
            </select></br>
            Precio <input type="text" name="precio"/></br>
            cc: <input type="text" name="cc"/></br>
            <input type="submit" value="Enviar"/>
            <input type="reset" value="Limpiar"/>
        </form>
        <c:if test="${not empty respuesta}">
            <h2> <c:out value="${respuesta}" /></h2>
        </c:if></br> 

        <c:if test="${not empty error}">
            <ul>
                <c:forEach var="err" items="${error}">
                    <li><c:out value="${err}"/></li>  
                </c:forEach>
            </ul>
        </c:if>    
    </body>
</html>
