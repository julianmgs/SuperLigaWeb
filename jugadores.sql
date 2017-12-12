-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2016 a las 22:47:41
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sl_rosario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL,
  `dci` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `dci`, `nombre`, `apellido`) VALUES
(1, '4082608853', 'Julian', 'Pagano'),
(2, '3203791165', 'Matias', 'Gil'),
(3, '1201164353', 'Facundo', 'Gamero'),
(4, '39806558', 'Pedro', 'Daffunchio'),
(5, '9113338805', 'Valentin', 'Cocconi'),
(6, '62602181', 'Agustin', 'Perna'),
(7, '4115208197', 'Mauro', 'Zara'),
(8, '6102040934', 'Bruno', 'Pasquetta'),
(9, '6114972116', 'Jhon', 'Garcia'),
(10, '1425462', 'Enrique', 'Piedfort'),
(11, '1200470002', 'Carlos', 'Beltramini'),
(12, '6102033853', 'Maximiliano', 'Jaimes'),
(13, '1201991136', 'Gonzalo', 'Calvano'),
(14, '11427016', 'Leandro', 'Esperanza'),
(15, '7103608818', 'Cristian', 'Monti'),
(16, '7103615008', 'Maximo', 'Bindelli'),
(17, '21427370', 'Cristian', 'Tapia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dci` (`dci`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
