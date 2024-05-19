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
<ul>
    <li class="search-option">
        <h2>Búsqueda por título</h2>
        <form action="SvBusquedaTitulo" method="get">
            <input type="text" name="titulo" placeholder="Escribe el título">
            //<input type="hidden" name="tipoFiltro" value="titulo">
            <input type="submit" value="Buscar">
        </form>
    </li>
    <li class="search-option">
        <h2>Búsqueda por desarrollador</h2>
        <form action="SvBusquedaDesarrollador" method="get">

            <input type="text" name="desarrollador" placeholder="Escribe el nombre del desarrollador">
            //<input type="hidden" name="tipoFiltro" value="desarrollador">
            <input type="submit" value="Buscar">
        </form>
    </li>
    <li class="search-option">
        <h2>Búsqueda por rango de precio</h2>
        <form action="SvBusquedaRangoPrecio" method="get">
            <input type="range" name="rangoPrecio" min="5" max="150">
            <input type="hidden" name="tipoFiltro" value="rangoPrecio">
            <input type="submit">Buscar</input>
        </form>
    </li>
</ul>
</body>
</html>
