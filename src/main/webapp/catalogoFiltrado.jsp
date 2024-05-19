<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.modelo.entidad.Videojuego" %>

<%--
  Created by IntelliJ IDEA.
  User: carla ruiz
  Date: 5/19/2024
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catálogo Filtrado de Videojuegos</title>
</head>
<body>
<h1>Catálogo Filtrado de Videojuegos</h1>
<%
    List<Videojuego> videojuegos = (List<Videojuego>) request.getSession().getAttribute("videojuegos");
    for (Videojuego videojuego : videojuegos) {
%>
<p><b>Juego N°: <%=videojuego.getIdVideojuego()%>
</b></p>
<p>Titulo: <%=videojuego.getTitulo()%>
</p>
<p>
    Empresa desarrolladora: <%=videojuego.getNombreDeDesarrollador()%>
</p>
<p>Precio: <%=videojuego.getPrecio()%>
</p>
<%
    }
%>
</body>
</html>
