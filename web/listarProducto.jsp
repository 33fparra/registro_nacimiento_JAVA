<%-- 
    Document   : listarProducto
    Created on : 30-ago-2016, 21:22:38
    Author     : yayi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
         <c:import url="opciones.jsp"/>
          <h1>Mis Productos</h1>
         <c:if test="${not empty sessionScope.registro.listaProductos}">
            <table name="tablaDatos" align="left" border="1" cellpadding="3" >
                <tr>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>Categoría</th>
                    <th>Precio</th>
                    <th>cc</th>
                    <th></th>
                </tr> 
                <c:forEach var="p" items="${sessionScope.registro.listaProductos}">

                    <tr><td> <c:out value="${p.codigo}"/> </td>
                        <td> <c:out value="${p.descripcion}"/> </td>
                        <td> <c:out value="${p.categoria}"/> </td>
                        <td> <c:out value="${p.precio}"/> </td>
                        <td> <c:out value="${p.cc}"/> </td>
                        <td>
                        <c:url var="urlEliminar" value="/listarProductoServlet"/>
                        <form action="${urlEliminar}" method="POST">
                            <input type="hidden" name="codigo" value="${p.codigo}" />
                            <input type="submit" value="Eliminar" />
                        </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <BR/><BR/><BR/>
        <c:if test="${not empty mensaje}">
            <h2><c:out value="${mensaje}"/></h2>
        </c:if>
    </body>
</html>
