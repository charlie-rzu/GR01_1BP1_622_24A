<%--
  Created by IntelliJ IDEA.
  User: carla
  Date: 5/19/2024
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido a la tienda de videojuegos</title>
</head>
<body>
<h1>Bienvenido a la tienda de videojuegos</h1>
<form action="???" method="post">
<ul>
    <li class="search-option">
        <h2>Búsqueda por título</h2>
        <form action="catalogoFiltrado.jsp" method="get">
            <input type="text" name="titulo" placeholder="Escribe el título">
            <button type="submit">Buscar</button>
        </form>
    </li>
    <li class="search-option">
        <h2>Búsqueda por desarrollador</h2>
        <form action="catalogoFiltrado.jsp" method="get">
            <input type="text" name="desarrollador" placeholder="Escribe el nombre del desarrollador">
            <button type="submit">Buscar</button>
        </form>
    </li>
    <li class="search-option">
        <h2>Búsqueda por rango de precio</h2>
        <form action="catalogoFiltrado.jsp" method="get">
            <input type="text" name="precio_min" placeholder="Precio mínimo">
            <input type="text" name="precio_max" placeholder="Precio máximo">
            <button type="submit">Buscar</button>
        </form>
    </li>
</ul>
</body>
</html>
