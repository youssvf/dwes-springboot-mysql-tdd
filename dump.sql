-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 26-10-2023 a las 15:47:33
-- Versión del servidor: 8.0.34
-- Versión de PHP: 8.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `manager`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicios`
--

CREATE TABLE `ejercicios` (
  `id` int UNSIGNED NOT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `ejercicios`
--

INSERT INTO `ejercicios` (`id`, `titulo`) VALUES
(1, 'Flexiones'),
(2, 'Sentadillas'),
(3, 'Plancha');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenamientos`
--

CREATE TABLE `entrenamientos` (
  `id` int UNSIGNED NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `entrenamientos`
--

INSERT INTO `entrenamientos` (`id`, `fecha`) VALUES
(1, '2023-10-25'),
(2, '2023-10-26'),
(3, '2023-10-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenamientos_ejercicios`
--

CREATE TABLE `entrenamientos_ejercicios` (
  `entrenamiento` int UNSIGNED NOT NULL,
  `ejercicio` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `entrenamientos_ejercicios`
--

INSERT INTO `entrenamientos_ejercicios` (`entrenamiento`, `ejercicio`) VALUES
(1, 1),
(3, 1),
(1, 2),
(2, 2),
(2, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entrenamientos`
--
ALTER TABLE `entrenamientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entrenamientos_ejercicios`
--
ALTER TABLE `entrenamientos_ejercicios`
  ADD PRIMARY KEY (`entrenamiento`,`ejercicio`),
  ADD KEY `ejercicio` (`ejercicio`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrenamientos_ejercicios`
--
ALTER TABLE `entrenamientos_ejercicios`
  ADD CONSTRAINT `entrenamientos_ejercicios_ibfk_1` FOREIGN KEY (`entrenamiento`) REFERENCES `entrenamientos` (`id`),
  ADD CONSTRAINT `entrenamientos_ejercicios_ibfk_2` FOREIGN KEY (`ejercicio`) REFERENCES `ejercicios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
