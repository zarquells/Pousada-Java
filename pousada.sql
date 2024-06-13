-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13/06/2024 às 03:48
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pousada`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_client`
--

CREATE TABLE `tbl_client` (
  `pk_IDclient` int(11) NOT NULL,
  `name_client` varchar(60) NOT NULL,
  `cpf_client` char(11) NOT NULL,
  `ddd_client` int(2) NOT NULL,
  `phone_client` int(11) NOT NULL,
  `adress_client` int(8) NOT NULL,
  `email_client` varchar(120) NOT NULL,
  `password_client` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_client`
--

INSERT INTO `tbl_client` (`pk_IDclient`, `name_client`, `cpf_client`, `ddd_client`, `phone_client`, `adress_client`, `email_client`, `password_client`) VALUES
(1, 'Ana Silva', '52259381081', 11, 987654321, 12345678, 'ana.silva@email.com', 'ana'),
(2, 'Carlos Oliveira', '6978051071', 21, 876543210, 23456789, 'carlos.oliveira@email.com', 'carlos'),
(3, 'Maria Santos', '45430565075', 31, 765432109, 34567890, 'maria.santos@email.com', 'maria'),
(4, 'João Pereira', '68939786009', 41, 654321098, 45678901, 'joao.pereira@email.com', 'joao'),
(5, 'Juliana Lima', '6584163083', 51, 543210987, 56789012, 'juliana.lima@email.com', 'juliana'),
(6, 'Pedro Souza', '5486033087', 61, 432109876, 67890123, 'pedro.souza@email.com', 'pedro'),
(7, 'Luciana Costa', '38812538070', 71, 321098765, 78901234, 'luciana.costa@email.com', 'luciana'),
(8, 'Felipe Oliveira', '23235995005', 81, 210987654, 89012345, 'felipe.oliveira@email.com', 'felipe');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_report`
--

CREATE TABLE `tbl_report` (
  `pk_IDreport` int(11) NOT NULL,
  `fk_IDroom` int(11) DEFAULT NULL,
  `fk_IDclient` int(11) DEFAULT NULL,
  `new_checkin` date NOT NULL,
  `new_checkout` date NOT NULL,
  `date_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_report`
--

INSERT INTO `tbl_report` (`pk_IDreport`, `fk_IDroom`, `fk_IDclient`, `new_checkin`, `new_checkout`, `date_time`) VALUES
(1, 1, 1, '2024-06-01', '2024-06-08', '2024-05-14 00:21:18'),
(2, 3, 1, '2024-06-05', '2024-06-10', '2024-06-12 22:19:46'),
(3, 4, 1, '2024-06-01', '2024-06-12', '2024-06-12 22:40:02');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_report_cancel`
--

CREATE TABLE `tbl_report_cancel` (
  `pk_IDreport_cancel` int(11) NOT NULL,
  `fk_IDroom` int(11) DEFAULT NULL,
  `fk_IDclient` int(11) DEFAULT NULL,
  `old_checkin` date NOT NULL,
  `old_checkout` date NOT NULL,
  `date_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_room`
--

CREATE TABLE `tbl_room` (
  `pk_IDroom` int(11) NOT NULL,
  `description_room` varchar(120) NOT NULL,
  `price_room` double(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_room`
--

INSERT INTO `tbl_room` (`pk_IDroom`, `description_room`, `price_room`) VALUES
(1, 'Quarto Standard com vista para o mar', 180.00),
(2, 'Quarto Deluxe com varanda', 250.00),
(3, 'Suíte Executiva com jacuzzi', 400.00),
(4, 'Quarto Familiar com duas camas de solteiro', 220.00),
(5, 'Quarto Duplo com vista para o centro histórico', 160.00),
(6, 'Suíte Master com terraço privativo', 600.00),
(7, 'Quarto Econômico com banheiro privativo', 120.00),
(8, 'Quarto Triplo com vista para a cidade', 280.00),
(9, 'Suíte Presidencial com piscina privativa', 800.00),
(10, 'Quarto Standard com decoração regional', 150.00),
(11, 'Quarto Duplo com ar-condicionado', 170.00),
(12, 'Suíte Luxo com sala de estar', 500.00),
(13, 'Quarto Familiar com área de convivência', 300.00),
(14, 'Quarto Single com vista panorâmica', 130.00),
(15, 'Suíte Júnior com minibar', 350.00),
(16, 'Quarto Triplo com acesso para cadeirantes', 260.00),
(17, 'Quarto Deluxe com serviço de quarto 24 horas', 380.00),
(18, 'Suíte Premium com vista para o rio', 700.00),
(19, 'Quarto Standard com decoração contemporânea', 140.00),
(20, 'Quarto Duplo com café da manhã incluso', 200.00),
(21, 'Suíte Real com área de lazer privativa', 750.00),
(22, 'Quarto Familiar com espaço kids', 320.00),
(23, 'Quarto Single com escritório', 110.00),
(24, 'Suíte Presidencial com vista para o mar', 750.00),
(25, 'Quarto Triplo com banheira de hidromassagem', 380.00),
(26, 'Quarto Duplo com vista para o pátio interno', 190.00),
(27, 'Suíte Executiva com sala de reuniões', 450.00),
(28, 'Quarto Standard com varanda privativa', 170.00),
(29, 'Quarto Econômico com vista para o jardim', 110.00),
(30, 'Suíte Master com academia particular', 700.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_ticket`
--

CREATE TABLE `tbl_ticket` (
  `pk_IDticket` int(11) NOT NULL,
  `fk_IDroom` int(11) NOT NULL,
  `fk_IDclient` int(11) NOT NULL,
  `checkin_ticket` date NOT NULL,
  `checkout_ticket` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbl_ticket`
--

INSERT INTO `tbl_ticket` (`pk_IDticket`, `fk_IDroom`, `fk_IDclient`, `checkin_ticket`, `checkout_ticket`) VALUES
(1, 1, 1, '2024-06-01', '2024-06-08'),
(2, 3, 1, '2024-06-05', '2024-06-10'),
(3, 4, 1, '2024-06-01', '2024-06-12');

--
-- Acionadores `tbl_ticket`
--
DELIMITER $$
CREATE TRIGGER `report_delete` AFTER DELETE ON `tbl_ticket` FOR EACH ROW begin
	INSERT INTO tbl_report_cancel(fk_IDroom, fk_IDclient, old_checkin, old_checkout, date_time)
    VALUES (OLD.fk_IDroom, OLD.fk_IDclient, OLD.checkin_ticket, OLD.checkout_ticket, NOW());
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `report_update` AFTER INSERT ON `tbl_ticket` FOR EACH ROW begin
	INSERT INTO tbl_report(fk_IDroom, fk_IDclient, new_checkin, new_checkout, date_time)
    VALUES (NEW.fk_IDroom, NEW.fk_IDclient, NEW.checkin_ticket, NEW.checkout_ticket, NOW());
end
$$
DELIMITER ;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD PRIMARY KEY (`pk_IDclient`);

--
-- Índices de tabela `tbl_report`
--
ALTER TABLE `tbl_report`
  ADD PRIMARY KEY (`pk_IDreport`);

--
-- Índices de tabela `tbl_report_cancel`
--
ALTER TABLE `tbl_report_cancel`
  ADD PRIMARY KEY (`pk_IDreport_cancel`);

--
-- Índices de tabela `tbl_room`
--
ALTER TABLE `tbl_room`
  ADD PRIMARY KEY (`pk_IDroom`);

--
-- Índices de tabela `tbl_ticket`
--
ALTER TABLE `tbl_ticket`
  ADD PRIMARY KEY (`pk_IDticket`),
  ADD KEY `fk_IDroom` (`fk_IDroom`),
  ADD KEY `fk_IDclient` (`fk_IDclient`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_client`
--
ALTER TABLE `tbl_client`
  MODIFY `pk_IDclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `tbl_report`
--
ALTER TABLE `tbl_report`
  MODIFY `pk_IDreport` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_report_cancel`
--
ALTER TABLE `tbl_report_cancel`
  MODIFY `pk_IDreport_cancel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_room`
--
ALTER TABLE `tbl_room`
  MODIFY `pk_IDroom` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de tabela `tbl_ticket`
--
ALTER TABLE `tbl_ticket`
  MODIFY `pk_IDticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tbl_ticket`
--
ALTER TABLE `tbl_ticket`
  ADD CONSTRAINT `tbl_ticket_ibfk_1` FOREIGN KEY (`fk_IDroom`) REFERENCES `tbl_room` (`pk_IDroom`),
  ADD CONSTRAINT `tbl_ticket_ibfk_2` FOREIGN KEY (`fk_IDclient`) REFERENCES `tbl_client` (`pk_IDclient`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
