<%-- 
    Document   : listarRegistro
    Created on : 9-oct-2022, 21:22:38
    Author     : pipe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
    </head>
     <body>
        <c:import url="opciones.jsp" />
        <h1>Lista de Nacimientos</h1>
        <c:if test="${not empty sessionScope.listado.lstRegistros}">
            <table name="tablaDatos" align="left" border="1" cellpadding="3" >
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Peso</th>
                    <th>Prematuro</th>
                    <th>Sexo</th>
                    <th>Fecha nacimiento</th>
                    <th>Centro</th>
                    <th></th>
                </tr> 
                <c:forEach var="p" items="${sessionScope.listado.lstRegistros}">

                    <tr><td> <c:out value="${p.id}"/> </td>
                        <td> <c:out value="${p.nombre}"/> </td>
                        <td> <c:out value="${p.peso}"/> </td>
                        <td> 
                            <c:if test="${p.prematuro == true}">
                                <c:out value="Si"/>
                            </c:if>
                            <c:if test="${p.prematuro == false}">
                                <c:out value="No"/>
                            </c:if>
                        
                        </td>
                        <td> 
                            <c:if test="${p.sexo == 'M'}">
                                <c:out value="Masculino"/>
                            </c:if>
                            <c:if test="${p.sexo == 'F'}">
                                <c:out value="Femenino"/>
                            </c:if>
                        </td>
                        <td> <c:out value="${p.fechaFormato}"/> </td>
                        <td>Centro <c:out value="${p.centro}"/> </td>
                        <td>
                        <c:url var="urlEliminar" value="/ListarRegistroServlet"/>
                        <form action="${urlEliminar}" method="POST">
                            <input type="hidden" name="codigo" value="${p.id}" />
                            <input type="submit" value="Eliminar" />
                        </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <div style="margin-top: 100px">
            <br/><br/>
        <p><c:if test="${not empty mensaje}">
            <h2><c:out value="${mensaje}"/></h2>
        </c:if></p>
        </div>
        
    </body>
</html>
