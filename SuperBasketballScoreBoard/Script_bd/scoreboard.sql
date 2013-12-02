-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-12-2013 a las 18:00:51
-- Versión del servidor: 5.5.25a
-- Versión de PHP: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `scoreboard`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `nombre` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `num_jugadores` int(1) NOT NULL,
  `color` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `lugar` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_torneo` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombre_torneo` (`nombre_torneo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `numero` int(2) NOT NULL,
  `nombre_equipo` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `nombre_torneo` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nombre_equipo` (`nombre_equipo`),
  KEY `nombre_torneo` (`nombre_torneo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=7 ;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE IF NOT EXISTS `partido` (
  `local` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `visitante` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `fecha` varchar(12) COLLATE latin1_spanish_ci DEFAULT NULL,
  `hora` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre_torneo` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `nombre_torneo` (`nombre_torneo`),
  KEY `visitante` (`visitante`),
  KEY `local` (`local`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE IF NOT EXISTS `resultado` (
  `ganador` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `pun_local` int(3) NOT NULL,
  `pun_vist` int(3) NOT NULL,
  `id_partido` int(10) NOT NULL,
  UNIQUE KEY `id_partido` (`id_partido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE IF NOT EXISTS `torneo` (
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `num_equipos` int(2) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`nombre_torneo`) REFERENCES `torneo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`nombre_equipo`) REFERENCES `equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jugador_ibfk_2` FOREIGN KEY (`nombre_torneo`) REFERENCES `torneo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`local`) REFERENCES `equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`visitante`) REFERENCES `equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partido_ibfk_3` FOREIGN KEY (`nombre_torneo`) REFERENCES `torneo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD CONSTRAINT `resultado_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
