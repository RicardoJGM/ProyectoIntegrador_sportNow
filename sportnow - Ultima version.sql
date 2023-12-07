-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2023 a las 01:48:52
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sportnow`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `events`
--

CREATE TABLE `events` (
  `id_events` int(10) NOT NULL,
  `event_id` varchar(100) DEFAULT NULL,
  `event_startD` datetime DEFAULT NULL,
  `event_finishedD` datetime DEFAULT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `id_localLocation` int(2) DEFAULT NULL,
  `event_address` varchar(200) DEFAULT NULL,
  `event_desc` varchar(200) DEFAULT NULL,
  `event_sponsors` varchar(200) DEFAULT NULL,
  `id_eventsTP` varchar(150) DEFAULT NULL,
  `id_events_activityTP` varchar(150) DEFAULT NULL,
  `event_currentP` int(3) DEFAULT NULL,
  `event_maxP` int(3) DEFAULT NULL,
  `id_user` int(6) DEFAULT NULL,
  `id_status` int(3) DEFAULT NULL,
  `imagen_url` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `events`
--

INSERT INTO `events` (`id_events`, `event_id`, `event_startD`, `event_finishedD`, `startTime`, `endTime`, `id_localLocation`, `event_address`, `event_desc`, `event_sponsors`, `id_eventsTP`, `id_events_activityTP`, `event_currentP`, `event_maxP`, `id_user`, `id_status`, `imagen_url`) VALUES
(1, 'E1', '2023-12-15 06:42:56', '2023-12-17 06:42:56', '00:00:00', '00:00:00', 1, 'Fraccionamiento Reforma', 'Prueba 1', 'Sponsor1, Sponsor2, Sponsor3, Sponsor4', NULL, NULL, 0, 50, 3, 1, ''),
(2, 'E2', '2023-12-20 09:38:34', '2023-12-20 09:38:34', '00:00:00', '00:00:00', 2, 'Fraccionamiento Costa dorada', 'Prueba2', 'Sponsor1, Sponsor2', NULL, NULL, 0, 50, 3, 1, ''),
(5, 'prueba1', '2023-12-06 00:00:00', '2023-12-07 00:00:00', '00:00:00', '00:00:00', 1, 'Prueba1', 'Prueba1', 'Prueba1', NULL, NULL, 0, 50, 3, 1, ''),
(7, 'Prueba2', '2023-12-06 00:00:00', '2023-12-07 00:00:00', '00:00:00', '00:00:00', 21, 'Prueba2', 'Prueba2', 'Prueba2', NULL, NULL, 0, 50, 3, 1, ''),
(8, 'Prueba3', '2023-12-06 00:00:00', '2023-12-17 00:00:00', '17:00:00', '18:00:00', 17, 'Prueba3', 'Prueba3', 'Prueba3', NULL, NULL, 0, 50, 3, 1, ''),
(9, 'Prueba4', '2023-12-06 00:00:00', '2023-12-07 00:00:00', '17:00:00', '18:00:00', 19, 'Prueba4', 'Prueba4', 'Prueba4', 'Social event Charitable cause', 'Soccer Baseball ', 0, 50, 3, 1, ''),
(10, 'Prueba5', '0000-00-00 00:00:00', '2023-12-07 00:00:00', '17:00:00', '18:00:00', 34, 'Prueba5', 'Prueba5', 'Prueba5', 'Social event Charitable cause', 'Soccer Baseball ', 0, 50, 3, 1, ''),
(11, 'Prueba6', '2023-12-01 00:00:00', '2023-12-02 00:00:00', '17:00:00', '18:00:00', 1, 'Prueba1', 'Prueba4', 'Prueba5', 'Social event Charitable cause', 'Soccer Baseball ', 0, 50, 3, 1, ''),
(12, 'Partido juvenil tiburones rojos', '2023-12-06 00:00:00', '2023-12-06 00:00:00', '00:00:00', '00:00:00', 1, 'Estadio Luis Pirata Fuente, Veracruz', 'Partido amistoso juvenil patrocinado por los Tiburones Rojos de Veracruz. Cupo de 50 participantes, deben traer su uniforme o ropa deportiva. Entrada gratuita', 'Equipo Tiburones Rojos ', 'Social event ', 'Soccer ', 0, 50, 3, 1, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forums`
--

CREATE TABLE `forums` (
  `id_forum` int(10) NOT NULL,
  `forum_id` varchar(10) DEFAULT NULL,
  `id_user` int(6) DEFAULT NULL,
  `id_events` int(10) DEFAULT NULL,
  `id_status` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `forums`
--

INSERT INTO `forums` (`id_forum`, `forum_id`, `id_user`, `id_events`, `id_status`) VALUES
(1, 'F1', 3, 1, 1),
(2, 'F2', 3, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `locallocation`
--

CREATE TABLE `locallocation` (
  `id_localLocation` int(2) NOT NULL,
  `loc_localNumber` varchar(3) DEFAULT NULL,
  `loc_localName` varchar(40) DEFAULT NULL,
  `id_status` int(3) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `locallocation`
--

INSERT INTO `locallocation` (`id_localLocation`, `loc_localNumber`, `loc_localName`, `id_status`) VALUES
(1, '001', 'Acajete', 1),
(2, '002', 'Acatlán', 1),
(3, '003', 'Acayucan', 1),
(4, '004', 'Actopan', 1),
(5, '005', 'Acula', 1),
(6, '006', 'Acultzingo', 1),
(7, '007', 'Camarón de Tejeda', 1),
(8, '008', 'Alpatláhuac', 1),
(9, '009', 'Alto Lucero de Gutiérrez Barrios', 1),
(10, '010', 'Altotonga', 1),
(11, '011', 'Alvarado', 1),
(12, '012', 'Amatitlán', 1),
(13, '013', 'Naranjos Amatlán', 1),
(14, '014', 'Amatlán de los Reyes', 1),
(15, '015', 'Angel R. Cabada', 1),
(16, '016', 'La Antigua', 1),
(17, '017', 'Apazapan', 1),
(18, '018', 'Aquila', 1),
(19, '019', 'Astacinga', 1),
(20, '020', 'Atlahuilco', 1),
(21, '021', 'Atoyac', 1),
(22, '022', 'Atzacan', 1),
(23, '023', 'Atzalan', 1),
(24, '024', 'Tlaltetela', 1),
(25, '025', 'Ayahualulco', 1),
(26, '026', 'Banderilla', 1),
(27, '027', 'Benito Juárez', 1),
(28, '028', 'Boca del Río', 1),
(29, '029', 'Calcahualco', 1),
(30, '030', 'Camerino Z. Mendoza', 1),
(31, '031', 'Carrillo Puerto', 1),
(32, '032', 'Catemaco', 1),
(33, '033', 'Cazones de Herrera', 1),
(34, '034', 'Cerro Azul', 1),
(35, '035', 'Citlaltépetl', 1),
(36, '036', 'Coacoatzintla', 1),
(37, '037', 'Coahuitlán', 1),
(38, '038', 'Coatepec', 1),
(39, '039', 'Coatzacoalcos', 1),
(40, '040', 'Coatzintla', 1),
(41, '041', 'Coetzala', 1),
(42, '042', 'Colipa', 1),
(43, '043', 'Comapa', 1),
(44, '044', 'Córdoba', 1),
(45, '045', 'Cosamaloapan de Carpio', 1),
(46, '046', 'Cosautlán de Carvajal', 1),
(47, '047', 'Coscomatepec', 1),
(48, '048', 'Cosoleacaque', 1),
(49, '049', 'Cotaxtla', 1),
(50, '050', 'Coxquihui', 1),
(51, '051', 'Coyutla', 1),
(52, '052', 'Cuichapa', 1),
(53, '053', 'Cuitláhuac', 1),
(54, '054', 'Chacaltianguis', 1),
(55, '055', 'Chalma', 1),
(56, '056', 'Chiconamel', 1),
(57, '057', 'Chiconquiaco', 1),
(58, '058', 'Chicontepec', 1),
(59, '059', 'Chinameca', 1),
(60, '060', 'Chinampa de Gorostiza', 1),
(61, '061', 'Las Choapas', 1),
(62, '062', 'Chocamán', 1),
(63, '063', 'Chontla', 1),
(64, '064', 'Chumatlán', 1),
(65, '065', 'Emiliano Zapata', 1),
(66, '066', 'Espinal', 1),
(67, '067', 'Filomeno Mata', 1),
(68, '068', 'Fortín', 1),
(69, '069', 'Gutiérrez Zamora', 1),
(70, '070', 'Hidalgotitlán', 1),
(71, '071', 'Huatusco', 1),
(72, '072', 'Huayacocotla', 1),
(73, '073', 'Hueyapan de Ocampo', 1),
(74, '074', 'Huiloapan de Cuauhtémoc', 1),
(75, '075', 'Ignacio de la Llave', 1),
(76, '076', 'Ilamatlán', 1),
(77, '077', 'Isla', 1),
(78, '078', 'Ixcatepec', 1),
(79, '079', 'Ixhuacán de los Reyes', 1),
(80, '080', 'Ixhuatlán del Café', 1),
(81, '081', 'Ixhuatlancillo', 1),
(82, '082', 'Ixhuatlán del Sureste', 1),
(83, '083', 'Ixhuatlán de Madero', 1),
(84, '084', 'Ixmatlahuacan', 1),
(85, '085', 'Ixtaczoquitlán', 1),
(86, '086', 'Jalacingo', 1),
(87, '087', 'Xalapa', 1),
(88, '088', 'Jalcomulco', 1),
(89, '089', 'Jáltipan', 1),
(90, '090', 'Jamapa', 1),
(91, '091', 'Jesús Carranza', 1),
(92, '092', 'Xico', 1),
(93, '093', 'Jilotepec', 1),
(94, '094', 'Juan Rodríguez Clara', 1),
(95, '095', 'Juchique de Ferrer', 1),
(96, '096', 'Landero y Coss', 1),
(97, '097', 'Lerdo de Tejada', 1),
(98, '098', 'Magdalena', 1),
(99, '099', 'Maltrata', 1),
(100, '100', 'Manlio Fabio Altamirano', 1),
(101, '101', 'Mariano Escobedo', 1),
(102, '102', 'Martínez de la Torre', 1),
(103, '103', 'Mecatlán', 1),
(104, '104', 'Mecayapan', 1),
(105, '105', 'Medellín de Bravo', 1),
(106, '106', 'Miahuatlán', 1),
(107, '107', 'Las Minas', 1),
(108, '108', 'Minatitlán', 1),
(109, '109', 'Misantla', 1),
(110, '110', 'Mixtla de Altamirano', 1),
(111, '111', 'Moloacán', 1),
(112, '112', 'Naolinco', 1),
(113, '113', 'Naranjal', 1),
(114, '114', 'Nautla', 1),
(115, '115', 'Nogales', 1),
(116, '116', 'Oluta', 1),
(117, '117', 'Omealca', 1),
(118, '118', 'Orizaba', 1),
(119, '119', 'Otatitlán', 1),
(120, '120', 'Oteapan', 1),
(121, '121', 'Ozuluama de Mascareñas', 1),
(122, '122', 'Pajapan', 1),
(123, '123', 'Pánuco', 1),
(124, '124', 'Papantla', 1),
(125, '125', 'Paso del Macho', 1),
(126, '126', 'Paso de Ovejas', 1),
(127, '127', 'La Perla', 1),
(128, '128', 'Perote', 1),
(129, '129', 'Platón Sánchez', 1),
(130, '130', 'Playa Vicente', 1),
(131, '131', 'Poza Rica de Hidalgo', 1),
(132, '132', 'Las Vigas de Ramírez', 1),
(133, '133', 'Pueblo Viejo', 1),
(134, '134', 'Puente Nacional', 1),
(135, '135', 'Rafael Delgado', 1),
(136, '136', 'Rafael Lucio', 1),
(137, '137', 'Los Reyes', 1),
(138, '138', 'Río Blanco', 1),
(139, '139', 'Saltabarranca', 1),
(140, '140', 'San Andrés Tenejapan', 1),
(141, '141', 'San Andrés Tuxtla', 1),
(142, '142', 'San Juan Evangelista', 1),
(143, '143', 'Santiago Tuxtla', 1),
(144, '144', 'Sayula de Alemán', 1),
(145, '145', 'Soconusco', 1),
(146, '146', 'Sochiapa', 1),
(147, '147', 'Soledad Atzompa', 1),
(148, '148', 'Soledad de Doblado', 1),
(149, '149', 'Soteapan', 1),
(150, '150', 'Tamalín', 1),
(151, '151', 'Tamiahua', 1),
(152, '152', 'Tampico Alto', 1),
(153, '153', 'Tancoco', 1),
(154, '154', 'Tantima', 1),
(155, '155', 'Tantoyuca', 1),
(156, '156', 'Tatatila', 1),
(157, '157', 'Castillo de Teayo', 1),
(158, '158', 'Tecolutla', 1),
(159, '159', 'Tehuipango', 1),
(160, '160', 'Álamo Temapache', 1),
(161, '161', 'Tempoal', 1),
(162, '162', 'Tenampa', 1),
(163, '163', 'Tenochtitlán', 1),
(164, '164', 'Teocelo', 1),
(165, '165', 'Tepatlaxco', 1),
(166, '166', 'Tepetlán', 1),
(167, '167', 'Tepetzintla', 1),
(168, '168', 'Tequila', 1),
(169, '169', 'José Azueta', 1),
(170, '170', 'Texcatepec', 1),
(171, '171', 'Texhuacán', 1),
(172, '172', 'Texistepec', 1),
(173, '173', 'Tezonapa', 1),
(174, '174', 'Tierra Blanca', 1),
(175, '175', 'Tihuatlán', 1),
(176, '176', 'Tlacojalpan', 1),
(177, '177', 'Tlacolulan', 1),
(178, '178', 'Tlacotalpan', 1),
(179, '179', 'Tlacotepec de Mejía', 1),
(180, '180', 'Tlachichilco', 1),
(181, '181', 'Tlalixcoyan', 1),
(182, '182', 'Tlalnelhuayocan', 1),
(183, '183', 'Tlapacoyan', 1),
(184, '184', 'Tlaquilpa', 1),
(185, '185', 'Tlilapan', 1),
(186, '186', 'Tomatlán', 1),
(187, '187', 'Tonayán', 1),
(188, '188', 'Totutla', 1),
(189, '189', 'Tuxpan', 1),
(190, '190', 'Tuxtilla', 1),
(191, '191', 'Ursulo Galván', 1),
(192, '192', 'Vega de Alatorre', 1),
(193, '193', 'Veracruz', 1),
(194, '194', 'Villa Aldama', 1),
(195, '195', 'Xoxocotla', 1),
(196, '196', 'Yanga', 1),
(197, '197', 'Yecuatla', 1),
(198, '198', 'Zacualpan', 1),
(199, '199', 'Zaragoza', 1),
(200, '200', 'Zentla', 1),
(201, '201', 'Zongolica', 1),
(202, '202', 'Zontecomatlán de López y Fuentes', 1),
(203, '203', 'Zozocolco de Hidalgo', 1),
(204, '204', 'Agua Dulce', 1),
(205, '205', 'El Higo', 1),
(206, '206', 'Nanchital de Lázaro Cárdenas del Río', 1),
(207, '207', 'Tres Valles', 1),
(208, '208', 'Carlos A. Carrillo', 1),
(209, '209', 'Tatahuicapan de Juárez', 1),
(210, '210', 'Uxpanapa', 1),
(211, '211', 'San Rafael', 1),
(212, '212', 'Santiago Sochiapan', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `msgs_forums`
--

CREATE TABLE `msgs_forums` (
  `id_msg_forum` int(11) NOT NULL,
  `msg_forum` varchar(200) DEFAULT NULL,
  `id_user` int(6) DEFAULT NULL,
  `id_forum` int(10) DEFAULT NULL,
  `id_status` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `status`
--

CREATE TABLE `status` (
  `id_status` int(3) NOT NULL,
  `status_desc` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `status`
--

INSERT INTO `status` (`id_status`, `status_desc`) VALUES
(1, 'Activo'),
(2, 'Activo'),
(3, 'Deshabilitado'),
(4, 'No Verificado'),
(5, 'Verificado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(6) NOT NULL,
  `user_clave` varchar(20) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `user_lastnames` varchar(50) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_birthdate` date DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `id_user_firebase` varchar(64) DEFAULT NULL,
  `id_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `user_clave`, `user_name`, `user_lastnames`, `user_email`, `user_birthdate`, `user_password`, `id_user_firebase`, `id_status`) VALUES
(3, 'ricardoJGM', 'ricardo', 'garcia mejia', 'example@gmail.com', '2023-12-06', '123456', 'euiwaeoiwua', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id_events`),
  ADD KEY `fk_id_user_events_idx` (`id_user`),
  ADD KEY `fk_id_status_events_idx` (`id_status`),
  ADD KEY `fk_id_localLocation_events_idx` (`id_localLocation`);

--
-- Indices de la tabla `forums`
--
ALTER TABLE `forums`
  ADD PRIMARY KEY (`id_forum`),
  ADD KEY `fk_id_events_forum_idx` (`id_events`),
  ADD KEY `fk_id_users_forums_idx` (`id_user`),
  ADD KEY `fk_id_status_forums_idx` (`id_status`);

--
-- Indices de la tabla `locallocation`
--
ALTER TABLE `locallocation`
  ADD PRIMARY KEY (`id_localLocation`),
  ADD KEY `fk_id_status_localLocation_idx` (`id_status`);

--
-- Indices de la tabla `msgs_forums`
--
ALTER TABLE `msgs_forums`
  ADD PRIMARY KEY (`id_msg_forum`),
  ADD KEY `fk_id_forum_msgs_idx` (`id_forum`),
  ADD KEY `fk_id_status_msgs_idx` (`id_status`);

--
-- Indices de la tabla `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `fk_id_status_users_idx` (`id_status`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `events`
--
ALTER TABLE `events`
  MODIFY `id_events` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `forums`
--
ALTER TABLE `forums`
  MODIFY `id_forum` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `locallocation`
--
ALTER TABLE `locallocation`
  MODIFY `id_localLocation` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=213;

--
-- AUTO_INCREMENT de la tabla `msgs_forums`
--
ALTER TABLE `msgs_forums`
  MODIFY `id_msg_forum` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `fk_id_localLocation_events` FOREIGN KEY (`id_localLocation`) REFERENCES `locallocation` (`id_localLocation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_status_events` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_user_events` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `forums`
--
ALTER TABLE `forums`
  ADD CONSTRAINT `fk_id_events_forum` FOREIGN KEY (`id_events`) REFERENCES `events` (`id_events`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_status_forums` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_users_forums` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `locallocation`
--
ALTER TABLE `locallocation`
  ADD CONSTRAINT `fk_id_status_localLocation` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `msgs_forums`
--
ALTER TABLE `msgs_forums`
  ADD CONSTRAINT `fk_id_forum_msgs` FOREIGN KEY (`id_forum`) REFERENCES `forums` (`id_forum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_status_msgs` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_id_status_users` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
