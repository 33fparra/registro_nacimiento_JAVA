<%-- 
    Document   : index
    Created on : 9-oct-2021, 21:22:10
    Author     : pipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluacion01</title>
    </head>
   <html>
  
    <body>
        <c:import url="opciones.jsp" />
        <c:url var="urlForm" value="/RegistrosServlet" />
        <h1>Registrar Nacimiento</h1>
        <form action="${urlForm}" method="post">
            <table>
            <tr>
                <td>Id:</td>
                <td><input type="number" name="id"/></td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nombre"/></td>
            </tr>
            <tr>
                <td>Peso:</td>
                <td><input type="number" name="peso"/></td>
            </tr>
            <tr>
                <td>Prematuro:</td>
                <td><input type="checkbox" id="id" name="prematuro" value="Si">Si <input type="checkbox" id="id" name="prematuro" value="Si"> No</td>
            </tr>
            <tr>
                <td>Sexo:</td>
                <td><input type="radio" id="sx" name="sexo" value='m'> Masculino <input type="radio" id="sx" name="sexo" value='f'> Femenino</td>
            </tr>
            <tr>
                <td>Centro:</td>
                <td>
                    <select name="centro"> 
                        <option value="Seleccione">Seleccione un Centro</option>
                        <option value="1">Hospital</option>
                        <option value="2">Clinica</option>
                        <option value="3">Domicilio</option>
                        <option value="4">Otro</option>
                    </select> 
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Registrar"/></td>
                <td><input type="reset" value="Limpiar"/></td>
            </tr>
            </table>
        </form>
            
        <%-- Mensaje del proceso --%>    
        <c:if test="${not empty respuesta}">
            <h2> <c:out value="${respuesta}" /></h2>
        </c:if></br> 
        
        
        <%-- Mensaje del errores (Si existen) --%>  
        <c:if test="${not empty error}">
            <ul>
                <c:forEach var="err" items="${error}">
                    <li><c:out value="${err}"/></li>  
                </c:forEach>
            </ul>
        </c:if> 
            
            
    </body>
</html>
