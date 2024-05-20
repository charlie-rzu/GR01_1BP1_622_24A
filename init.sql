-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2024 a las 03:41:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

CREATE DATABASE IF NOT EXISTS tiendavideojuegos;
USE tiendavideojuegos;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendavideojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videojuego`
--

CREATE TABLE IF NOT EXISTS `videojuego` (
                                            `idVideojuego` int(11) AUTO_INCREMENT PRIMARY KEY,
    `titulo` varchar(65) NOT NULL,
    `nombreDeDesarrollador` varchar(65) NOT NULL,
    `precio` double NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `videojuego`
--

INSERT INTO `videojuego` (`titulo`, `nombreDeDesarrollador`, `precio`) VALUES
                                                                           ( 'Super Mario', 'Nintendo', 59.99),
                                                                           ( 'The Legend of Zelda', 'Nintendo', 59.99),
                                                                           ( 'Minecraft', 'Mojang', 29.99),
                                                                           ( 'Grand Theft Auto V', 'Rockstar Games', 39.99),
                                                                           ( 'Call of Duty: Modern Warfare', 'Infinity Ward', 49.99),
                                                                           ( 'Fortnite', 'Epic Games', 0),
                                                                           ( 'FIFA 22', 'Electronic Arts', 59.99),
                                                                           ( 'Cyberpunk 2077', 'CD Projekt Red', 39.99),
                                                                           ( 'Among Us', 'InnerSloth', 4.99),
                                                                           ( 'League of Legends', 'Riot Games', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `videojuego`
--
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;