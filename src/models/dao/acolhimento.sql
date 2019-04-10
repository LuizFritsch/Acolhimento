-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `acolhimento`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaosus`
--

CREATE TABLE IF NOT EXISTS `cartaosus` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `numero` text NOT NULL,
  `cgs` text NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `cpf` text NOT NULL,
  `naturalidade` text NOT NULL,
  `nomemae` text NOT NULL,
  `datanascimento` text NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `profissoes`
--

CREATE TABLE IF NOT EXISTS `profissoes` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` longtext NOT NULL,
  `cbo` longtext NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `residencia`
--

CREATE TABLE IF NOT EXISTS `residencia` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `rua` text NOT NULL,
  `numero` text NOT NULL,
  `bairro` text NOT NULL,
  `cidade` text NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `profissao` FOREIGN KEY (`codigo`) REFERENCES `profissoes` (`codigo`),
  ADD CONSTRAINT `cartaosus` FOREIGN KEY (`codigo`) REFERENCES `cartaosus` (`codigo`),
  ADD CONSTRAINT `residencia` FOREIGN KEY (`codigo`) REFERENCES `residencia` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
