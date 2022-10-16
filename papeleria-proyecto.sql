-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 16-10-2022 a las 20:12:20
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `papeleria-proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL COMMENT 'Identifica el producto.',
  `nombre` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre de la categoria'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nombre`) VALUES
(1, 'Utiles'),
(2, 'Papel Crepe'),
(3, 'Carpetas'),
(4, 'Acrilicos'),
(5, 'Adhesivos'),
(6, 'Minas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idProducto` int(11) NOT NULL COMMENT 'Identifica el producto.',
  `idProveedor` int(11) NOT NULL COMMENT 'Identifica el proveedor',
  `fechaRegistro` date NOT NULL COMMENT 'Fecha que resgistra la venta.',
  `cantidad` int(11) NOT NULL COMMENT 'Cantidad de productos.',
  `valorUnitario` int(11) NOT NULL COMMENT 'Valor por unidad',
  `codigoVenta` int(11) NOT NULL COMMENT 'Identificador.',
  `idinventario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idProducto`, `idProveedor`, `fechaRegistro`, `cantidad`, `valorUnitario`, `codigoVenta`, `idinventario`) VALUES
(1, 1, '2022-10-14', 2, 2000, 1, 0),
(2, 2, '2022-10-14', 10, 3000, 2, 0),
(3, 3, '2022-10-14', 15, 4000, 3, 0),
(6, 1, '2022-10-16', 50, 200, 1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `papeleria`
--

CREATE TABLE `papeleria` (
  `idPapeleria` int(11) NOT NULL COMMENT 'Identifica las papelerias.',
  `nombrePapeleria` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre papeleria.',
  `celularPapeleria` int(11) NOT NULL COMMENT 'Numero de contacto de la papeleria.',
  `dirreccionPapeleria` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Numero de ubiccaion de la papeleria.',
  `direccionpapeleria` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `papeleria`
--

INSERT INTO `papeleria` (`idPapeleria`, `nombrePapeleria`, `celularPapeleria`, `dirreccionPapeleria`, `direccionpapeleria`) VALUES
(100, 'DistriPapeles', 311456783, 'Calle 34 #22-2', NULL),
(101, 'Papeleria Sonny', 34096528, 'Calle 40# 79-4', NULL),
(103, 'Creativos del papel', 5576960, 'Calle 94 #24-5', NULL),
(104, 'Cromática papeleria', 8774574, 'Calle 1 #45-34', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL COMMENT 'Numero de identificacion del producto.',
  `descripcionProducto` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Describe las caracteristicas del producto.',
  `idCategoria` int(11) NOT NULL COMMENT 'Categoria del producto, descripcion la clase del producto existente de la papeleria. ',
  `idProveedor` int(11) NOT NULL COMMENT 'Numero de identificacion del provedor.',
  `idprovedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `descripcionProducto`, `idCategoria`, `idProveedor`, `idprovedor`) VALUES
(1, 'Cuaderno', 1, 1, NULL),
(2, 'Papel Crepe Azul', 2, 3, NULL),
(3, 'Barra Silicona', 5, 2, NULL),
(6, 'minas de esfero', 6, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provedor`
--

CREATE TABLE `provedor` (
  `idProveedor` int(11) NOT NULL COMMENT 'Numero de identificacion del provedor.',
  `empresa` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `celularProveedor` int(11) NOT NULL COMMENT 'Numero de celular para contactar al provedor.',
  `emailProveedor` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Correo electronico del provedor.',
  `direccionEmpresa` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Dirrecion de empresa encargada de proveer los prductos.',
  `nombreVendedor` varchar(16) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre vendedor.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `provedor`
--

INSERT INTO `provedor` (`idProveedor`, `empresa`, `celularProveedor`, `emailProveedor`, `direccionEmpresa`, `nombreVendedor`) VALUES
(1, 'Norma', 31129086, 'norma@gmail.co', 'calle #9-45', 'Jairo Suarez'),
(2, 'Manare', 7215854, 'manare@gmail.co', 'CALLE 33 N 28 12', 'Nicolas Borbón'),
(3, 'Stic', 4454577, 'stic@hotmail.com', 'Calle 4 #67-3', 'Luis Perez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL COMMENT 'Identifica el numero del perfil del usuario.',
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Nombre del usuario.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL COMMENT 'Identificacion del usuario.',
  `nombreUno` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Primer nombre del usaurio.',
  `nombreDos` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Segundo nombre del usuario.',
  `apellidoUno` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Primer apellido del usuario.',
  `apellidoDos` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Segundo apellido del usuario.',
  `celular` bigint(11) NOT NULL COMMENT 'Numero de contacto del usuario.',
  `direccion` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Lugar de residencia del usuario.',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL COMMENT 'Correo electronico del usuario.',
  `rol` int(11) NOT NULL COMMENT 'Perfil que ocupa el usuario.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUno`, `nombreDos`, `apellidoUno`, `apellidoDos`, `celular`, `direccion`, `email`, `rol`) VALUES
(1, 'Sonia', 'Andrea', 'Castro', 'Molano', 31081695, 'Vereda,Riolanco', 'soniaandreac@gmail.com', 1),
(2, 'Jorge', 'Luis', 'Perez', 'Rofriguez', 5576960, 'Calle 10 # 5-51', 'jro@gmail.com', 2),
(3, 'Santiago ', 'N/A', 'Garcia ', ' Mojica', 3224856076, 'carrera 18 D bi', 'santiago5231_@hotmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL COMMENT 'Identifica el codigo de la venta',
  `idPapeleria` int(11) NOT NULL COMMENT 'Identifica la papeleria.',
  `idUsuario` int(11) NOT NULL COMMENT 'Identifica al usuario.',
  `fechaRegistro` date NOT NULL COMMENT 'Es la fecha que regitra la venta.',
  `idpapeleeria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `idPapeleria`, `idUsuario`, `fechaRegistro`, `idpapeleeria`) VALUES
(1, 100, 1, '2022-10-14', NULL),
(2, 104, 2, '2022-10-07', NULL),
(3, 103, 2, '2022-10-14', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD KEY `inventario-provedor` (`idProveedor`),
  ADD KEY `inventario-producto` (`idProducto`),
  ADD KEY `inventario-ventas` (`codigoVenta`);

--
-- Indices de la tabla `papeleria`
--
ALTER TABLE `papeleria`
  ADD PRIMARY KEY (`idPapeleria`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `producto-categoria` (`idCategoria`),
  ADD KEY `producto-provedor` (`idProveedor`),
  ADD KEY `FKtco42sl8pggcl5oor1vyqpyh9` (`idprovedor`);

--
-- Indices de la tabla `provedor`
--
ALTER TABLE `provedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `usuario-rol` (`rol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `ventas-papeleria` (`idPapeleria`),
  ADD KEY `ventas-usuario` (`idUsuario`),
  ADD KEY `FK7vcljvnwmdlp46nvnb1fe0xat` (`idpapeleeria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifica el producto.', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `papeleria`
--
ALTER TABLE `papeleria`
  MODIFY `idPapeleria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifica las papelerias.', AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero de identificacion del producto.', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `provedor`
--
ALTER TABLE `provedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero de identificacion del provedor.', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifica el numero del perfil del usuario.', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificacion del usuario.', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identifica el codigo de la venta', AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario-producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `inventario-provedor` FOREIGN KEY (`idProveedor`) REFERENCES `provedor` (`idProveedor`),
  ADD CONSTRAINT `inventario-ventas` FOREIGN KEY (`codigoVenta`) REFERENCES `ventas` (`idVenta`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FKtco42sl8pggcl5oor1vyqpyh9` FOREIGN KEY (`idprovedor`) REFERENCES `provedor` (`idProveedor`),
  ADD CONSTRAINT `producto-categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `producto-provedor` FOREIGN KEY (`idProveedor`) REFERENCES `provedor` (`idProveedor`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario-rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FK7vcljvnwmdlp46nvnb1fe0xat` FOREIGN KEY (`idpapeleeria`) REFERENCES `papeleria` (`idPapeleria`),
  ADD CONSTRAINT `ventas-papeleria` FOREIGN KEY (`idPapeleria`) REFERENCES `papeleria` (`idPapeleria`),
  ADD CONSTRAINT `ventas-usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
