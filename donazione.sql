-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 26-Mar-2019 às 20:43
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `donazione`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acao`
--

CREATE TABLE `acao` (
  `id` int(11) NOT NULL,
  `cadastro` datetime DEFAULT NULL,
  `carga_horaria` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `fim` datetime DEFAULT NULL,
  `inicio` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campanha`
--

CREATE TABLE `campanha` (
  `id` int(11) NOT NULL,
  `arrecadado` decimal(19,2) DEFAULT NULL,
  `cadastro` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `doacao_minima` decimal(19,2) DEFAULT NULL,
  `habilitada` tinyint(4) NOT NULL,
  `meta` decimal(19,2) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campanha_acao`
--

CREATE TABLE `campanha_acao` (
  `campanha_id` int(11) NOT NULL,
  `acao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `colaborador`
--

CREATE TABLE `colaborador` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `cpf_ou_cnpj` varchar(18) DEFAULT NULL,
  `como_colaborar` varchar(250) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `profissao` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `colaborador`
--

INSERT INTO `colaborador` (`id`, `nome`, `celular`, `email`, `logradouro`, `numero`, `bairro`, `cep`, `complemento`, `cpf_ou_cnpj`, `como_colaborar`, `perfil`, `profissao`, `senha`) VALUES
(2, 'AILTON BRAGA MAUES', '91999999999', 'myemail@mail.org', 'PASSAGEM MARIO', '1978', 'UMARIZAL', '66000-000', 'RUA NOVA ENTRE LOMAS E ENEAS PINHEIRO', '78945612378', 'SERVIÇO VOLUNTÁRIOS', '1', 'MÉDICO', '123456'),
(3, 'JOÃO NUNES BRITO', '91999999999', NULL, NULL, NULL, 'UMARIZAL', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'JOÃO NUNES BRITO JR', '91999999999', NULL, NULL, NULL, 'UMARIZAL', '66083-023', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `colaborador_acao`
--

CREATE TABLE `colaborador_acao` (
  `colaborador_id` int(11) NOT NULL,
  `acao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `doacao`
--

CREATE TABLE `doacao` (
  `id` int(11) NOT NULL,
  `cadastro` datetime DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `colaborador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `doacao`
--

INSERT INTO `doacao` (`id`, `cadastro`, `total`, `colaborador`) VALUES
(12, '2019-03-19 00:00:00', '400.00', NULL),
(13, '2019-03-19 00:00:00', '300.00', NULL),
(14, '2019-03-19 00:00:00', '300.00', NULL),
(15, '2019-03-19 03:00:00', '200.00', 2),
(18, '2019-03-19 00:00:00', '200.00', 5),
(19, '2019-03-19 00:00:00', '800.00', 5),
(20, '2019-03-25 00:00:00', '850.00', 2),
(21, '2019-03-25 00:00:00', '1850.00', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `doacao_item_doacaos`
--

CREATE TABLE `doacao_item_doacaos` (
  `doacao_id` int(11) NOT NULL,
  `item_doacaos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_campanha`
--

CREATE TABLE `item_campanha` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `campanha` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_doacao`
--

CREATE TABLE `item_doacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `campanha` int(11) DEFAULT NULL,
  `doacao` int(11) DEFAULT NULL,
  `item_campanha` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acao`
--
ALTER TABLE `acao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `campanha`
--
ALTER TABLE `campanha`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `campanha_acao`
--
ALTER TABLE `campanha_acao`
  ADD KEY `FK64c01rw3ltl2bugar16howiu` (`acao_id`),
  ADD KEY `FKt5f1d4b41wdjpcta3755t1t62` (`campanha_id`);

--
-- Indexes for table `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `colaborador_acao`
--
ALTER TABLE `colaborador_acao`
  ADD KEY `FKqkco4jmeoq27stn2jio0264vq` (`acao_id`),
  ADD KEY `FKlvcsp6qsxo30656vphrc919x` (`colaborador_id`);

--
-- Indexes for table `doacao`
--
ALTER TABLE `doacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr31x52edqhertv89phaaai5ef` (`colaborador`);

--
-- Indexes for table `doacao_item_doacaos`
--
ALTER TABLE `doacao_item_doacaos`
  ADD UNIQUE KEY `UK_8oj5ocuwb0plkrkebs4cp7rkq` (`item_doacaos`),
  ADD KEY `FKfmi4t16if2862fedd6n3swh0` (`doacao_id`);

--
-- Indexes for table `item_campanha`
--
ALTER TABLE `item_campanha`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK59joswxt0rteiyg7xnr8mo74p` (`campanha`);

--
-- Indexes for table `item_doacao`
--
ALTER TABLE `item_doacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKepijlvpoqbrmgyx6uki8ok12c` (`campanha`),
  ADD KEY `FKr6m1m6xiis3jst81x9a13w4bo` (`doacao`),
  ADD KEY `FK773tpdtquu00jyelvbg1psfga` (`item_campanha`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acao`
--
ALTER TABLE `acao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `campanha`
--
ALTER TABLE `campanha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `doacao`
--
ALTER TABLE `doacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `item_campanha`
--
ALTER TABLE `item_campanha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item_doacao`
--
ALTER TABLE `item_doacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `campanha_acao`
--
ALTER TABLE `campanha_acao`
  ADD CONSTRAINT `FK64c01rw3ltl2bugar16howiu` FOREIGN KEY (`acao_id`) REFERENCES `acao` (`id`),
  ADD CONSTRAINT `FKt5f1d4b41wdjpcta3755t1t62` FOREIGN KEY (`campanha_id`) REFERENCES `campanha` (`id`);

--
-- Limitadores para a tabela `colaborador_acao`
--
ALTER TABLE `colaborador_acao`
  ADD CONSTRAINT `FKlvcsp6qsxo30656vphrc919x` FOREIGN KEY (`colaborador_id`) REFERENCES `colaborador` (`id`),
  ADD CONSTRAINT `FKqkco4jmeoq27stn2jio0264vq` FOREIGN KEY (`acao_id`) REFERENCES `acao` (`id`);

--
-- Limitadores para a tabela `doacao`
--
ALTER TABLE `doacao`
  ADD CONSTRAINT `FKr31x52edqhertv89phaaai5ef` FOREIGN KEY (`colaborador`) REFERENCES `colaborador` (`id`);

--
-- Limitadores para a tabela `doacao_item_doacaos`
--
ALTER TABLE `doacao_item_doacaos`
  ADD CONSTRAINT `FKa1dcrsr86qmer9s0vn9qkwfic` FOREIGN KEY (`item_doacaos`) REFERENCES `item_doacao` (`id`),
  ADD CONSTRAINT `FKfmi4t16if2862fedd6n3swh0` FOREIGN KEY (`doacao_id`) REFERENCES `doacao` (`id`);

--
-- Limitadores para a tabela `item_campanha`
--
ALTER TABLE `item_campanha`
  ADD CONSTRAINT `FK59joswxt0rteiyg7xnr8mo74p` FOREIGN KEY (`campanha`) REFERENCES `campanha` (`id`);

--
-- Limitadores para a tabela `item_doacao`
--
ALTER TABLE `item_doacao`
  ADD CONSTRAINT `FK773tpdtquu00jyelvbg1psfga` FOREIGN KEY (`item_campanha`) REFERENCES `item_campanha` (`id`),
  ADD CONSTRAINT `FKepijlvpoqbrmgyx6uki8ok12c` FOREIGN KEY (`campanha`) REFERENCES `campanha` (`id`),
  ADD CONSTRAINT `FKr6m1m6xiis3jst81x9a13w4bo` FOREIGN KEY (`doacao`) REFERENCES `doacao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
